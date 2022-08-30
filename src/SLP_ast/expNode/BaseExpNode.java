package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

/**
 * BaseExpNode represents a set of parenthesis
 */
public class BaseExpNode implements Node {
	private final Node exp;

	public BaseExpNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		return exp.checkSemantics(env, symbolTable);
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		return exp.typeCheck(symbolTable);
	}

	@Override
	public String codeGeneration(String options) {
		return exp.codeGeneration(options);
	}
}
