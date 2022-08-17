package SLP_ast.declarationNode;

import SLP_ast.Node;
import SLP_ast.STentry;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

/**
 * The VarNode class manages the "declaration: decVar;".
 * Allowing to save and manage the characteristics that define a variable declaration and assignment
 * such as type, variable identifier, and the value.
 */
public class VarNode implements Node {
	/**
	 * Variable name.
	 */
	private final String ID;
	/**
	 * Variable type.
	 */
	private final TypeNode type;
	/**
	 * Expression to be assigned to the variable
	 */
	private final Node exp;
	private STentry entry;

	public VarNode(String ID, TypeNode type, Node exp) {
		this.ID = ID;
		this.type = type;
		this.exp = exp;
	}

	public VarNode(String ID, TypeNode type) {
		this(ID, type, null);
	}

	@Override
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();
		out.append(indent).append("var: ").append(type.toPrint(indent)).append(" ").append(ID);
		if (exp != null) out.append(" ").append(exp.toPrint(indent));
		return out.toString();
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		ArrayList<SemanticError> errors = new ArrayList<>();
		// Generation of the entry for the symbol table.

		entry = new STentry(Environment.getNestingLevel(), type, env.getOffset(), ID, (exp == null ? STentry.Effects.DECLARED : STentry.Effects.INITIALIZED));

		if (SLPUtils.checkIntType(type)) env.offsetAddInt();
		else env.offsetAddBool();

		// Attempt to add the entry to the symbol table. In case of failure, an error is reported.
		if (symbolTable.addToSymbolTable(entry)) errors.add(new SemanticError("Var " + ID + " already declared."));
		// Semantic check of the expression (if any).
		if (exp != null) errors.addAll(exp.checkSemantics(env, symbolTable));
		return errors;
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {

        if (exp != null) {
            TypeNode expType = exp.typeCheck(symbolTable);
            if (!(SLPUtils.checkTypes(expType, type))) {
                throw new SLPUtils.TypeCheckError("The variable " + ID + " you’re assigning to is of a different type than the expression in the assignment. Expected " + type + ", got " + expType + ".");
            }
        }

		return new VoidTypeNode();
	}

	@Override
	public String codeGeneration(String options) {
		if (exp != null) {

            return "; Begin decl-assignment variable " + ID + "\n" +
                    exp.codeGeneration(options) +
                    (SLPUtils.checkIntType(type) ? "sw" : "sb") + " $t0 " + entry.getOffset() + "($fp)\n" +
                    "; End decl-assignment variable " + ID + "\n";
		}

		return "";
	}
}
