package ast.statementNode;

import ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class PrintNode implements Node {
	private final Node exp;

	public PrintNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "print: " + exp.toPrint(indent);
	}

	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		return null;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return null;
	}
}
