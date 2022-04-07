package compiler;

import org.antlr.v4.runtime.*;
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
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");

	private final ArrayList<String> syntaxErrors;
	private final ArrayList<String> ambiguityWarnings;
	private final ArrayList<String> attemptingFullContextWarnings;
	private final ArrayList<String> contextSensitivityWarnings;



	public SimpLanPlusErrorParser() {
		syntaxErrors = new ArrayList<>();
		ambiguityWarnings = new ArrayList<>();
		attemptingFullContextWarnings = new ArrayList<>();
		contextSensitivityWarnings = new ArrayList<>();
	}

	/**
	 * Returns true if there is at least an alament in the arraylists
	 * @return boolean
	 */
	public boolean hasMessages() {
		return !syntaxErrors.isEmpty() || !ambiguityWarnings.isEmpty() || !attemptingFullContextWarnings.isEmpty() || !contextSensitivityWarnings.isEmpty();
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
		syntaxErrors.add("[ERROR] Error at pos " + line + ":" + charPositionInLine + ". " + msg);
	}

	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
		ambiguityWarnings.add("[WARNING] Ambiguity detected between  index " + startIndex + " and index " + stopIndex + " dfa:" + dfa.toString());
	}

	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
		attemptingFullContextWarnings.add("[WARNING] Full context warning between  index " + startIndex + " and index " + stopIndex + " dfa:" + dfa.toString());
	}

	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
		contextSensitivityWarnings.add("[WARNING] Sensitivity warning between  index " + startIndex + " and index " + stopIndex + " dfa:" + dfa.toString());
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();

		if (!syntaxErrors.isEmpty()) {
			out.append("Errors:\n");
			for (String err : syntaxErrors) out.append("\t").append(err).append("\n");
		}

		if (!ambiguityWarnings.isEmpty()) {
			out.append("Ambiguity:\n");
			for (String err : ambiguityWarnings) out.append("\t").append(err).append("\n");
		}

		if (!attemptingFullContextWarnings.isEmpty()) {
			out.append("Attempting Full Context:\n");
			for (String err : attemptingFullContextWarnings) out.append("\t").append(err).append("\n");
		}

		if (!contextSensitivityWarnings.isEmpty()) {
			out.append("Context Sensitivity:\n");
			for (String err : contextSensitivityWarnings) out.append("\t").append(err).append("\n");
		}

		return out.toString();
	}

	public void dumpToFile(String filename) throws IOException {
		String dtString = dtf.format(LocalDateTime.now());
		String fName = filename + "_" + dtString + ".log";
		BufferedWriter wr = new BufferedWriter(new FileWriter(fName));
		wr.append(this.toString());
		wr.close();
	}
}
