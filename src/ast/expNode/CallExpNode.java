package ast.expNode;

import ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class CallExpNode implements Node {
	private final Node funName;

	public CallExpNode(Node call) {
		this.funName = call;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "callExp: " + funName.toPrint(indent);
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
		return funName.checkSemantics(env);
	}
}
