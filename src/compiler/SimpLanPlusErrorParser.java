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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.BitSet;

public class SimpLanPlusErrorParser extends BaseErrorListener {
	public static SimpLanPlusErrorParser inst = new SimpLanPlusErrorParser();
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");

	ArrayList<String> errorList;

	public SimpLanPlusErrorParser() {
		errorList = new ArrayList<>();
	}

	/**
	 *
	 * @param recognizer
	 * @param offendingSymbol Symbol that generated the error
	 * @param line Error line
	 * @param charPositionInLine Error position in the line
	 * @param msg Error message
	 * @param e Exception thrown
	 */
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
		errorList.add("Errore alla linea " + line + ":" + charPositionInLine + ". " + msg);
	}

	/**
	 * Returns the length of the error list
	 * @return int
	 */
	public int getErrorListLength() {
		return errorList.size();
	}

	/**
	 * Returns the length of the error list
	 * @return boolean
	 */
	public boolean isEmpty() {
		return errorList.isEmpty();
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
		out.append(dtf.format(LocalDateTime.now()));
		out.append("\tErrori:\n");
		for (String err: errorList) out.append("\t").append(err).append("\n");
		return out.toString();
	}

	public void dumpToFile(String filename) throws IOException {
		BufferedWriter wr = new BufferedWriter(new FileWriter(filename, true));
		wr.append(this.toString());
		wr.close();
	}
}
