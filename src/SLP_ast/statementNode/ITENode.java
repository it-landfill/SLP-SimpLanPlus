package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
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
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();
		out.append(indent).append("IF ").append(condition.toPrint(indent)).append(" THEN ").append(ifTrue.toPrint(indent));
		if (ifFalse != null) out.append(" ELSE ").append(ifFalse.toPrint(indent));
		return out.toString();
	}


	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		TypeNode returnTrueType;

		// Controllo che la condizione dell'if sia bool
		if(!SLPUtils.checkBoolType(condition.typeCheck(symbolTable))) {
			throw new SLPUtils.TypeCheckError("Alla condizione dell'If non è associato un tipo boolean.");
		}
		SymbolTableWrapper symbolTableElse = symbolTable.clone();

		// Calcolo il tipo del branch then
		returnTrueType = ifTrue.typeCheck(symbolTable);


		// Se esiste else, calcolo tipo dell'else
		if (ifFalse != null){
			TypeNode elseType = ifFalse.typeCheck(symbolTableElse);
			// Se il tipo dell'else è diverso dal tipo del then, controllo se è void.
			// Se lo è, il type check ritornerà void, altrimenti errore.
			if(!SLPUtils.checkTypes(returnTrueType, elseType)){
				if(SLPUtils.checkVoidType(elseType)) returnTrueType = elseType;
				else throw new SLPUtils.TypeCheckError("Nella condizione dell'If, il ramo else ha tipo diverso rispetto al ramo then.");
			}

			symbolTable.update(symbolTableElse);
		}

		return returnTrueType;
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
