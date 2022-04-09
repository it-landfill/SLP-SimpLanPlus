package ast;

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

		//FIXME: Posso unire queste due variabili in una sola?
		StringBuilder declStr = new StringBuilder();
		StringBuilder statStr = new StringBuilder();

		for (Node dec : declarationList)
			declStr.append(dec.toPrint(indent + "  "));

		for (Node dec : statementList)
			statStr.append(dec.toPrint(indent + "  "));

		return indent + "\nBlock\n\t" + declStr + "\t" + statStr;
	}

	@Override
	public Node typeCheck() {
		System.out.println("BlockNode - typeCheck");
		return null;
	}

	@Override
	public String codeGeneration() {
		System.out.println("BlockNode - codeGeneration");
		return null;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		System.out.println("BlockNode - checkSemantics");
		return null;
	}
}
