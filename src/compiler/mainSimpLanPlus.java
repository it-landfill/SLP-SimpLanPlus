package compiler;

import ast.Node;
import ast.SimpLanPlusVisitorImpl;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import SLPParser.SimpLanPlusLexer;
import SLPParser.SimpLanPlusParser;
import util.Environment;
import util.SemanticError;
import util.SLPErrorParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class mainSimpLanPlus {
    public static void main(String[] args) throws Exception {
        String fileName = "src/TestSimpLanPlus/prova.slp";
        // File loading.
        CharStream inputFile = CharStreams.fromFileName(fileName);
        // Generation of the error handler object useful for managing lexical errors.
        SLPErrorParser errHandler = new SLPErrorParser();
        // Lexical verification.
        System.out.println("[INFO] Starting lexical verification.");
        SimpLanPlusLexer lexer = new SimpLanPlusLexer(inputFile);
        lexer.addErrorListener(errHandler);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpLanPlusParser parser = new SimpLanPlusParser(tokens);
        parser.addErrorListener(errHandler);
        // Visitor implementation useful for visiting abstract syntax tree in depth-first search.
        SimpLanPlusVisitorImpl visitor = new SimpLanPlusVisitorImpl();
        // The depth-first search for the abstract syntax tree starts from the root node, in the
        // case of the SimpLanPlus grammar.
        // TODO: Check for final delivery that the root node has remained unchanged in the grammar.
        Node ast = visitor.visit(parser.block());
        // If errors have been identified in the lexical analysis phase, they are printed, a report
        // file is generated, and the program stops.
        if (errHandler.hasMessages()) {
            System.out.println("[ERROR] There were some errors while parsing the program.");
            System.out.println(errHandler);
            errHandler.dumpToFile(fileName);
            System.out.println("[ERROR] Program parsing failed");
            return;
        }
        System.out.println("[INFO] No lexical error found.");
        // Semantic verification.
        System.out.println("[INFO] Starting semantic verification.");
        Environment env = new Environment();
        // Generation of an ArrayList that will contain all semantic errors.
        ArrayList<SemanticError> err = ast.checkSemantics(env);
        // If errors have been identified in the semantic analysis phase, they are printed, a report
        // file is generated, and the program stops.
        if (err != null && err.size() > 0) {
            System.out.println("You had " + err.size() + " semantic errors:");
            for (SemanticError e : err)
                System.out.println("\t" + e);
            System.out.println("[ERROR] Program parsing failed");
            return;
        }
        System.out.println("[INFO] No semantic error found.");

        System.out.println("[SUCCESS] Program parsing completed");



        // CODE GENERATION  prova.SimpLan.asm
        String code=ast.codeGeneration();
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm"));
        out.write(code);
        out.close();
        System.out.println("[SUCCESS] Code generated! Assembling and running generated code.");
    }
}
