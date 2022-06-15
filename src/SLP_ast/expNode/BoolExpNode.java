package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class BoolExpNode implements Node {
	private final boolean val;

	public BoolExpNode(boolean val) {
		this.val = val;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "val: " + val;
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) {
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration() {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		// Essendo un exp base, non ho errori semantici
		return new ArrayList<>();
	}
}
