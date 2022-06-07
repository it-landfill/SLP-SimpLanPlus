package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
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
	public TypeNode typeCheck() {
		TypeNode returnTrueType;
		if(!SLPUtils.checkBoolType(condition.typeCheck())) {
			System.out.println("Nella condizione dell'If non è associato un tipo boolean.");
			System.exit(0);
		}
		returnTrueType = ifTrue.typeCheck();
		if (ifFalse != null){
			if(!SLPUtils.checkTypes(returnTrueType, ifFalse.typeCheck())){
				System.out.println("Nella condizione dell'If non è associato il tipo corretto per i branch.");
				System.exit(0);
			}
		}
		return returnTrueType;
	}

	@Override
	public String codeGeneration() {
		return "";
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
