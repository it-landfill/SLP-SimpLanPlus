package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidableTypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

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
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		errors.addAll(condition.checkSemantics(env, symbolTable));
		errors.addAll(ifTrue.checkSemantics(env, symbolTable));
		if (ifFalse != null) errors.addAll(ifFalse.checkSemantics(env, symbolTable));

		return errors;
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		// Evaluate ITE condition
		TypeNode conditionType = condition.typeCheck(symbolTable);
		if (!SLPUtils.checkBoolType(conditionType)) {
			throw new SLPUtils.TypeCheckError("Bool expression expected in if-condition. Got " + conditionType + ".");
		}
		SymbolTableWrapper symbolTableElse = symbolTable.clone();

		// Evaluate then branch type
		TypeNode thenType = ifTrue.typeCheck(symbolTable);


		// if there is an else block, evaluate it
		if (ifFalse != null) {
			TypeNode elseType = ifFalse.typeCheck(symbolTableElse);

			// Explained in documentation.
			if (!SLPUtils.checkTypes(thenType, elseType)) {
				if (SLPUtils.checkVoidType(thenType)) thenType = new VoidableTypeNode(elseType);
				else if (SLPUtils.checkVoidType(elseType)) thenType = new VoidableTypeNode(thenType);
				else
					throw new SLPUtils.TypeCheckError("Type mismatch between \"branchThen\" and \"branchElse\". Got \" if(bool) { " + thenType + " } else { " + elseType + " }.");
			}

			symbolTable.merge(symbolTableElse);
		}

		return thenType;
	}


	@Override
	public String codeGeneration(String options) {
		StringBuilder sb = new StringBuilder();
		String elseLabel = SLPUtils.newLabel("ifElse");
		String endLabel = SLPUtils.newLabel("ifEnd");

		sb.append("; Begin ITE\n");
		// Evaluate the condition.
		sb.append(condition.codeGeneration(options));  // $t0 = condition value
		sb.append("li $t1 0\n");
		sb.append("beq $t0 $t1 ").append(ifFalse != null ? elseLabel : endLabel).append("\n");

		// True branch
		sb.append(ifTrue.codeGeneration(options));

		// False branch
		if (ifFalse != null) {
			sb.append("jal ").append(endLabel).append("\n");
			sb.append(elseLabel).append(":\n");
			sb.append(ifFalse.codeGeneration(options));
		}

		sb.append(endLabel).append(":\n");
		sb.append("; End ITE\n");

		return sb.toString();
	}
}
