package compiler;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;

public class SimpLanPlusErrorParser extends BaseErrorListener {
	public static SimpLanPlusErrorParser inst = new SimpLanPlusErrorParser();

	ArrayList<String> errorList;

	public SimpLanPlusErrorParser() {
		errorList = new ArrayList<>();
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
		errorList.add("Error at " + line);
	}

	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
		super.reportAmbiguity(recognizer, dfa, startIndex, stopIndex, exact, ambigAlts, configs);
	}

	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
		super.reportAttemptingFullContext(recognizer, dfa, startIndex, stopIndex, conflictingAlts, configs);
	}

	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
		super.reportContextSensitivity(recognizer, dfa, startIndex, stopIndex, prediction, configs);
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		for (String err: errorList) {
			out.append(err).append("\n");
		}
		return out.toString();
	}

	public void dumpToFile(String filename) throws IOException {
		BufferedWriter wr = new BufferedWriter(new FileWriter(filename));
		wr.write(this.toString());
		wr.close();
	}
}
