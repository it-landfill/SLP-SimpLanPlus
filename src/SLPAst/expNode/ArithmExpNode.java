package SLPAst.expNode;

import SLPAst.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ArithmExpNode implements Node {
	private final Node left;
	private final Node right;
	private final String op;

	public ArithmExpNode(Node left, Node right, String op) {
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "AritmExp: " + left + op + right;
	}

	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		String str = left.codeGeneration()+right.codeGeneration();
		switch (op) {
			case "+" -> str += "add\n";
			case "-" -> str += "sub\n";
			case "*" -> str += "mul\n";
			case "/" -> str += "div\n";
		}
		return str;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		errors.addAll(left.checkSemantics(env));
		errors.addAll(right.checkSemantics(env));

		return errors;
	}
}