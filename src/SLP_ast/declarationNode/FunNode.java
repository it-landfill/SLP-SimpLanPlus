package SLP_ast.declarationNode;

import SLP_ast.ArgNode;
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

/**
 * The FunNode class manages the "declaration: decFun;".
 * Allowing to save and manage the characteristics that define a function such as
 * return type, function identifier, input parameters, and the function body.
 */
public class FunNode implements Node {

    /**
     * Function name (in the grammar defined as ID).
     */
    private final String funcName;

    private final FunctionSingatureType signature;
    /**
     * Node that contains the body of the function.
     */
    private final Node block;

    public FunNode(String funcName, FunctionSingatureType signature, Node block) {
        this.funcName = funcName;
        this.signature = signature;
        this.block = block;
    }

    @Override
    public String toPrint(String indent) {
        StringBuilder out = new StringBuilder();

        out.append(indent).append("function");
        if (signature.getReturnType() != null) out.append(signature.getReturnType().toPrint(indent));
        else out.append(" void ");

        out.append(funcName);

        if (signature.getArguments() != null && !signature.getArguments().isEmpty()) {
            out.append(" params ");
            for (Node n : signature.getArguments()) {
                out.append(n.toPrint(indent));
            }
        }

        out.append("block ").append(block.toPrint(indent));

        return out.toString();
    }

    @Override
    public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
        TypeNode blockReturnType = new VoidTypeNode();

        if (block != null) blockReturnType = block.typeCheck(symbolTable);
        if (!SLPUtils.checkTypes(signature.getReturnType(),blockReturnType)) throw new SLPUtils.TypeCheckError("Wrong return type");

        return signature.getReturnType();
    }

    @Override
    public String codeGeneration() {
        return "";
    }

    // TODO: Il prof dice che le funzioni non possono accedere a scope esterni.
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        // Generation of the entry for the symbol table.
        STentry entry = new STentry(env.nestingLevel, signature, env.offset, funcName, STentry.Effects.NONE);

        // Attempt to add the entry to the symbol table. In case of failure, an error is reported.
        if (env.symbolTable.addToSymbolTable(entry))
            errors.add(new SemanticError("Fun " + funcName + " already declared"));
        // Increased nesting level and start analyzing formal parameters (if any).
        env.nestingLevel++;

        // Check arguments if there is at least one and add them to the symbolTable
        if (signature.getArguments() != null) {
            for (ArgNode a : signature.getArguments()) {
                errors.addAll(a.checkSemantics(env));
                STentry tmp = new STentry(env.nestingLevel, a.getType(), env.offset, a.getArgName(), STentry.Effects.INITIALIZED);
                if (env.symbolTable.addToSymbolTable(tmp))
                    errors.add(new SemanticError("arg " + a.getArgName() + " used multiple times"));
            }
        }

        // Check the body of the function.
        // NOTE: The symbol table of the block and the nesting level are handled in the semantic check of the block.
        if (block != null) errors.addAll(block.checkSemantics(env));

        // If the function has parameters, they are removed from the symbol table.
        // TODO: Verificare che non dia problemi il non eliminare in caso di nessun parametro per la funzione.
        if (signature.getArguments() != null) env.symbolTable.removeLevelFromSymbolTable(env.nestingLevel);

        // Decreased nesting level.
        env.nestingLevel--;
        return errors;
    }
}
