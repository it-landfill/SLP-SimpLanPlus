package SLPAst.statementNode;

import SLPAst.Node;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;

import java.util.ArrayList;

public class ITENode implements Node {
	private final Node condition;
	private final Node ifTrue;
	private final Node ifFalse;

	public ITENode(Node condition, Node ifTrue) {
		this(condition, ifTrue, null);
	}

	public ITENode(Node condition, Node ifTrue, Node ifFalse) {
		this.condition = condition;
		this.ifTrue = ifTrue;
		this.ifFalse = ifFalse;
	}

	@Override
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();
		out.append(indent).append("IF ").append(condition.toPrint(indent)).append(" THEN ").append(ifTrue.toPrint(indent));
		if (ifFalse != null) out.append(" ELSE ").append(ifFalse.toPrint(indent));
		return out.toString();
	}

	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		StringBuilder out = new StringBuilder();
		String l1 = SLPUtils.newLabel(),l2 = SLPUtils.newLabel();

		out.append(condition.codeGeneration());
		out.append("push 0\n");
		out.append("beq").append(l1).append("\n");
		out.append(ifTrue.codeGeneration());
		out.append("b ").append(l2).append("\n");
		out.append(l1).append(":\n");
		out.append(ifFalse.codeGeneration());
		out.append(l2).append(":\n");
		return out.toString();
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		errors.addAll(condition.checkSemantics(env));
		errors.addAll(ifTrue.checkSemantics(env));
		if (ifFalse != null) errors.addAll(ifFalse.checkSemantics(env));

		return errors;
	}
}
