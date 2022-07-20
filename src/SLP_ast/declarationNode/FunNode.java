package SLP_ast.declarationNode;

import SLP_ast.ArgNode;
import SLP_ast.BlockNode;
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
    private final BlockNode block;
    private  Environment localEnv;
    private SymbolTableWrapper localSymbolTable;

    public FunNode(String funcName, FunctionSingatureType signature, Node block) {
        this.funcName = funcName;
        this.signature = signature;
        this.signature.setLabel(SLPUtils.newLabel(funcName));
        if (block instanceof BlockNode) this.block = (BlockNode) block;
        else {
            System.out.println("[INTERNAL ERROR] Unable to convert block to BlockNode");
            this.block = null;
        }
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
                STentry tmp = new STentry(Environment.getNestingLevel(), a.getType(), localEnv.getOffset(), a.getArgName(), STentry.Effects.INITIALIZED);
                if (SLPUtils.checkIntType(a.getType())) localEnv.offsetAddInt();
                else localEnv.offsetAddBool();
                if (localSymbolTable.addToSymbolTable(tmp))
                    errors.add(new SemanticError("arg " + a.getArgName() + " used multiple times"));
                if (symbolTable.addToSymbolTable(tmp))
                    errors.add(new SemanticError("arg " + a.getArgName() + " used multiple times"));
            }
        }

        // Check the body of the function.
        // NOTE: The symbol table of the block and the nesting level are handled in the semantic check of the block.
        if (block != null) errors.addAll(block.checkSemantics(localEnv, localSymbolTable, false));

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
        StringBuilder sb = new StringBuilder();
        int n = 0;
        if (signature.getArguments() != null) {
            for (ArgNode arg : signature.getArguments()) {
                if (SLPUtils.checkIntType(arg.getType())) n += 4;
                else n += 1;
            }
        }

        sb.append("; Begin function\n");
        sb.append(signature.getLabel()).append(":\n");

        sb.append("mov $fp $sp\n");
        sb.append("pushw $ra\n");

        sb.append("; End function header\n");

        sb.append(block.codeGeneration(false)); //TODO: Gestire return value

        sb.append("; Begin function footer\n");
        sb.append("popw $ra\n");
        if (n > 0) sb.append("addi $sp $sp ").append(n).append("\n");
        else sb.append("; addi $sp $sp ").append(n).append(" (Not needed since value is 0)\n");
        sb.append("popw $fp\n");
        sb.append("jr $ra\n");
        sb.append("; End function\n");

        return sb.toString();
    }
}

/*
 * sp
 * $ra   fp
 * e_0
 * e_1
 * e_2
 * e_3
 * old_fp
 */

/*
 * void a(int b) {
 *      CHECKPOINT
 *      print(b)
 * }
 *
 * a(5)
 */

/*
 * 5
 * fun
 * ind
 */


/*
 * a_1:
 *  mov $fp $sp
 *  push $ra
 *
 * ; Begin Env
 *  push $fp
 *  mov $fp $sp
 *  subi $sp $sp k
 *
 *
 *
 *  mov $t1 $fp
 *  lw $t0 0($t1)
 *  print $t0
 *
 *  addi $sp $sp k
 *  pop $fp
 *  ; end env
 *
 *  top $ra
 *  addi $sp $sp k
 *  pop $fp
 *  jr $ra
 *
 *
 *  push $fp
 *  li $a0 5
 *  push $a0
 *  mov $ra $ip
 *  addi $ra $ra 3
 *  jal a_1
 */