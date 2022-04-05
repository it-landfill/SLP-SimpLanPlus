package compiler;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.SimpLanPlusLexer;
import parser.SimpLanPlusParser;

public class mainSimpLanPlus {
	public static void main(String[] args) throws Exception {

		String fileName = "/Users/cresp/Documents/Workspace/Unibo_Compilatori_Interpreti/src/prova.simplan";

		FileInputStream is = new FileInputStream(fileName);
		ANTLRInputStream input = new ANTLRInputStream(is);
		SimpLanPlusLexer lexer = new SimpLanPlusLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		SimpLanPlusParser parser = new SimpLanPlusParser(tokens);
		//SimpLanPlusVisitorImpl visitor = new SimpLanPlusVisitorImpl();
	}
}
