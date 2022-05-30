package compiler;

import SVM_ast.SVMVisitorImpl;
import SVM_parser.SVMLexer;
import SVM_parser.SVMParser;
import interpreter.ExecuteVM;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class runVM {
	public static void main(String[] args) throws Exception {
		// Relative path to the file WITHOUT EXTENSION
		String fileName = "src/TestSimpLanPlus/testExp";

		// CODE PARSING
		// File loading.
		CharStream svmInputFile = CharStreams.fromFileName(fileName + ".asm");

		// Lexical verification.
		System.out.println("[INFO] Starting lexical verification.");
		SVMLexer svmLexer = new SVMLexer(svmInputFile);
		CommonTokenStream svmTokens = new CommonTokenStream(svmLexer);
		SVMParser svmParser = new SVMParser(svmTokens);

		SVMVisitorImpl svmVisitor = new SVMVisitorImpl();
		// The depth-first search for the abstract syntax tree starts from the root node, in the
		// case of the SVM grammar.
		svmVisitor.visit(svmParser.assembly());

		System.out.println("You had: " + svmLexer.lexicalErrors + " lexical errors and " + svmParser.getNumberOfSyntaxErrors() + " syntax errors.");
		if (svmLexer.lexicalErrors > 0 || svmParser.getNumberOfSyntaxErrors() > 0) System.exit(1);

		System.out.println("Starting Virtual Machine...");
		ExecuteVM vm = new ExecuteVM(svmVisitor.code);
		vm.evaluate();
	}
}
