package SLP_ast.expNode;

import SLP_ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class CallExpNode implements Node {
	private final Node callFun;

	public CallExpNode(Node call) {
		this.callFun = call;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "callExp: " + callFun.toPrint(indent);
	}

	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		return callFun.codeGeneration()+"TODO: CallExp\n";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return callFun.checkSemantics(env);
	}
}
