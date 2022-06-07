package SLP_ast.typeNode;

import SLP_ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class BoolTypeNode implements TypeNode {

	public BoolTypeNode() {
	}

	@Override
	public String toPrint(String indent) {
		return indent + "type: boolean";
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
		return new ArrayList<>();
	}
}
