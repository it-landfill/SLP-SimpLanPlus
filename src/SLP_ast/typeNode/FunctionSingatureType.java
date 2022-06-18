package SLP_ast.typeNode;

import SLP_ast.ArgNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class FunctionSingatureType extends TypeNode {

	ArrayList<ArgNode> arguments;
	TypeNode returnType;

	public FunctionSingatureType(ArrayList<ArgNode> arguments, TypeNode returnType) {
		this.arguments = arguments;
		this.returnType = returnType;
	}

	public ArrayList<ArgNode> getArguments() {
		return arguments;
	}

	public TypeNode getReturnType() {
		return returnType;
	}
}
