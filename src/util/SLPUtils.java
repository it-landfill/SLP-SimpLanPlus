package util;

import ast.Node;
import ast.typeNode.BoolTypeNode;
import ast.typeNode.IntTypeNode;
import ast.typeNode.VoidTypeNode;

public class SLPUtils {
	private static int labCount;

	public static boolean checkTypes(Node a, Node b) {
		return a.getClass().equals(b.getClass());
	}

	public static boolean checkIntType(Node a, Node b) {
		return a instanceof IntTypeNode && b instanceof IntTypeNode;
	}

	public static boolean checkBoolType(Node a, Node b) {
		return a instanceof BoolTypeNode && b instanceof BoolTypeNode;
	}

	public static boolean checkVoidType(Node a, Node b) {
		return a instanceof VoidTypeNode && b instanceof VoidTypeNode;
	}

	public static String newLabel() {return "label"+(labCount++);}
}