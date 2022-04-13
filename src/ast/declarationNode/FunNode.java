package ast.declarationNode;

import ast.Node;
import ast.STentry;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class FunNode implements Node {
	private final Node returnType;
	private final String funcName;
	private final ArrayList<Node> params;
	private final Node block;

	public FunNode(Node returnType, String funName, ArrayList<Node> params, Node block) {
		this.returnType = returnType;
		this.funcName = funName;
		this.params = params;
		this.block = block;
	}

	@Override
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();

		out.append(indent).append("function");
		if (returnType != null) out.append(returnType.toPrint(indent));
		else out.append(" void ");

		out.append(funcName);

		if (params != null && !params.isEmpty()) {
			out.append(" params ");
			for (Node n : params) {
				out.append(n.toPrint(indent));
			}
		}

		out.append("block ").append(block.toPrint(indent));

		return out.toString();
	}

	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		return null;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		HashMap<String, STentry> hm = env.getCurrentLevelSymTable();
		STentry entry;

		if (returnType != null) entry = new STentry(env.nestingLevel, returnType, env.offset);
		else entry = new STentry(env.nestingLevel, env.offset);

		if (params != null) entry.setnArgs(params.size());
		else entry.setnArgs(0);

		//TODO: Check nested functions

		// Se da errore la funzione esiste già
		if (hm.put(funcName, entry) != null) errors.add(new SemanticError("Fun id " + funcName + " already declared"));

		env.nestingLevel++;
		hm = new HashMap<>();
		env.symTable.add(hm);

		// Controllo gli argomenti
		if (params != null) {
			for (Node a : params) {
				errors.addAll(a.checkSemantics(env));
			}
		}

		// Controllo il corpo
		if (block != null) {
			errors.addAll(block.checkSemantics(env));
		}

		env.symTable.remove(env.nestingLevel);
		env.nestingLevel--;

		return errors;
	}
}
