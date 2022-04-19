package ast.expNode;

import ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ValExpNode implements Node {
	private final int val;

	public ValExpNode(int val) {
		this.val = val;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "val: " + val;
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