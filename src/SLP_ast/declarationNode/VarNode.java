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
        if (symbolTable.addToSymbolTable(entry))
            errors.add(new SemanticError("Var " + ID + " already declared"));
        // Semantic check of the expression (if any).
        if (exp != null) errors.addAll(exp.checkSemantics(env, symbolTable));
        return errors;
    }

    @Override
    public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {

        if (exp != null && !(SLPUtils.checkTypes(exp.typeCheck(symbolTable), type))) {
            throw new SLPUtils.TypeCheckError("L'espressione con cui si intende inizializzare la variabile " + ID + " non  è del tipo corretto." );
        }

        return new VoidTypeNode();
    }

    @Override
    public String codeGeneration() {
        if(exp != null) {
            return exp.codeGeneration() +
                    "sw $t0 " + entry.getOffset() + "($fp)\n";
        }

        return "";
    }
}
