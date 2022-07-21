package SLP_ast.typeNode;

import SLP_ast.Node;
import util.Environment;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public abstract class TypeNode implements Node {

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) {
		return null;
	}

	@Override
	public String codeGeneration(String options) {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		return new ArrayList<>();
	}

	@Override
	public String toPrint(String indent) {
		return indent + "type: void";
	}

}
