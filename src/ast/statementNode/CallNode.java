package ast.statementNode;

import ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class CallNode implements Node {
	private final String funcName;
	private final ArrayList<Node> params;

	public CallNode(String funcName, ArrayList<Node> params) {
		this.funcName = funcName;
		this.params = params;
	}

	public CallNode(String funcName) {
		this.funcName = funcName;
		params = null;
	}

	@Override
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();

		out.append(indent).append("call").append(funcName);

		if (params!=null && !params.isEmpty()) {
			out.append(" params ");
			for (Node n : params) {
				out.append(n.toPrint(indent));
			}
		}

		return out.toString();
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
