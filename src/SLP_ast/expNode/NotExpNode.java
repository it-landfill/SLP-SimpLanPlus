package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class NotExpNode implements Node {

	private final Node exp;

	public NotExpNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		return exp.checkSemantics(env, symbolTable);
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		TypeNode type = exp.typeCheck(symbolTable);
		if (!SLPUtils.checkBoolType(type)) {
			throw new SLPUtils.TypeCheckError("Bool expression expected, got" + type);
		}
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration(String options) {
		return exp.codeGeneration(options) + "not $t0 $t0\n";
	}
}