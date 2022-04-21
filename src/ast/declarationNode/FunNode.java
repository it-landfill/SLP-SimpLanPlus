package ast.declarationNode;

import ast.ArgNode;
import ast.Node;
import ast.STentry;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FunNode implements Node {
	private final Node returnType;
	private final String funcName;
	private final ArrayList<ArgNode> params;
	private final Node block;

	public FunNode(Node returnType, String funName, ArrayList<ArgNode> params, Node block) {
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

		//Gestisco il caso delle funzioni nested
		if (env.baseFun != null) { //TODO: Con la nuova symboltable si può fare diversamente??
			errors.add(new SemanticError("Functions can not be nested.\tYou are declaring function " + funcName + " inside the body of function " + env.baseFun + ", this is not allowed."));
		}

		STentry entry;

		// Genero la entry per la symbol table
		if (returnType != null) entry = new STentry(env.nestingLevel, returnType, env.offset, funcName);
		else entry = new STentry(env.nestingLevel, env.offset, funcName);

		// Se la funzione ha parametri formali, salvo il numero di questi
		if (params != null) entry.setnArgs(params.size());
		else entry.setnArgs(0);

		// Se da errore la funzione esiste già
		if (env.symbolTable.addToSymbolTable(entry)) {
			errors.add(new SemanticError("Fun " + funcName + " already declared"));
		}

		env.nestingLevel++;
		env.baseFun = funcName;

		// Controllo gli argomenti
		if (params != null) {
			for (ArgNode a : params) {
				errors.addAll(a.checkSemantics(env));
				STentry tmp = new STentry(env.nestingLevel,a.getType(),env.offset, a.getArgName());
				if (env.symbolTable.addToSymbolTable(tmp)) {
					errors.add(new SemanticError("arg " + a.getArgName() + " used multiple times"));
				}
			}
		}

		// Controllo il corpo
		if (block != null) {
			errors.addAll(block.checkSemantics(env));
		}

		env.symbolTable.removeLevelFromSymbolTable(env.nestingLevel);
		env.baseFun = null;
		env.nestingLevel--;

		return errors;
	}
}
