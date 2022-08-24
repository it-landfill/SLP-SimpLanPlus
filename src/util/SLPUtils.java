package util;

import SLP_ast.typeNode.*;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String label = (baseLabel.equals("")?"label":baseLabel);

		int counter = labelCount.getOrDefault(label, -1);
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

	public static void SBReplaceAll(StringBuilder sb, String find, String replace){

		//compile pattern from find string
		Pattern p = Pattern.compile(find);

		//create new Matcher from StringBuilder object
		Matcher matcher = p.matcher(sb);

		//index of StringBuilder from where search should begin
		int startIndex = 0;

		while( matcher.find(startIndex) ){

			sb.replace(matcher.start(), matcher.end(), replace);

			//set next start index as start of the last match + length of replacement
			startIndex = matcher.start() + replace.length();
		}
	}
}
