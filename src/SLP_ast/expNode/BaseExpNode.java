package SLP_ast.expNode;

import SLP_ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class BaseExpNode implements Node {
	private final Node exp;

	public BaseExpNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent) {
		return indent + " exp: " + exp.toString();
	}

	@Override
	public Node typeCheck() {
		return null;
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
