package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.IntTypeNode;
import util.Environment;
import util.SemanticError;
import util.TypeChecking;

import java.util.ArrayList;

public class NotExpNode implements Node {

	private final Node exp;

	public NotExpNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent) {
		return indent + " not: " + exp.toString();
	}

	@Override
	public Node typeCheck() {
		if (!(TypeChecking.isSubtype(exp.typeCheck(), new BoolTypeNode()))) {
			System.out.println("Al not (!) non è associato un tipo boolean.");
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
		return exp.checkSemantics(env);
	}
}