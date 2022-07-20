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
		T__0=1, T__1=2, PUSHINT=3, POPINT=4, TOPINT=5, PUSHBOOL=6, POPBOOL=7, 
		TOPBOOL=8, LI=9, MOV=10, LW=11, SW=12, LB=13, SB=14, ADD=15, ADDI=16, 
		SUB=17, SUBI=18, MULT=19, MULTI=20, DIV=21, DIVI=22, LT=23, LTE=24, GT=25, 
		GTE=26, EQ=27, NEQ=28, AND=29, OR=30, NOT=31, NEG=32, PRINTW=33, PRINTB=34, 
		BEQ=35, HALT=36, JAL=37, JR=38, SYMBOLS=39, LABEL=40, REG=41, STRING=42, 
		COL=43, NUMBER=44, WHITESP=45, LINECOMMENTS=46;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "PUSHINT", "POPINT", "TOPINT", "PUSHBOOL", "POPBOOL", 
			"TOPBOOL", "LI", "MOV", "LW", "SW", "LB", "SB", "ADD", "ADDI", "SUB", 
			"SUBI", "MULT", "MULTI", "DIV", "DIVI", "LT", "LTE", "GT", "GTE", "EQ", 
			"NEQ", "AND", "OR", "NOT", "NEG", "PRINTW", "PRINTB", "BEQ", "HALT", 
			"JAL", "JR", "SYMBOLS", "LABEL", "DIGIT", "REG", "CHAR", "STRING", "COL", 
			"NUMBER", "WHITESP", "LINECOMMENTS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'pushw'", "'popw'", "'topw'", "'pushb'", "'popb'", 
			"'topb'", "'li'", "'mov'", "'lw'", "'sw'", "'lb'", "'sb'", "'add'", "'addi'", 
			"'sub'", "'subi'", "'mult'", "'multi'", "'div'", "'divi'", "'lt'", "'lte'", 
			"'gt'", "'gte'", "'eq'", "'neq'", "'and'", "'or'", "'not'", "'neg'", 
			"'printw'", "'printb'", "'beq'", "'halt'", "'jal'", "'jr'", "'_'", null, 
			null, null, "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "PUSHINT", "POPINT", "TOPINT", "PUSHBOOL", "POPBOOL", 
			"TOPBOOL", "LI", "MOV", "LW", "SW", "LB", "SB", "ADD", "ADDI", "SUB", 
			"SUBI", "MULT", "MULTI", "DIV", "DIVI", "LT", "LTE", "GT", "GTE", "EQ", 
			"NEQ", "AND", "OR", "NOT", "NEG", "PRINTW", "PRINTB", "BEQ", "HALT", 
			"JAL", "JR", "SYMBOLS", "LABEL", "REG", "STRING", "COL", "NUMBER", "WHITESP", 
			"LINECOMMENTS"
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
		"\u0004\u0000.\u013e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001"+
		"$\u0001$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0005\'\u0107\b\'\n\'\f\'\u010a\t\'\u0001(\u0001(\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u0117\b)\u0001*\u0001"+
		"*\u0001+\u0004+\u011c\b+\u000b+\f+\u011d\u0001,\u0001,\u0001-\u0001-\u0003"+
		"-\u0124\b-\u0001-\u0001-\u0005-\u0128\b-\n-\f-\u012b\t-\u0003-\u012d\b"+
		"-\u0001.\u0004.\u0130\b.\u000b.\f.\u0131\u0001.\u0001.\u0001/\u0001/\u0005"+
		"/\u0138\b/\n/\f/\u013b\t/\u0001/\u0001/\u0000\u00000\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K&M\'O(Q\u0000S)U\u0000"+
		"W*Y+[,]-_.\u0001\u0000\u0003\u0002\u0000AZaz\u0003\u0000\t\n\r\r  \u0002"+
		"\u0000\n\n\r\r\u0147\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
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
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000"+
		"A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001"+
		"\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000"+
		"\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000"+
		"O\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000W\u0001"+
		"\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000"+
		"\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0001"+
		"a\u0001\u0000\u0000\u0000\u0003c\u0001\u0000\u0000\u0000\u0005e\u0001"+
		"\u0000\u0000\u0000\u0007k\u0001\u0000\u0000\u0000\tp\u0001\u0000\u0000"+
		"\u0000\u000bu\u0001\u0000\u0000\u0000\r{\u0001\u0000\u0000\u0000\u000f"+
		"\u0080\u0001\u0000\u0000\u0000\u0011\u0085\u0001\u0000\u0000\u0000\u0013"+
		"\u0088\u0001\u0000\u0000\u0000\u0015\u008c\u0001\u0000\u0000\u0000\u0017"+
		"\u008f\u0001\u0000\u0000\u0000\u0019\u0092\u0001\u0000\u0000\u0000\u001b"+
		"\u0095\u0001\u0000\u0000\u0000\u001d\u0098\u0001\u0000\u0000\u0000\u001f"+
		"\u009c\u0001\u0000\u0000\u0000!\u00a1\u0001\u0000\u0000\u0000#\u00a5\u0001"+
		"\u0000\u0000\u0000%\u00aa\u0001\u0000\u0000\u0000\'\u00af\u0001\u0000"+
		"\u0000\u0000)\u00b5\u0001\u0000\u0000\u0000+\u00b9\u0001\u0000\u0000\u0000"+
		"-\u00be\u0001\u0000\u0000\u0000/\u00c1\u0001\u0000\u0000\u00001\u00c5"+
		"\u0001\u0000\u0000\u00003\u00c8\u0001\u0000\u0000\u00005\u00cc\u0001\u0000"+
		"\u0000\u00007\u00cf\u0001\u0000\u0000\u00009\u00d3\u0001\u0000\u0000\u0000"+
		";\u00d7\u0001\u0000\u0000\u0000=\u00da\u0001\u0000\u0000\u0000?\u00de"+
		"\u0001\u0000\u0000\u0000A\u00e2\u0001\u0000\u0000\u0000C\u00e9\u0001\u0000"+
		"\u0000\u0000E\u00f0\u0001\u0000\u0000\u0000G\u00f4\u0001\u0000\u0000\u0000"+
		"I\u00f9\u0001\u0000\u0000\u0000K\u00fd\u0001\u0000\u0000\u0000M\u0100"+
		"\u0001\u0000\u0000\u0000O\u0102\u0001\u0000\u0000\u0000Q\u010b\u0001\u0000"+
		"\u0000\u0000S\u010d\u0001\u0000\u0000\u0000U\u0118\u0001\u0000\u0000\u0000"+
		"W\u011b\u0001\u0000\u0000\u0000Y\u011f\u0001\u0000\u0000\u0000[\u012c"+
		"\u0001\u0000\u0000\u0000]\u012f\u0001\u0000\u0000\u0000_\u0135\u0001\u0000"+
		"\u0000\u0000ab\u0005(\u0000\u0000b\u0002\u0001\u0000\u0000\u0000cd\u0005"+
		")\u0000\u0000d\u0004\u0001\u0000\u0000\u0000ef\u0005p\u0000\u0000fg\u0005"+
		"u\u0000\u0000gh\u0005s\u0000\u0000hi\u0005h\u0000\u0000ij\u0005w\u0000"+
		"\u0000j\u0006\u0001\u0000\u0000\u0000kl\u0005p\u0000\u0000lm\u0005o\u0000"+
		"\u0000mn\u0005p\u0000\u0000no\u0005w\u0000\u0000o\b\u0001\u0000\u0000"+
		"\u0000pq\u0005t\u0000\u0000qr\u0005o\u0000\u0000rs\u0005p\u0000\u0000"+
		"st\u0005w\u0000\u0000t\n\u0001\u0000\u0000\u0000uv\u0005p\u0000\u0000"+
		"vw\u0005u\u0000\u0000wx\u0005s\u0000\u0000xy\u0005h\u0000\u0000yz\u0005"+
		"b\u0000\u0000z\f\u0001\u0000\u0000\u0000{|\u0005p\u0000\u0000|}\u0005"+
		"o\u0000\u0000}~\u0005p\u0000\u0000~\u007f\u0005b\u0000\u0000\u007f\u000e"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0005t\u0000\u0000\u0081\u0082\u0005"+
		"o\u0000\u0000\u0082\u0083\u0005p\u0000\u0000\u0083\u0084\u0005b\u0000"+
		"\u0000\u0084\u0010\u0001\u0000\u0000\u0000\u0085\u0086\u0005l\u0000\u0000"+
		"\u0086\u0087\u0005i\u0000\u0000\u0087\u0012\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0005m\u0000\u0000\u0089\u008a\u0005o\u0000\u0000\u008a\u008b\u0005"+
		"v\u0000\u0000\u008b\u0014\u0001\u0000\u0000\u0000\u008c\u008d\u0005l\u0000"+
		"\u0000\u008d\u008e\u0005w\u0000\u0000\u008e\u0016\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0005s\u0000\u0000\u0090\u0091\u0005w\u0000\u0000\u0091\u0018"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0005l\u0000\u0000\u0093\u0094\u0005"+
		"b\u0000\u0000\u0094\u001a\u0001\u0000\u0000\u0000\u0095\u0096\u0005s\u0000"+
		"\u0000\u0096\u0097\u0005b\u0000\u0000\u0097\u001c\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0005a\u0000\u0000\u0099\u009a\u0005d\u0000\u0000\u009a\u009b"+
		"\u0005d\u0000\u0000\u009b\u001e\u0001\u0000\u0000\u0000\u009c\u009d\u0005"+
		"a\u0000\u0000\u009d\u009e\u0005d\u0000\u0000\u009e\u009f\u0005d\u0000"+
		"\u0000\u009f\u00a0\u0005i\u0000\u0000\u00a0 \u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0005s\u0000\u0000\u00a2\u00a3\u0005u\u0000\u0000\u00a3\u00a4\u0005"+
		"b\u0000\u0000\u00a4\"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005s\u0000"+
		"\u0000\u00a6\u00a7\u0005u\u0000\u0000\u00a7\u00a8\u0005b\u0000\u0000\u00a8"+
		"\u00a9\u0005i\u0000\u0000\u00a9$\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005"+
		"m\u0000\u0000\u00ab\u00ac\u0005u\u0000\u0000\u00ac\u00ad\u0005l\u0000"+
		"\u0000\u00ad\u00ae\u0005t\u0000\u0000\u00ae&\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0005m\u0000\u0000\u00b0\u00b1\u0005u\u0000\u0000\u00b1\u00b2\u0005"+
		"l\u0000\u0000\u00b2\u00b3\u0005t\u0000\u0000\u00b3\u00b4\u0005i\u0000"+
		"\u0000\u00b4(\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005d\u0000\u0000\u00b6"+
		"\u00b7\u0005i\u0000\u0000\u00b7\u00b8\u0005v\u0000\u0000\u00b8*\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0005d\u0000\u0000\u00ba\u00bb\u0005i\u0000"+
		"\u0000\u00bb\u00bc\u0005v\u0000\u0000\u00bc\u00bd\u0005i\u0000\u0000\u00bd"+
		",\u0001\u0000\u0000\u0000\u00be\u00bf\u0005l\u0000\u0000\u00bf\u00c0\u0005"+
		"t\u0000\u0000\u00c0.\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005l\u0000"+
		"\u0000\u00c2\u00c3\u0005t\u0000\u0000\u00c3\u00c4\u0005e\u0000\u0000\u00c4"+
		"0\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005g\u0000\u0000\u00c6\u00c7\u0005"+
		"t\u0000\u0000\u00c72\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005g\u0000"+
		"\u0000\u00c9\u00ca\u0005t\u0000\u0000\u00ca\u00cb\u0005e\u0000\u0000\u00cb"+
		"4\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005e\u0000\u0000\u00cd\u00ce\u0005"+
		"q\u0000\u0000\u00ce6\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005n\u0000"+
		"\u0000\u00d0\u00d1\u0005e\u0000\u0000\u00d1\u00d2\u0005q\u0000\u0000\u00d2"+
		"8\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005a\u0000\u0000\u00d4\u00d5\u0005"+
		"n\u0000\u0000\u00d5\u00d6\u0005d\u0000\u0000\u00d6:\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d8\u0005o\u0000\u0000\u00d8\u00d9\u0005r\u0000\u0000\u00d9"+
		"<\u0001\u0000\u0000\u0000\u00da\u00db\u0005n\u0000\u0000\u00db\u00dc\u0005"+
		"o\u0000\u0000\u00dc\u00dd\u0005t\u0000\u0000\u00dd>\u0001\u0000\u0000"+
		"\u0000\u00de\u00df\u0005n\u0000\u0000\u00df\u00e0\u0005e\u0000\u0000\u00e0"+
		"\u00e1\u0005g\u0000\u0000\u00e1@\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005"+
		"p\u0000\u0000\u00e3\u00e4\u0005r\u0000\u0000\u00e4\u00e5\u0005i\u0000"+
		"\u0000\u00e5\u00e6\u0005n\u0000\u0000\u00e6\u00e7\u0005t\u0000\u0000\u00e7"+
		"\u00e8\u0005w\u0000\u0000\u00e8B\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005"+
		"p\u0000\u0000\u00ea\u00eb\u0005r\u0000\u0000\u00eb\u00ec\u0005i\u0000"+
		"\u0000\u00ec\u00ed\u0005n\u0000\u0000\u00ed\u00ee\u0005t\u0000\u0000\u00ee"+
		"\u00ef\u0005b\u0000\u0000\u00efD\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005"+
		"b\u0000\u0000\u00f1\u00f2\u0005e\u0000\u0000\u00f2\u00f3\u0005q\u0000"+
		"\u0000\u00f3F\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005h\u0000\u0000\u00f5"+
		"\u00f6\u0005a\u0000\u0000\u00f6\u00f7\u0005l\u0000\u0000\u00f7\u00f8\u0005"+
		"t\u0000\u0000\u00f8H\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005j\u0000"+
		"\u0000\u00fa\u00fb\u0005a\u0000\u0000\u00fb\u00fc\u0005l\u0000\u0000\u00fc"+
		"J\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005j\u0000\u0000\u00fe\u00ff\u0005"+
		"r\u0000\u0000\u00ffL\u0001\u0000\u0000\u0000\u0100\u0101\u0005_\u0000"+
		"\u0000\u0101N\u0001\u0000\u0000\u0000\u0102\u0108\u0003W+\u0000\u0103"+
		"\u0107\u0003W+\u0000\u0104\u0107\u0003[-\u0000\u0105\u0107\u0003M&\u0000"+
		"\u0106\u0103\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000"+
		"\u0106\u0105\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000\u0000\u0000"+
		"\u0108\u0106\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000"+
		"\u0109P\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010b"+
		"\u010c\u000209\u0000\u010cR\u0001\u0000\u0000\u0000\u010d\u0116\u0005"+
		"$\u0000\u0000\u010e\u010f\u0005t\u0000\u0000\u010f\u0117\u0003Q(\u0000"+
		"\u0110\u0111\u0005r\u0000\u0000\u0111\u0117\u0005a\u0000\u0000\u0112\u0113"+
		"\u0005s\u0000\u0000\u0113\u0117\u0005p\u0000\u0000\u0114\u0115\u0005f"+
		"\u0000\u0000\u0115\u0117\u0005p\u0000\u0000\u0116\u010e\u0001\u0000\u0000"+
		"\u0000\u0116\u0110\u0001\u0000\u0000\u0000\u0116\u0112\u0001\u0000\u0000"+
		"\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0117T\u0001\u0000\u0000\u0000"+
		"\u0118\u0119\u0007\u0000\u0000\u0000\u0119V\u0001\u0000\u0000\u0000\u011a"+
		"\u011c\u0003U*\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001"+
		"\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011d\u011e\u0001"+
		"\u0000\u0000\u0000\u011eX\u0001\u0000\u0000\u0000\u011f\u0120\u0005:\u0000"+
		"\u0000\u0120Z\u0001\u0000\u0000\u0000\u0121\u012d\u00050\u0000\u0000\u0122"+
		"\u0124\u0005-\u0000\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u0129"+
		"\u000219\u0000\u0126\u0128\u0003Q(\u0000\u0127\u0126\u0001\u0000\u0000"+
		"\u0000\u0128\u012b\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000\u0000"+
		"\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012d\u0001\u0000\u0000"+
		"\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012c\u0121\u0001\u0000\u0000"+
		"\u0000\u012c\u0123\u0001\u0000\u0000\u0000\u012d\\\u0001\u0000\u0000\u0000"+
		"\u012e\u0130\u0007\u0001\u0000\u0000\u012f\u012e\u0001\u0000\u0000\u0000"+
		"\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000"+
		"\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000"+
		"\u0133\u0134\u0006.\u0000\u0000\u0134^\u0001\u0000\u0000\u0000\u0135\u0139"+
		"\u0005;\u0000\u0000\u0136\u0138\b\u0002\u0000\u0000\u0137\u0136\u0001"+
		"\u0000\u0000\u0000\u0138\u013b\u0001\u0000\u0000\u0000\u0139\u0137\u0001"+
		"\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013c\u0001"+
		"\u0000\u0000\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u013d\u0006"+
		"/\u0000\u0000\u013d`\u0001\u0000\u0000\u0000\n\u0000\u0106\u0108\u0116"+
		"\u011d\u0123\u0129\u012c\u0131\u0139\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}