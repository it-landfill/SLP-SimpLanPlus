package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ArgNode implements Node {
	private final Node type;
	private final String argName;
	private final boolean byReference;

	public ArgNode(Node type, String argName, boolean byReference) {
		this.type = type;
		this.argName = argName;
		this.byReference = byReference;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "arg: " + type.toPrint(indent) + argName + " by reference: " + byReference;
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
		return null;
	}
}
