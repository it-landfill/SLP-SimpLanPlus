package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.IntTypeNode;
import util.Environment;
import util.SLPUtils;
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
		if (! ( SLPUtils.checkIntType(left.typeCheck()) &&
				SLPUtils.checkIntType(right.typeCheck()) ) ) {
			System.out.println("Al compare (>=, <=, >, <) non sono associati i tipi corretti.");
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