package ast.typeNode;

import ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class BoolTypeNode implements Node {

	public BoolTypeNode() {
	}

	@Override
	public String toPrint(String indent) {
		return indent + "type: boolean";
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
		return new ArrayList<>();
	}
}
