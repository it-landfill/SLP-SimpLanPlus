package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.STentry;
import SLP_ast.typeNode.FunctionSingatureType;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class AssignmentNode implements Node {
	private final String ID;
	private final Node exp;
	private STentry entry;
	private int nestinglevel;
	private int stOccupiedBytes;

	public AssignmentNode(String ID, Node exp) {
		this.ID = ID;
		this.exp = exp;
	}
	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		ArrayList<SemanticError> errors = new ArrayList<>();
		nestinglevel = Environment.getNestingLevel();
		entry = symbolTable.findFirstInSymbolTable(ID);
		if (entry == null) {
			errors.add(new SemanticError("Var " + ID + " not declared."));
		} else if (entry.getType() instanceof FunctionSingatureType) {
			errors.add(new SemanticError(ID + " is a function, not a variable. You can't assign value to a function."));
		}

		errors.addAll(exp.checkSemantics(env, symbolTable));

		stOccupiedBytes = symbolTable.nestingLevelRequiredBytes(Environment.getNestingLevel());

		return errors;
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		entry = symbolTable.findInSymbolTable(ID, entry.getNestinglevel()); // Mi serve perchè copio le symbolTable
		if (entry == null) {
			throw new SLPUtils.TypeCheckError("Variable not declared: " + ID + ".");
		}

		TypeNode expType = exp.typeCheck(symbolTable);
		TypeNode entryType = entry.getType();
		if (!(SLPUtils.checkTypes(expType, entryType))) {
			throw new SLPUtils.TypeCheckError("The variable " + ID + " you’re assigning to is of a different type than the expression in the assignment. Expected " + entryType + ", got " + expType + ".");
		}
		if (entry.getEffect() == STentry.Effects.DECLARED) entry.setEffect(STentry.Effects.INITIALIZED);

		return new VoidTypeNode();
	}

	@Override
	public String codeGeneration(String options) {
		StringBuilder out = new StringBuilder();

		out.append("; Begin assignment variable ").append(ID).append("\n");
		out.append(exp.codeGeneration(options));

		out.append("mov $t1 $fp\n");
		out.append(("lw $t1 " + (stOccupiedBytes + 1) + "($t1)\n").repeat(nestinglevel - entry.getNestinglevel()));

		if (entry.isReference()) {
			out.append("lw $t1 ").append(entry.getOffset()).append("($t1)\n");
			out.append(SLPUtils.checkIntType(entry.getType()) ? "sw" : "sb").append(" $t0 ").append("0($t1)\n");
		} else {
			out.append(SLPUtils.checkIntType(entry.getType()) ? "sw" : "sb").append(" $t0 ").append(entry.getOffset()).append("($t1)\n");
		}
		out.append("; End assignment variable ").append(ID).append("\n");

		return out.toString();
	}
}
