package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class ReturnNode implements Node {
	private final Node exp;

	public ReturnNode(Node exp) {
		this.exp = exp;
	}

	public ReturnNode() {
		this.exp = null;
	}

	@Override
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();
		out.append(indent).append("return");
		if (exp != null) out.append(" ").append(exp.toPrint(indent));
		return out.toString();
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		if (exp != null) return exp.typeCheck(symbolTable);
		return new VoidTypeNode();
	}

	@Override
	public String codeGeneration() {
		//TODO
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		if (exp != null) {
			return exp.checkSemantics(env);
		} else {
			return new ArrayList<>();
		}
	}
}
