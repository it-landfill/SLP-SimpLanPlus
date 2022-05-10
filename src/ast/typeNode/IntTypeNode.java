package ast.typeNode;

import ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IntTypeNode implements Node {

	public IntTypeNode() {
	}

	@Override
	public String toPrint(String indent) {
		return indent + "type: integer";
	}

	@Override
	public Node typeCheck() {
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
