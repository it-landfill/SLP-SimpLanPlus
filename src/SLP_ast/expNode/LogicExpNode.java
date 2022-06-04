package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.IntTypeNode;
import util.Environment;
import util.SemanticError;
import util.TypeChecking;

import java.util.ArrayList;

public class LogicExpNode implements Node {
	private final Node left;
	private final Node right;
	private final String op;

	public LogicExpNode(Node left, Node right, String op) {
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "LogicExp: " + left.toPrint(indent) + " op: " + op + right.toPrint(indent);
	}

	@Override
	public Node typeCheck() {
		if (! ( TypeChecking.isSubtype(left.typeCheck(),new BoolTypeNode()) &&
				TypeChecking.isSubtype(right.typeCheck(),new BoolTypeNode()) ) ) {
			System.out.println("Al compare (&&, ||) non sono associati i tipi corretti.");
			System.exit(0);
		}
		return new BoolTypeNode();
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