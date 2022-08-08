package util;

import SLP_ast.typeNode.*;

import java.util.HashMap;

public class SLPUtils {


	private static final HashMap<String, Integer> labelCount = new HashMap<>();

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

	public static String newLabel(String baseLabel) {

		//TODO: Va testato, è possibile he vengano generate più label con lo stesso nome?
		//TODO: Cosa succede se esistono già delle label? funziona l'incremento?
		String label = (baseLabel.equals("")?"label":baseLabel);

		int counter = labelCount.getOrDefault(label, 0);
		counter++;
		labelCount.put(label, counter);

		return label+"_"+counter;
	}

	public static String newLabel() {return newLabel("");}

	public static class TypeCheckError extends Exception {
		public TypeCheckError(String errorMessage) {
			super(errorMessage);
		}
	}
}
