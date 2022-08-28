package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

/**
 * BoolExpNode represents a boolean constant.
 */
public class BoolExpNode implements Node {
	private final boolean val;

	public BoolExpNode(boolean val) {
		this.val = val;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		return new ArrayList<>();
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) {
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration(String options) {
		return "li $t0 " + (val ? "1" : "0") + "\n";
	}

}
