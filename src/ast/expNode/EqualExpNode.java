package ast.expNode;

import ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class EqualExpNode implements Node {
	private final Node left;
	private final Node right;
	private final String op;

	public EqualExpNode(Node left, Node right, String op) {
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "EqualExp: " + left + op + right;
	}

	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		StringBuilder out = new StringBuilder();
		out.append(left.codeGeneration());
		out.append(right.codeGeneration());
		switch (op) {
			case "==" -> out.append("eq");
			case "!=" -> out.append("neq");
		}
		out.append("\n");
		return out.toString();
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		errors.addAll(left.checkSemantics(env));
		errors.addAll(right.checkSemantics(env));

		return errors;
	}
}