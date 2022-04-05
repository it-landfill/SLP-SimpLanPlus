package compiler;

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
		// Error Handler
		SimpLanPlusErrorParser errHandler = new SimpLanPlusErrorParser();

		// Lexer
		SimpLanPlusLexer lexer = new SimpLanPlusLexer(input);
		lexer.addErrorListener(errHandler);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Parser
		SimpLanPlusParser parser = new SimpLanPlusParser(tokens);
		parser.addErrorListener(errHandler);


	}
}
