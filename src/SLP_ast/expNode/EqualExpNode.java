package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import util.Environment;
import util.SLPUtils;
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
		return indent + "EqualExp: " + left.toPrint(indent) + " op: " + op + right.toPrint(indent);
	}

	@Override
	public Node typeCheck() {
		Node leftType = left.typeCheck();
		Node rightType = right.typeCheck();
		if (! SLPUtils.checkTypes(leftType, rightType)) {
			System.out.println("Al eq (==) o neq (!=) non sono associati i tipi corretti.");
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