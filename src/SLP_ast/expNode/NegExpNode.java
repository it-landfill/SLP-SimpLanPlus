package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.IntTypeNode;
import util.Environment;
import util.SLPUtils;
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
		if (!SLPUtils.checkIntType(exp.typeCheck())) {
			System.out.println("Al neg (-) non è associato un tipo integer.");
			System.exit(0);
		}
		return new IntTypeNode();
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
