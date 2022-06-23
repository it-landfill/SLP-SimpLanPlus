package util;

import SLP_ast.typeNode.*;

public class SLPUtils {
	private static int labCount;

	public static boolean checkTypes(TypeNode a, TypeNode b) {
		return a.getClass().equals(b.getClass());
	}

	public static boolean checkIntType(TypeNode a) {
		return a instanceof IntTypeNode;
	}

	public static boolean checkBoolType(TypeNode a) {
		return a instanceof BoolTypeNode;
	}

	public static boolean checkVoidType(TypeNode a) {
		return a instanceof VoidTypeNode;
	}

	public static boolean checkVoidableType(TypeNode a) {
		return a instanceof VoidableTypeNode;
	}

	public static String newLabel(String baseLabel) {return (baseLabel.equals("")?"label":baseLabel)+"_"+(labCount++);}

	public static String newLabel() {return newLabel("");}

	public static class TypeCheckError extends Exception {
		public TypeCheckError(String errorMessage) {
			super(errorMessage);
		}
	}
}
