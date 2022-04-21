package compiler;

import ast.Node;
import ast.STentry;
import ast.SimpLanPlusVisitorImpl;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.SimpLanPlusLexer;
import parser.SimpLanPlusParser;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class mainSimpLanPlus {
	public static void main(String[] args) throws Exception {
		String fileName = "src/TestSimpLanPlus/prova.simplan";

		// File loading
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

		SimpLanPlusVisitorImpl visitor = new SimpLanPlusVisitorImpl();
		Node ast = visitor.visit(parser.block());

		if (errHandler.hasMessages()) {
			System.out.println(errHandler);
			errHandler.dumpToFile(fileName);
		}

		Environment env = new Environment();

		/*
		ArrayList<SemanticError> err = ast.checkSemantics(env);

		if(err != null && err.size()>0){
			System.out.println("You had " +err.size()+" semantic errors:");
			for(SemanticError e : err)
				System.out.println("\t" + e);
		}*/

	}
}
