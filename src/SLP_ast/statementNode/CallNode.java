package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.STentry;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class CallNode implements Node {
	private final String funcName;
	private final ArrayList<Node> params;
	private STentry entry;
	private int nestingLevel;

	public CallNode(String funcName, ArrayList<Node> params) {
		this.funcName = funcName;
		this.params = params;
	}

	public CallNode(String funcName) {
		this.funcName = funcName;
		params = null;
	}

	@Override
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();

		out.append(indent).append("call").append(funcName);

		if (params != null && !params.isEmpty()) {
			out.append(" params ");
			for (Node n : params) {
				out.append(n.toPrint(indent));
			}
		}

		return out.toString();
	}

	@Override
	public TypeNode typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		entry = env.symbolTable.findFirstInSymbolTable(funcName);
		nestingLevel = env.nestingLevel;

		if (entry == null) {
			errors.add(new SemanticError("Fun " + funcName + " does not exist in scope"));
		} else {
			// Se il numero di args è -1, la entry è una variabile, non una funzione
			if (entry.getnArgs() == -1) {
				errors.add(new SemanticError("Fun " + funcName + " is not a function"));
				return errors;
			}

			// Controllo il numero di parametri attuali rispetto a quelli formali
			if (params != null) {
				if (entry.getnArgs() != params.size()) {
					errors.add(new SemanticError("Parameter number for " + funcName + " does not match. Expected " + entry.getnArgs() + ". Have " + params.size()));
				}
			} else {
				if (entry.getnArgs() != 0) {
					errors.add(new SemanticError("Parameter number for " + funcName + " does not match. Expected " + entry.getnArgs() + ". Have 0"));
				}
			}
		}

		// Se ci sono parametri controllo gli errori su questi
		if (params != null) {
			for (Node n : params) {
				errors.addAll(n.checkSemantics(env));
			}
		}

		return errors;
	}
}
