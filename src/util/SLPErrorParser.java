package util;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SLPErrorParser extends BaseErrorListener {
    // DateTime formatter used to generate output filename.
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");

    // String arraylist containing errors.
    private final ArrayList<String> syntaxErrors;

    public SLPErrorParser() {
        syntaxErrors = new ArrayList<>();
    }

    /**
     * Returns true if there is at least an element in the arraylists
     *
     * @return boolean
     */
    public boolean hasMessages() {
        return !syntaxErrors.isEmpty();
    }

    /**
     * Returns the number of errors in the arraylists.
     *
     * @return boolean
     */
    public int count() {return syntaxErrors.size();}

    /**
     * @param recognizer
     * @param offendingSymbol    Symbol that generated the error
     * @param line               Error line
     * @param charPositionInLine Error position in the line
     * @param msg                Error message
     * @param e                  Exception thrown
     */
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        syntaxErrors.add("[ERROR] Error at pos " + line + ":" + charPositionInLine + ". " + msg);
    }

    /**
     * Returns the error arraylist as a single string. Errors are \n separated.
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        if (!syntaxErrors.isEmpty()) {
            out.append("Errors:\n");
            for (String err : syntaxErrors) out.append("\t").append(err).append("\n");
        }

        return out.toString();
    }

    /**
     * Writes to file the error arraylist.
     *
     * @param filename Output file name
     * @throws IOException
     */
    public void dumpToFile(String filename) throws IOException {
        String dtString = dtf.format(LocalDateTime.now());
        String fName = filename + "_" + dtString + ".log";
        BufferedWriter wr = new BufferedWriter(new FileWriter(fName));
        wr.append(this.toString());
        wr.close();
    }
}
