package SLP_ast.typeNode;

import SLP_ast.Node;
import util.Environment;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class IntTypeNode implements TypeNode {

	public IntTypeNode() {
	}

	@Override
	public String toPrint(String indent) {
		return indent + "type: integer";
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) {
		return null;
	}

	@Override
	public String codeGeneration() {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return new ArrayList<>();
	}
}
