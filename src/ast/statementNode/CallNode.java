package ast.statementNode;

import ast.Node;
import ast.STentry;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class CallNode implements Node {
	private final String funcName;
	private final ArrayList<Node> params;

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
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		StringBuilder out = new StringBuilder();
		if(params != null) {
			for (Node n : params) {
				out.append(n.codeGeneration());
			}
		}
		return out.toString() + "TODO: Call";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		STentry fun = env.symbolTable.findFirstInSymbolTable(funcName);

		if (fun == null) {
			errors.add(new SemanticError("Fun " + funcName + " does not exist in scope"));
		} else {
			// Se il numero di args è -1, la entry è una variabile, non una funzione
			if (fun.getnArgs() == -1) {
				errors.add(new SemanticError("Fun " + funcName + " is not a function"));
				return errors;
			}

			// Controllo il numero di parametri attuali rispetto a quelli formali
			if (params != null) {
				if (fun.getnArgs() != params.size()) {
					errors.add(new SemanticError("Parameter number for " + funcName + " does not match. Expected " + fun.getnArgs() + ". Have " + params.size()));
				}
			} else {
				if (fun.getnArgs() != 0) {
					errors.add(new SemanticError("Parameter number for " + funcName + " does not match. Expected " + fun.getnArgs() + ". Have 0"));
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
