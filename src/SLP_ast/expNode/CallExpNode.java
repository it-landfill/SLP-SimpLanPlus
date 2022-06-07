package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
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
	public TypeNode typeCheck() {
		// TODO: Controlli della call
		return new VoidTypeNode();
	}

	@Override
	public String codeGeneration() {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return callFun.checkSemantics(env);
	}
}
