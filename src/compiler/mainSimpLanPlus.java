package compiler;

import java.io.FileInputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.SimpLanPlusLexer;
import parser.SimpLanPlusParser;

public class mainSimpLanPlus {
	public static void main(String[] args) throws Exception {

		String fileName = "src/TestSimpLanPlus/prova.simplan";

		/*
		// Deprecated version of file loading
		FileInputStream is = new FileInputStream(fileName);
		ANTLRInputStream input = new ANTLRInputStream(is);
		*/

		// New file loading mode
		CharStream input = CharStreams.fromFileName(fileName);

		SimpLanPlusLexer lexer = new SimpLanPlusLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		SimpLanPlusParser parser = new SimpLanPlusParser(tokens);
		//SimpLanPlusVisitorImpl visitor = new SimpLanPlusVisitorImpl();
	}
}
