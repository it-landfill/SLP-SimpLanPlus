package SLP_ast.declarationNode;

import SLP_ast.ArgNode;
import SLP_ast.Node;
import SLP_ast.STentry;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * The FunNode class manages the "declaration: decFun;".
 * Allowing to save and manage the characteristics that define a function such as
 * return type, function identifier, input parameters, and the function body.
 */
public class FunNode implements Node {

    /**
     * Return type of the function.
     */
    private final Node returnType;
    /**
     * Function name (in the grammar defined as ID).
     */
    private final String funcName;
    /**
     * ArrayList of parameters of type ArgNode that the function needs in input.
     */
    private final ArrayList<ArgNode> params;
    /**
     * Node that contains the body of the function.
     */
    private final Node block;

    public FunNode(Node returnType, String funName, ArrayList<ArgNode> params, Node block) {
        this.returnType = returnType;
        this.funcName = funName;
        this.params = params;
        this.block = block;
    }

    @Override
    public String toPrint(String indent) {
        StringBuilder out = new StringBuilder();

        out.append(indent).append("function");
        if (returnType != null) out.append(returnType.toPrint(indent));
        else out.append(" void ");

        out.append(funcName);

        if (params != null && !params.isEmpty()) {
            out.append(" params ");
            for (Node n : params) {
                out.append(n.toPrint(indent));
            }
        }

        out.append("block ").append(block.toPrint(indent));

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
1
        // Generation of the entry for the symbol table.
        STentry entry = new STentry(env.nestingLevel, returnType, env.offset, funcName);
        // If the function has formal parameters, save the number of them in the entry.
        if (params != null) entry.setnArgs(params.size());
        else entry.setnArgs(0);
        // Attempt to add the entry to the symbol table. In case of failure, an error is reported.
        if (env.symbolTable.addToSymbolTable(entry))
            errors.add(new SemanticError("Fun " + funcName + " already declared"));
        // Increased nesting level and start analyzing formal parameters (if any).
        env.nestingLevel++;
        // Check arguments if there is at least one.
        if (params != null) {
            for (ArgNode a : params) {
                errors.addAll(a.checkSemantics(env));
                STentry tmp = new STentry(env.nestingLevel, a.getType(), env.offset, a.getArgName());
                if (env.symbolTable.addToSymbolTable(tmp))
                    errors.add(new SemanticError("arg " + a.getArgName() + " used multiple times"));
            }
        }
        // Check the body of the function.
        // NOTE: The symbol table of the block and the nesting level are handled in the semantic check of the block.
        if (block != null) errors.addAll(block.checkSemantics(env));
        // If the function has parameters, they are removed from the symbol table.
        // TODO: Verificare che non dia problemi il non eliminare in caso di nessun parametro per la funzione.
        if (params != null) env.symbolTable.removeLevelFromSymbolTable(env.nestingLevel);
        // Decreased nesting level.
        env.nestingLevel--;
        return errors;
    }
}
