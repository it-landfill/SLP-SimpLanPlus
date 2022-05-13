package SLP_ast.expNode;

import SLP_ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class CompareExpNode implements Node {
	private final Node left;
	private final Node right;
	private final String op;

	public CompareExpNode(Node left, Node right, String op) {
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "CompareExp: " + left.toPrint(indent) + " op: " + op + right.toPrint(indent);
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
			case ">" -> out.append("gt");
			case ">=" -> out.append("gte");
			case "<" -> out.append("lt");
			case "<=" -> out.append("lte");
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