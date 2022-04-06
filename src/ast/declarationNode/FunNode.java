package ast.declarationNode;

import ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FunNode implements Node {
	private final Node returnType;
	private final String funcName;
	private final ArrayList<Node> params;
	private final Node block;

	public FunNode(Node returnType, String funName, ArrayList<Node> params, Node block) {
		this.returnType = returnType;
		this.funcName = funName;
		this.params = params;
		this.block = block;
	}

	@Override
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();

		out.append(indent).append("function");
		if (returnType != null) out.append(returnType.toPrint(indent));
		else out.append(" void ");

		out.append(funcName);

		if (params != null && !params.isEmpty()) {
			out.append(" params ");
			for (Node n : params) {
				out.append(n.toPrint(indent));
			}
		}

		out.append("block ").append(block.toPrint(indent));

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
