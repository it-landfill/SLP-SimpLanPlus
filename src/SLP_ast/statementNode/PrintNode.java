package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.typeNode.VoidTypeNode;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class PrintNode implements Node {
	private final Node exp;

	public PrintNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "print: " + exp.toPrint(indent);
	}

	@Override
	public Node typeCheck() {
		exp.typeCheck();
		return new VoidTypeNode();
	}

	@Override
	public String codeGeneration() {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return exp.checkSemantics(env);
	}
}
