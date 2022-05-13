package SLPAst.statementNode;

import SLPAst.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ReturnNode implements Node {
	private final Node exp;

	public ReturnNode(Node exp) {
		this.exp = exp;
	}

	public ReturnNode() {
		this.exp = null;
	}

	@Override
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();
		out.append(indent).append("return");
		if (exp != null) out.append(" ").append(exp.toPrint(indent));
		return out.toString();
	}

	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		if(exp != null) {
			return exp.codeGeneration() + "TODO: Return";
		} else {
			return "TODO: Return";
		}
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		if (exp != null) {
			return exp.checkSemantics(env);
		} else {
			return new ArrayList<>();
		}
	}
}
