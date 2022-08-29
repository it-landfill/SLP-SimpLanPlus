package SLP_ast;

import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class ArgNode implements Node {
	private final TypeNode type;
	private final String argName;
	private final boolean byReference;

	public ArgNode(TypeNode type, String argName, boolean byReference) {
		this.type = type;
		this.argName = argName;
		this.byReference = byReference;
	}

	public TypeNode getType() {
		return type;
	}

	public String getArgName() {
		return argName;
	}

	public boolean isByReference() {
		return byReference;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		return type.checkSemantics(env, symbolTable);
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) {
		return type;
	}

	@Override
	public String codeGeneration(String options) {
		return "";
	}

}
