package SLP_ast;

import SLP_ast.declarationNode.FunNode;
import SLP_ast.declarationNode.VarNode;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
import SLP_ast.typeNode.VoidableTypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class BlockNode implements Node {

	private final ArrayList<Node> declarationList;
	private final ArrayList<Node> statementList;
	private final boolean isRoot;
	private int nestingLevel;
	private SymbolTableWrapper localSymbolTable;

	public BlockNode(ArrayList<Node> declarations, ArrayList<Node> statements, boolean isRoot) {
		this.isRoot = isRoot;
		declarationList = declarations;
		statementList = statements;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		return checkSemantics(env, symbolTable, true);
	}

	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable, boolean newEnv) {
		ArrayList<SemanticError> errors = new ArrayList<>();
		Environment localEnv;

		// This is necessary to handle the function body (since FunNode already generates a new environment).
		if (newEnv) {
			localEnv = new Environment();
			Environment.incrementNestingLevel();
		} else {
			localEnv = env;
		}


		nestingLevel = Environment.getNestingLevel();

		if (declarationList != null) {
			for (Node n : declarationList) if (n != null) errors.addAll(n.checkSemantics(localEnv, symbolTable));
		}

		if (statementList != null) {
			for (Node n : statementList) if (n != null) errors.addAll(n.checkSemantics(localEnv, symbolTable));
		}

		localSymbolTable = symbolTable.clone();

		symbolTable.removeLevelFromSymbolTable(nestingLevel);

		if (newEnv) Environment.decrementNestingLevel();

		return errors;
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		TypeNode retType = new VoidTypeNode(), tmp, voidableType = null;
		boolean isVoidable;

		if (symbolTable != null) localSymbolTable.update(symbolTable);

		for (Node decl : declarationList) {
			decl.typeCheck(localSymbolTable);
		}

		for (Node stm : statementList) {
			tmp = stm.typeCheck(localSymbolTable);

			if (SLPUtils.checkVoidableType(tmp)) {
				isVoidable = true;
				if (voidableType != null) {
					TypeNode tmpType = ((VoidableTypeNode) tmp).getAlternativeType();
					if (!SLPUtils.checkTypes(tmpType, voidableType))
						throw new SLPUtils.TypeCheckError("The types of the statements are not coherent. Type1: " + retType + "  Type2: " + tmp);
				} else {
					voidableType = ((VoidableTypeNode) tmp).getAlternativeType();
					tmp = voidableType;
				}
			} else isVoidable = false;

			if (!SLPUtils.checkTypes(retType, tmp) && !SLPUtils.checkVoidType(retType) && !SLPUtils.checkVoidType(tmp))
				throw new SLPUtils.TypeCheckError("The types of the statements are not coherent. Type1: " + retType + "  Type2: " + tmp);
			if (voidableType != null && !SLPUtils.checkTypes(voidableType, tmp) && !SLPUtils.checkVoidType(tmp))
				throw new SLPUtils.TypeCheckError("The types of the statements are not coherent. Type1: " + voidableType + "  Type2: " + tmp);

			if (!SLPUtils.checkTypes(retType, tmp) && !SLPUtils.checkVoidType(tmp) && !isVoidable) {
				retType = tmp;
			}

		}

		String unused = localSymbolTable.findUnused(nestingLevel);
		if (!unused.equals("")) System.out.println(unused);

		if (symbolTable != null) symbolTable.update(localSymbolTable);

		return (isRoot ? new VoidTypeNode() : retType);
	}

	// DFS Postfix visit (sx child -> dx child -> node)
	@Override
	public String codeGeneration(String options) {
		return codeGeneration(true);
	}

	public String codeGeneration(boolean newEnv) {
		StringBuilder sb = new StringBuilder();

		int occupiedBytes = localSymbolTable.nestingLevelRequiredBytes(nestingLevel);
		String blockLabel = SLPUtils.newLabel("block");

		if (newEnv) {
			sb.append("; Begin environment\n");
			sb.append("pushw $fp\n");
			if (occupiedBytes > 0) sb.append("subi $sp $sp ").append(occupiedBytes).append("\n");
			else sb.append("; subi $sp $sp ").append(occupiedBytes).append(" (Not needed since value is 0)\n");
			sb.append("mov $fp $sp\n");
			sb.append("; End environment header\n");
		}

		// Generate first the code for all the functions in the block.
		if (declarationList.stream().anyMatch(decl -> decl instanceof FunNode)) {
			// Jump to after the function code.
			sb.append("jal ").append(blockLabel).append("\n");
			declarationList.stream().filter(decl -> decl instanceof FunNode).forEach(declaration -> sb.append(declaration.codeGeneration(null)));
			sb.append(blockLabel).append(":\n");
		}

		// After the functions, generate code for the declared variables
		declarationList.stream().filter(decl -> decl instanceof VarNode).forEach(declaration -> sb.append(declaration.codeGeneration(null)));

		statementList.forEach(statement -> sb.append(statement.codeGeneration(null)));

		if (newEnv) {
			boolean ret_placeholder = sb.toString().contains("RETURN_CHAIN_PLACEHOLDER") || sb.toString().contains("BLOCK_CHAIN_PLACEHOLDER");
			sb.append("; Begin environment footer\n");
			if (ret_placeholder) {
				sb.append(blockLabel).append("_footer:\n");
				SLPUtils.SBReplaceAll(sb, "(BLOCK_CHAIN_PLACEHOLDER)|(RETURN_CHAIN_PLACEHOLDER)", blockLabel + "_footer");
			}

			if (occupiedBytes > 0) sb.append("addi $sp $sp ").append(occupiedBytes).append("\n");
			else sb.append("; addi $sp $sp ").append(occupiedBytes).append(" (Not needed since value is 0)\n");
			sb.append("popw $fp\n");

			if (ret_placeholder) {
				sb.append("li $t1 0\n");
				sb.append("beq $ret $t1 ").append(blockLabel).append("_ret\n");
				sb.append("jal BLOCK_CHAIN_PLACEHOLDER\n");
				sb.append(blockLabel).append("_ret:\n");
			}

			sb.append("; End environment\n");
		}

		if (isRoot) sb.append("halt\n");
		return sb.toString();
	}
}