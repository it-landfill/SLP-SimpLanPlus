package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.IntTypeNode;
import util.Environment;
import util.SemanticError;
import util.TypeChecking;

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
		return indent + "AritmExp: " + left.toPrint(indent) + " op: " + op + right.toPrint(indent)+"\n";
	}

	@Override
	public Node typeCheck() {
		if (! ( TypeChecking.isSubtype(left.typeCheck(),new IntTypeNode()) &&
				TypeChecking.isSubtype(right.typeCheck(),new IntTypeNode()) ) ) {
			System.out.println("Al compare (+, -, *, /) non sono associati i tipi corretti.");
			System.exit(0);
		}
		return new IntTypeNode();
	}

	@Override
	public String codeGeneration() {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		errors.addAll(left.checkSemantics(env));
		errors.addAll(right.checkSemantics(env));

		return errors;
	}
}