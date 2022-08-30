package SLP_ast.typeNode;

import SLP_ast.Node;
import util.Environment;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class BoolTypeNode extends TypeNode {

	@Override
	public String toString() {
		return "bool";
	}
}
