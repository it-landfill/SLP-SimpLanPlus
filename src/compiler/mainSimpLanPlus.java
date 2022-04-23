package compiler;

import ast.Node;
import ast.SimpLanPlusVisitorImpl;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.SimpLanPlusLexer;
import parser.SimpLanPlusParser;
import util.Environment;
import util.SemanticError;
import util.SimpLanPlusErrorParser;

import java.util.ArrayList;

public class mainSimpLanPlus {
	public static void main(String[] args) throws Exception {
		String fileName = "src/TestSimpLanPlus/Esercizio2/Test_1.slp";

		// File loading.
		CharStream input = CharStreams.fromFileName(fileName);
		// Generazione dell'oggetto Error Handler utile alla gestione degli errori lessicali.
		SimpLanPlusErrorParser errHandler = new SimpLanPlusErrorParser();

		// Lexical verification.
		System.out.println("[INFO] Starting lexical verification.");
		SimpLanPlusLexer lexer = new SimpLanPlusLexer(input);
		lexer.addErrorListener(errHandler);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		SimpLanPlusParser parser = new SimpLanPlusParser(tokens);
		parser.addErrorListener(errHandler);

		// Implentazione del visitor utile al scorre AST in DFS.
		SimpLanPlusVisitorImpl visitor = new SimpLanPlusVisitorImpl();
		// Il DFS prende come radice il primo token della grammatica (block)
		// TODO: Controllare per la consegna finale che il nodo radice sia rimasto immutato.
		Node ast = visitor.visit(parser.block());

		// If errors have been identified in the lexical analysis phase, they are printed, a report file is
		// generated, and the program stops.
		if (errHandler.hasMessages()) {
			System.out.println("[ERROR] There were some errors while parsing the program.");
			System.out.println(errHandler);
			errHandler.dumpToFile(fileName);
			System.out.println("[ERROR] Program parsing failed");
			return;
		}

		System.out.println("[INFO] No lexical error found.\n[INFO] Starting semantic verification.");

		Environment env = new Environment();
		// Generazione di un array list che conterrà tutti gli errori semantici.
		ArrayList<SemanticError> err = ast.checkSemantics(env);

		// If errors have been identified in the semantic analysis phase, they are printed and the program stops.
		if(err != null && err.size()>0){
			System.out.println("You had " +err.size()+" semantic errors:");
			for(SemanticError e : err)
				System.out.println("\t" + e);
			System.out.println("[ERROR] Program parsing failed");
		} else {
			System.out.println("[INFO] No semantic error found.\n[SUCCESS] Program parsing completed");
		}

	}
}
