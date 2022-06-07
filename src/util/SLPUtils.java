package util;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.IntTypeNode;
import SLP_ast.typeNode.VoidTypeNode;

public class SLPUtils {
	private static int labCount;

	public static boolean checkTypes(Node a, Node b) {
		return a.getClass().equals(b.getClass());
	}

	public static boolean checkIntType(Node a) {
		return a instanceof IntTypeNode;
	}

	public static boolean checkBoolType(Node a) {
		return a instanceof BoolTypeNode;
	}

	public static boolean checkVoidType(Node a) {
		return a instanceof VoidTypeNode;
	}

	public static String newLabel(String baseLabel) {return (baseLabel.equals("")?"label":baseLabel)+"_"+(labCount++);}

	public static String newLabel() {return newLabel("");}
}
