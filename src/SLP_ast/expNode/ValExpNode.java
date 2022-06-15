package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.IntTypeNode;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class ValExpNode implements Node {
	private final int val;

	public ValExpNode(int val) {
		this.val = val;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "val: " + val;
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) {
		return new IntTypeNode();
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