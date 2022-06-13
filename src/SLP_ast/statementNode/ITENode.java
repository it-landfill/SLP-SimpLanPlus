package SLP_ast.statementNode;

import SLP_ast.Node;
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
		StringBuilder sb = new StringBuilder();
		String trueLabel = SLPUtils.newLabel("ifTrue");
		String endLabel = SLPUtils.newLabel("ifEnd");

		// Controllo condizione
		sb.append(condition.codeGeneration()); // La codegen di una exp booleana salva in $t0 il risultato
		sb.append("li $t1 1\n");
		sb.append("beq $t0 $t1 ").append(trueLabel).append("\n");

		// False branch
		sb.append(ifFalse.codeGeneration());
		sb.append("jal ").append(endLabel).append("\n");

		// True branch
		sb.append(trueLabel).append(":\n");
		sb.append(ifTrue.codeGeneration());
		sb.append(endLabel).append(":\n");

		return sb.toString();
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
