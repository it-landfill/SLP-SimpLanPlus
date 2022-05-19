package SLP_ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class BlockNode implements Node {

	private final ArrayList<Node> declarationList;
	private final ArrayList<Node> statementList;

	public BlockNode(ArrayList<Node> declarations, ArrayList<Node> statements) {
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
	public Node typeCheck() {
		return null;
	}

	// Visita in DFS postfissa (figlio sx - figlio dx - nodo)
	@Override
	public String codeGeneration() {
		StringBuilder declCde = new StringBuilder();
		StringBuilder statCde = new StringBuilder();

		for (Node dec : declarationList)
			declCde.append(dec.codeGeneration());

		for (Node sta : statementList)
			statCde.append(sta.codeGeneration());

		return declCde.toString()+statCde.toString()+"halt\n";
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
