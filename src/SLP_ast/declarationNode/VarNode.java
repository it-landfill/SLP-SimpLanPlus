package SLP_ast.declarationNode;

import SLP_ast.Node;
import SLP_ast.STentry;
import util.Environment;
import util.SemanticError;

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
    private final Node type;
    /**
     * Expression to be assigned to the variable
     */
    private final Node exp;

    public VarNode(String ID, Node type, Node exp) {
        this.ID = ID;
        this.type = type;
        this.exp = exp;
    }

    public VarNode(String ID, Node type) {
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
    public Node typeCheck() {
        return null;
    }

    @Override
    public String codeGeneration() {
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        // Generation of the entry for the symbol table.

        STentry entry = new STentry(env.nestingLevel, type, env.offset, ID, (exp == null ? STentry.Effects.DECLARED : STentry.Effects.INITIALIZED)); //TODO: Chiedere prof se va fatto qua o in type Check l'inizializzazione degli effect
        // Attempt to add the entry to the symbol table. In case of failure, an error is reported.
        if (env.symbolTable.addToSymbolTable(entry))
            errors.add(new SemanticError("Var " + ID + " already declared"));
        // Semantic check of the expression (if any).
        if (exp != null) errors.addAll(exp.checkSemantics(env));
        return errors;
    }
}
