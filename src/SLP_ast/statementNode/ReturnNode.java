package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
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
	public TypeNode typeCheck() {
		// TODO: Sicuramente da rivedere
		if (exp != null) return exp.typeCheck();
		return new VoidTypeNode();
	}

	@Override
	public String codeGeneration() {
		return "";
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
