package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
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
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();
		out.append(indent).append("IF ").append(condition.toPrint(indent)).append(" THEN ").append(ifTrue.toPrint(indent));
		if (ifFalse != null) out.append(" ELSE ").append(ifFalse.toPrint(indent));
		return out.toString();
	}


	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		TypeNode thenType;

		// Controllo che la condizione dell'if sia bool
		if(!SLPUtils.checkBoolType(condition.typeCheck(symbolTable))) {
			throw new SLPUtils.TypeCheckError("Alla condizione dell'If non è associato un tipo boolean.");
		}
		SymbolTableWrapper symbolTableElse = symbolTable.clone();

		// Calcolo il tipo del branch then
		thenType = ifTrue.typeCheck(symbolTable);


		// Se esiste else, calcolo tipo dell'else
		if (ifFalse != null){
			TypeNode elseType = ifFalse.typeCheck(symbolTableElse);
			// Se il tipo dell'else è diverso dal tipo del then, controllo se è void.
			// Se lo è, il type check ritornerà void, altrimenti errore.
			if(!SLPUtils.checkTypes(thenType, elseType)){
				if(SLPUtils.checkVoidType(thenType)) thenType = new VoidableTypeNode(elseType);
				else if(SLPUtils.checkVoidType(elseType)) thenType = new VoidableTypeNode(thenType);
				else throw new SLPUtils.TypeCheckError("Nella condizione dell'If, il ramo else ha tipo diverso rispetto al ramo then.");
			}

			symbolTable.update(symbolTableElse);
		}

		return thenType;
	}

	@Override
	public String codeGeneration() {
		StringBuilder sb = new StringBuilder();
		String elseLabel = SLPUtils.newLabel("ifElse");
		String endLabel = SLPUtils.newLabel("ifEnd");

		// Controllo condizione
		sb.append(condition.codeGeneration()); // La codegen di una exp booleana salva in $t0 il risultato
		sb.append("li $t1 0\n");
		sb.append("beq $t0 $t1 ").append(ifFalse != null ? elseLabel : endLabel).append("\n");

		// True branch
		sb.append(ifTrue.codeGeneration());

		// False branch
		if (ifFalse != null) {
			sb.append("jal ").append(endLabel).append("\n");
			sb.append(elseLabel).append(":\n");
			sb.append(ifFalse.codeGeneration());
		}

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
