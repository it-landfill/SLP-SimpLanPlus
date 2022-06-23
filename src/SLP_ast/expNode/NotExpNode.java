package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.IntTypeNode;
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
	public String toPrint(String indent) {
		return indent + " not: " + exp.toString();
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		if (!(SLPUtils.checkBoolType(exp.typeCheck(symbolTable)))) {
			throw new SLPUtils.TypeCheckError("Al not (!) non è associato un tipo boolean.");
		}
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration() {
		return exp.codeGeneration() + "not $t0 $t0";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		return exp.checkSemantics(env);
	}
}