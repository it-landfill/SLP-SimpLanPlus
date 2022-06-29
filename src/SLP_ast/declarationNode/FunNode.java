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
    private  Environment localEnv;
    private SymbolTableWrapper localSymbolTable;

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
    public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        localEnv = new Environment(); //FIXME: Rivedere logica localEnv e localSymbolTable
        localSymbolTable = new SymbolTableWrapper();

        // Generation of the entry for the symbol table.
        STentry entry = new STentry(Environment.getNestingLevel(), signature, -1, funcName, STentry.Effects.NONE);

        // Attempt to add the entry to the symbol table. In case of failure, an error is reported.
        if (localSymbolTable.addToSymbolTable(entry))
            errors.add(new SemanticError("Fun " + funcName + " already declared"));
        if (symbolTable.addToSymbolTable(entry))
            errors.add(new SemanticError("Fun " + funcName + " already declared"));
        // Increased nesting level and start analyzing formal parameters (if any).
        Environment.incrementNestingLevel();

        // Check arguments if there is at least one and add them to the symbolTable
        if (signature.getArguments() != null) {
            for (ArgNode a : signature.getArguments()) {
                errors.addAll(a.checkSemantics(localEnv, localSymbolTable));
                STentry tmp = new STentry(Environment.getNestingLevel(), a.getType(), -1, a.getArgName(), STentry.Effects.INITIALIZED);
                if (localSymbolTable.addToSymbolTable(tmp))
                    errors.add(new SemanticError("arg " + a.getArgName() + " used multiple times"));
                if (symbolTable.addToSymbolTable(tmp))
                    errors.add(new SemanticError("arg " + a.getArgName() + " used multiple times"));
            }
        }

        // Check the body of the function.
        // NOTE: The symbol table of the block and the nesting level are handled in the semantic check of the block.
        if (block != null) errors.addAll(block.checkSemantics(localEnv, localSymbolTable));

        // If the function has parameters, they are removed from the symbol table.
        if (signature.getArguments() != null) {
            localSymbolTable.removeLevelFromSymbolTable(Environment.getNestingLevel());
            symbolTable.removeLevelFromSymbolTable(Environment.getNestingLevel());
        }

        // Decreased nesting level.
        Environment.decrementNestingLevel();
        return errors;
    }

    @Override
    public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
        TypeNode blockReturnType = new VoidTypeNode();

        if (block != null) blockReturnType = block.typeCheck(localSymbolTable);
        if (!SLPUtils.checkTypes(signature.getReturnType(),blockReturnType) && SLPUtils.checkVoidType(blockReturnType)) throw new SLPUtils.TypeCheckError("Missing return in function " + funcName);
        if (!SLPUtils.checkTypes(signature.getReturnType(),blockReturnType)) throw new SLPUtils.TypeCheckError("Wrong return type");

        return signature.getReturnType();
    }

    @Override
    public String codeGeneration() {
        return "";
    }
}
