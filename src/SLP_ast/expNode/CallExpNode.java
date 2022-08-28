package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.statementNode.CallNode;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class CallExpNode implements Node {

	// Represent a CallExpNode as a CallNode with expNode set to true.
	private final CallNode callFun;

	public CallExpNode(Node call) {
		this.callFun = (CallNode) call;
		// Set expNode to true.
		callFun.setExpNode(true);
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		return callFun.checkSemantics(env, symbolTable);
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		return callFun.typeCheck(symbolTable);
	}

	@Override
	public String codeGeneration(String options) {
		return callFun.codeGeneration(options);
	}


}
