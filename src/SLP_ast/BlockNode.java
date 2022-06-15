package SLP_ast;

import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;

import java.util.ArrayList;

public class BlockNode implements Node {

	private final ArrayList<Node> declarationList;
	private final ArrayList<Node> statementList;
	private final boolean isRoot;

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
	public TypeNode typeCheck() throws SLPUtils.TypeCheckError{
		TypeNode retType = new VoidTypeNode(), tmp;

		for (Node decl: declarationList) {
			decl.typeCheck();
		}

		for (Node stm: statementList) {
			tmp = stm.typeCheck();

			if(!SLPUtils.checkTypes(retType, tmp) && !SLPUtils.checkVoidType(retType)){
				if (!SLPUtils.checkVoidType(tmp)) throw new SLPUtils.TypeCheckError("The type of the statements is not coherent.");
			} else if(!SLPUtils.checkVoidType(tmp))	retType = tmp;

		}

		return (isRoot ? new VoidTypeNode() : retType);
	}

	// Visita in DFS postfissa (figlio sx - figlio dx - nodo)
	@Override
	public String codeGeneration() {
		return "";
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


		env.symbolTable.removeLevelFromSymbolTable(env.nestingLevel);
		env.nestingLevel--;

		return errors;
	}
}
