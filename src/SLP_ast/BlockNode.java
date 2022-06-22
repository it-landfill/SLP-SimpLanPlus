package SLP_ast;

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
	private SymbolTableWrapper localSymbolTable;

	public BlockNode(ArrayList<Node> declarations, ArrayList<Node> statements, boolean isRoot) {
		this.isRoot = isRoot;
		declarationList = declarations;
		statementList = statements;
	}

	@Override
	public String toPrint(String indent) {

		StringBuilder declStr = new StringBuilder();
		StringBuilder statStr = new StringBuilder();

		for (Node dec : declarationList)
			declStr.append(dec.toPrint(indent + "  "));

		for (Node sta : statementList)
			statStr.append(sta.toPrint(indent + "  "));

		return indent + "\nBlock\n\t" + declStr + "\t" + statStr + indent + "End Block";
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		TypeNode retType = new VoidTypeNode(), tmp, voidableType = null;
		boolean isVoidable;

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
						throw new SLPUtils.TypeCheckError("The types of the statements are not coherent. Type1: " + retType.toPrint("") + "  Type2: " + tmp.toPrint(""));
				} else {
					voidableType = ((VoidableTypeNode) tmp).getAlternativeType();
					tmp = voidableType;
				}
			} else isVoidable = false;

			if (!SLPUtils.checkTypes(retType, tmp) && !SLPUtils.checkVoidType(retType) && !SLPUtils.checkVoidType(tmp))
				throw new SLPUtils.TypeCheckError("The types of the statements are not coherent. Type1: " + retType.toPrint("") + "  Type2: " + tmp.toPrint(""));
			if (voidableType != null && !SLPUtils.checkTypes(voidableType, tmp) && !SLPUtils.checkVoidType(tmp))
				throw new SLPUtils.TypeCheckError("The types of the statements are not coherent. Type1: " + voidableType.toPrint("") + "  Type2: " + tmp.toPrint(""));

			if (!SLPUtils.checkTypes(retType, tmp) && !SLPUtils.checkVoidType(tmp) && !isVoidable) {
				retType = tmp;
			}

		}

		if (symbolTable != null) symbolTable.update(localSymbolTable);

		return (isRoot ? new VoidTypeNode() : retType);
	}

	// Visita in DFS postfissa (figlio sx - figlio dx - nodo)
	@Override
	public String codeGeneration() {

		StringBuilder sb = new StringBuilder();
		declarationList.forEach(declaration -> sb.append(declaration.codeGeneration()));
		statementList.forEach(statement -> sb.append(statement.codeGeneration()));
		return sb.toString();
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		env.nestingLevel++;

		if (declarationList != null) {
			for (Node n : declarationList) if (n != null) errors.addAll(n.checkSemantics(env));
		}

		if (statementList != null) {
			for (Node n : statementList) if (n != null) errors.addAll(n.checkSemantics(env));
		}

		localSymbolTable = env.symbolTable.clone();

		env.symbolTable.removeLevelFromSymbolTable(env.nestingLevel);
		env.nestingLevel--;

		return errors;
	}
}
