package SLPAst.expNode;

import SLPAst.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class NegExpNode implements Node {

	private final Node exp;

	public NegExpNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent) {
		return indent + " negative: " + exp.toString();
	}

	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		return exp.codeGeneration() +
				"push -1\n" +
				"mul\n";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return exp.checkSemantics(env);
	}
}
