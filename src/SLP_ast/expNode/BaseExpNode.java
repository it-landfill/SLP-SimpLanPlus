package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;

import java.util.ArrayList;

// Potrebbe essere eliminato come nodo. (secondo Ale)

public class BaseExpNode implements Node {
	private final Node exp;

	public BaseExpNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent) {
		return indent + " exp: " + exp.toString();
	}

	@Override
	public TypeNode typeCheck() throws SLPUtils.TypeCheckError {
		return exp.typeCheck();
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
