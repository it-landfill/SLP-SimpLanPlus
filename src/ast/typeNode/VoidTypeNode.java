package ast.typeNode;

import ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class VoidTypeNode implements Node {

	public VoidTypeNode() {
	}

	@Override
	public String toPrint(String indent) {
		return indent + "type: void";
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
