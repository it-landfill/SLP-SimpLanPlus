package compiler;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.SimpLanLexer;
import parser.SimpLanParser;

public class mainSimpLanPlus {
	public static void main(String[] args) throws Exception {

		String fileName = "prova.simplan";

		FileInputStream is = new FileInputStream(fileName);
		ANTLRInputStream input = new ANTLRInputStream(is);
		SimpLanLexer lexer = new SimpLanLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		SimpLanParser parser = new SimpLanParser(tokens);
		SimpLanVisitorImpl visitor = new SimpLanVisitorImpl();
	}
}
