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

	/**
	 * Function signature, contains ID, ReturnType and ArgList
	 */
	private final FunctionSingatureType signature;

	/**
	 * Node that contains the body of the function.
	 */
	private final BlockNode block;

	private SymbolTableWrapper localSymbolTable;

	public FunNode(String funcName, FunctionSingatureType signature, Node block) {
		this.funcName = funcName;
		this.signature = signature;
		this.signature.setLabel(SLPUtils.newLabel(funcName));

		// Cast to block node to access class specific methods.
		if (block instanceof BlockNode) this.block = (BlockNode) block;
		else {
			System.out.println("[INTERNAL ERROR] Unable to convert block to BlockNode.");
			this.block = null;
		}
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		// Initialize a new env and symbol table.
		Environment localEnv = new Environment();
		localSymbolTable = new SymbolTableWrapper();

		// Align the localSymbolTable with the global one.
		localSymbolTable.cloneFunctions(symbolTable);

		// Generate the function STEntry to be added to the symbol table.
		STentry entry = new STentry(Environment.getNestingLevel(), signature, -1, funcName, STentry.Effects.NONE);

		// Attempt to add the entry to the symbol table. In case of failure, an error is reported.
		if (localSymbolTable.addToSymbolTable(entry))
			errors.add(new SemanticError("Fun " + funcName + " already declared."));
		if (symbolTable.addToSymbolTable(entry))
			errors.add(new SemanticError("Fun " + funcName + " already declared."));

		// Increased nesting level and start analyzing formal parameters (if any).
		Environment.incrementNestingLevel();

		// Check formal parameters if there is at least one and add them to the symbolTable
		if (signature.getArguments() != null) {

			// For each argument, check the semantics and add them to the symbolTable
			for (ArgNode a : signature.getArguments()) {
				errors.addAll(a.checkSemantics(localEnv, localSymbolTable));
				// STEntry of the arg
				STentry tmp = new STentry(Environment.getNestingLevel(), a.getType(), localEnv.getOffset(), a.getArgName(), STentry.Effects.INITIALIZED, a.isByReference());

				// Increase the offset in the env based on the arg type.
				if (SLPUtils.checkIntType(a.getType())) localEnv.offsetAddInt();
				else localEnv.offsetAddBool();

				// Add the arg to the symbol table.
				if (localSymbolTable.addToSymbolTable(tmp))
					errors.add(new SemanticError("arg " + a.getArgName() + " used multiple times."));
				if (symbolTable.addToSymbolTable(tmp))
					errors.add(new SemanticError("arg " + a.getArgName() + " used multiple times."));
			}
		}

		// Evaluate the body of the function.
		// NOTE: The symbol table of the block and the nesting level are handled in the semantic check of the block.
		// newEnv = false tells BlockNode to not generate a new environment.
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

		// Evaluate the return type of the BlockNode.
		if (block != null) blockReturnType = block.typeCheck(localSymbolTable);

		// Check if the return type of the BlockNode is compatible with the function return type.
		if (!SLPUtils.checkTypes(signature.getReturnType(), blockReturnType)) {
			if (SLPUtils.checkVoidType(blockReturnType))
				throw new SLPUtils.TypeCheckError("Missing return in function " + funcName + ".");
			else
				throw new SLPUtils.TypeCheckError("Wrong return type. Expected " + signature.getReturnType() + ", found " + blockReturnType + " in function " + funcName + ".");
		}

		return signature.getReturnType();
	}

	@Override
	public String codeGeneration(String options) {
		StringBuilder sb = new StringBuilder();

		// Evaluate the needed bytes for the function parameters.
		int n = 0;
		if (signature.getArguments() != null) {
			for (ArgNode arg : signature.getArguments()) {
				if (SLPUtils.checkIntType(arg.getType()) || arg.isByReference()) n += 4;
				else n += 1;
			}
		}

		sb.append("; Begin function\n");
		// Generate the function label.
		sb.append(signature.getLabel()).append(":\n");
		sb.append("mov $fp $sp\n");
		sb.append("pushw $ra\n");
		sb.append("; End function header\n");

		sb.append(block.codeGeneration(false));

		sb.append("; Begin function footer\n");
		// Generate the footer label for the return statement.
		sb.append(signature.getLabel()).append("_footer:\n");
		sb.append("popw $ra\n");
		if (n > 0) sb.append("addi $sp $sp ").append(n).append("\n");
		else sb.append("; addi $sp $sp ").append(n).append(" (Not needed since value is 0)\n");
		sb.append("popw $fp\n");

		// Return chain. See documentation chapter 5.3.2
		boolean ret_placeholder = sb.toString().contains("RETURN_CHAIN_PLACEHOLDER") || sb.toString().contains("BLOCK_CHAIN_PLACEHOLDER");
		if (ret_placeholder) {
			SLPUtils.SBReplaceAll(sb, "(BLOCK_CHAIN_PLACEHOLDER)|(RETURN_CHAIN_PLACEHOLDER)", signature.getLabel() + "_footer");
			sb.append("li $ret 0\n");
		}

		sb.append("jr $ra\n");
		sb.append("; End function\n");

		return sb.toString();
	}
}