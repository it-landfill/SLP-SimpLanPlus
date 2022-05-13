package SLPAst;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ArgNode implements Node {
	private final Node type;
	private final String argName;
	private final boolean byReference; //TODO: Gestire questo caso

	public ArgNode(Node type, String argName, boolean byReference) {
		this.type = type;
		this.argName = argName;
		this.byReference = byReference;
	}

	public Node getType() {
		return type;
	}

	public String getArgName() {
		return argName;
	}

	public boolean isByReference() {
		return byReference;
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
		return "TODO: Arg";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return type.checkSemantics(env); //TODO: Valutare se veramente necessario
	}
}
