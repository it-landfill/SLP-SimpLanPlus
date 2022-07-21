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
	private final CallNode callFun;

	public CallExpNode(Node call) {
		this.callFun = (CallNode) call;
		callFun.setExpNode(true);
	}

	@Override
	public String toPrint(String indent) {
		return indent + "callExp: " + callFun.toPrint(indent);
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		return callFun.typeCheck(symbolTable);
	}

	@Override
	public String codeGeneration(String options) {
		return callFun.codeGeneration(options);
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		return callFun.checkSemantics(env, symbolTable);
	}
}
