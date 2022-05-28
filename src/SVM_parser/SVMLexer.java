// Generated from /Users/alessandrobenetton/Library/CloudStorage/OneDrive-AlmaMaterStudiorumUniversitàdiBologna/University/I_Anno/II_[81941]-Compilatori_e_Interpreti/Progetto_CEI/src/SVM_parser/SVM.g4 by ANTLR 4.10.1
package SVM_parser;

import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUSH=1, POP=2, TOP=3, ADD=4, SUB=5, MULT=6, DIV=7, PRINT=8, HALT=9, LT=10, 
		LTE=11, GT=12, GTE=13, EQ=14, NEQ=15, AND=16, OR=17, NOT=18, LW=19, SW=20, 
		REG=21, MEM=22, COL=23, NUMBER=24, WHITESP=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PUSH", "POP", "TOP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", "LT", 
			"LTE", "GT", "GTE", "EQ", "NEQ", "AND", "OR", "NOT", "LW", "SW", "REG", 
			"MEM", "COL", "NUMBER", "WHITESP"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'push'", "'pop'", "'top'", "'add'", "'sub'", "'mult'", "'div'", 
			"'print'", "'halt'", "'lt'", "'lte'", "'gt'", "'gte'", "'eq'", "'neq'", 
			"'and'", "'or'", "'not'", "'lw'", "'sw'", null, null, "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUSH", "POP", "TOP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", 
			"LT", "LTE", "GT", "GTE", "EQ", "NEQ", "AND", "OR", "NOT", "LW", "SW", 
			"REG", "MEM", "COL", "NUMBER", "WHITESP"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public int lexicalErrors=0;


	public SVMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0019\u00aa\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u008e\b\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u0099\b\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u009d"+
		"\b\u0017\n\u0017\f\u0017\u00a0\t\u0017\u0003\u0017\u00a2\b\u0017\u0001"+
		"\u0018\u0004\u0018\u00a5\b\u0018\u000b\u0018\f\u0018\u00a6\u0001\u0018"+
		"\u0001\u0018\u0000\u0000\u0019\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014)\u0015+\u0016-\u0017/\u00181\u0019\u0001\u0000\u0001\u0003\u0000"+
		"\t\n\r\r  \u00b1\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000"+
		"%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0001"+
		"3\u0001\u0000\u0000\u0000\u00038\u0001\u0000\u0000\u0000\u0005<\u0001"+
		"\u0000\u0000\u0000\u0007@\u0001\u0000\u0000\u0000\tD\u0001\u0000\u0000"+
		"\u0000\u000bH\u0001\u0000\u0000\u0000\rM\u0001\u0000\u0000\u0000\u000f"+
		"Q\u0001\u0000\u0000\u0000\u0011W\u0001\u0000\u0000\u0000\u0013\\\u0001"+
		"\u0000\u0000\u0000\u0015_\u0001\u0000\u0000\u0000\u0017c\u0001\u0000\u0000"+
		"\u0000\u0019f\u0001\u0000\u0000\u0000\u001bj\u0001\u0000\u0000\u0000\u001d"+
		"m\u0001\u0000\u0000\u0000\u001fq\u0001\u0000\u0000\u0000!u\u0001\u0000"+
		"\u0000\u0000#x\u0001\u0000\u0000\u0000%|\u0001\u0000\u0000\u0000\'\u007f"+
		"\u0001\u0000\u0000\u0000)\u0082\u0001\u0000\u0000\u0000+\u008f\u0001\u0000"+
		"\u0000\u0000-\u0094\u0001\u0000\u0000\u0000/\u00a1\u0001\u0000\u0000\u0000"+
		"1\u00a4\u0001\u0000\u0000\u000034\u0005p\u0000\u000045\u0005u\u0000\u0000"+
		"56\u0005s\u0000\u000067\u0005h\u0000\u00007\u0002\u0001\u0000\u0000\u0000"+
		"89\u0005p\u0000\u00009:\u0005o\u0000\u0000:;\u0005p\u0000\u0000;\u0004"+
		"\u0001\u0000\u0000\u0000<=\u0005t\u0000\u0000=>\u0005o\u0000\u0000>?\u0005"+
		"p\u0000\u0000?\u0006\u0001\u0000\u0000\u0000@A\u0005a\u0000\u0000AB\u0005"+
		"d\u0000\u0000BC\u0005d\u0000\u0000C\b\u0001\u0000\u0000\u0000DE\u0005"+
		"s\u0000\u0000EF\u0005u\u0000\u0000FG\u0005b\u0000\u0000G\n\u0001\u0000"+
		"\u0000\u0000HI\u0005m\u0000\u0000IJ\u0005u\u0000\u0000JK\u0005l\u0000"+
		"\u0000KL\u0005t\u0000\u0000L\f\u0001\u0000\u0000\u0000MN\u0005d\u0000"+
		"\u0000NO\u0005i\u0000\u0000OP\u0005v\u0000\u0000P\u000e\u0001\u0000\u0000"+
		"\u0000QR\u0005p\u0000\u0000RS\u0005r\u0000\u0000ST\u0005i\u0000\u0000"+
		"TU\u0005n\u0000\u0000UV\u0005t\u0000\u0000V\u0010\u0001\u0000\u0000\u0000"+
		"WX\u0005h\u0000\u0000XY\u0005a\u0000\u0000YZ\u0005l\u0000\u0000Z[\u0005"+
		"t\u0000\u0000[\u0012\u0001\u0000\u0000\u0000\\]\u0005l\u0000\u0000]^\u0005"+
		"t\u0000\u0000^\u0014\u0001\u0000\u0000\u0000_`\u0005l\u0000\u0000`a\u0005"+
		"t\u0000\u0000ab\u0005e\u0000\u0000b\u0016\u0001\u0000\u0000\u0000cd\u0005"+
		"g\u0000\u0000de\u0005t\u0000\u0000e\u0018\u0001\u0000\u0000\u0000fg\u0005"+
		"g\u0000\u0000gh\u0005t\u0000\u0000hi\u0005e\u0000\u0000i\u001a\u0001\u0000"+
		"\u0000\u0000jk\u0005e\u0000\u0000kl\u0005q\u0000\u0000l\u001c\u0001\u0000"+
		"\u0000\u0000mn\u0005n\u0000\u0000no\u0005e\u0000\u0000op\u0005q\u0000"+
		"\u0000p\u001e\u0001\u0000\u0000\u0000qr\u0005a\u0000\u0000rs\u0005n\u0000"+
		"\u0000st\u0005d\u0000\u0000t \u0001\u0000\u0000\u0000uv\u0005o\u0000\u0000"+
		"vw\u0005r\u0000\u0000w\"\u0001\u0000\u0000\u0000xy\u0005n\u0000\u0000"+
		"yz\u0005o\u0000\u0000z{\u0005t\u0000\u0000{$\u0001\u0000\u0000\u0000|"+
		"}\u0005l\u0000\u0000}~\u0005w\u0000\u0000~&\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0005s\u0000\u0000\u0080\u0081\u0005w\u0000\u0000\u0081(\u0001"+
		"\u0000\u0000\u0000\u0082\u008d\u0005$\u0000\u0000\u0083\u0084\u0005a\u0000"+
		"\u0000\u0084\u008e\u00050\u0000\u0000\u0085\u0086\u0005t\u0000\u0000\u0086"+
		"\u008e\u000209\u0000\u0087\u0088\u0005r\u0000\u0000\u0088\u008e\u0005"+
		"a\u0000\u0000\u0089\u008a\u0005s\u0000\u0000\u008a\u008e\u0005p\u0000"+
		"\u0000\u008b\u008c\u0005f\u0000\u0000\u008c\u008e\u0005p\u0000\u0000\u008d"+
		"\u0083\u0001\u0000\u0000\u0000\u008d\u0085\u0001\u0000\u0000\u0000\u008d"+
		"\u0087\u0001\u0000\u0000\u0000\u008d\u0089\u0001\u0000\u0000\u0000\u008d"+
		"\u008b\u0001\u0000\u0000\u0000\u008e*\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0003/\u0017\u0000\u0090\u0091\u0005(\u0000\u0000\u0091\u0092\u0003)"+
		"\u0014\u0000\u0092\u0093\u0005)\u0000\u0000\u0093,\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0005:\u0000\u0000\u0095.\u0001\u0000\u0000\u0000\u0096\u00a2"+
		"\u00050\u0000\u0000\u0097\u0099\u0005-\u0000\u0000\u0098\u0097\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000"+
		"\u0000\u0000\u009a\u009e\u000219\u0000\u009b\u009d\u000209\u0000\u009c"+
		"\u009b\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e"+
		"\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1"+
		"\u0096\u0001\u0000\u0000\u0000\u00a1\u0098\u0001\u0000\u0000\u0000\u00a2"+
		"0\u0001\u0000\u0000\u0000\u00a3\u00a5\u0007\u0000\u0000\u0000\u00a4\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0006\u0018\u0000\u0000\u00a92\u0001"+
		"\u0000\u0000\u0000\u0006\u0000\u008d\u0098\u009e\u00a1\u00a6\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}