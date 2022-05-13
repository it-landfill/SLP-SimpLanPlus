// Generated from /Users/alessandrobenetton/Library/CloudStorage/OneDrive-AlmaMaterStudiorumUniversitàdiBologna/University/I_Anno/II_[81941]-Compilatori_e_Interpreti/Progetto_CEI/src/SVM_parser/SVM.g4 by ANTLR 4.9.2
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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUSH=1, POP=2, ADD=3, SUB=4, MULT=5, DIV=6, PRINT=7, HALT=8, LT=9, LTE=10, 
		GT=11, GTE=12, EQ=13, NEQ=14, COL=15, NUMBER=16, WHITESP=17, ERR=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", "LT", "LTE", 
			"GT", "GTE", "EQ", "NEQ", "COL", "NUMBER", "WHITESP", "ERR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'print'", 
			"'halt'", "'lt'", "'lte'", "'gt'", "'gte'", "'eq'", "'neq'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", "LT", 
			"LTE", "GT", "GTE", "EQ", "NEQ", "COL", "NUMBER", "WHITESP", "ERR"
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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 17:
			ERR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.err.println("Invalid char: "+ getText()); lexicalErrors++;  
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24|\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\5\21f"+
		"\n\21\3\21\3\21\7\21j\n\21\f\21\16\21m\13\21\5\21o\n\21\3\22\6\22r\n\22"+
		"\r\22\16\22s\3\22\3\22\3\23\3\23\3\23\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\3\2\3\5\2\13\f\17\17\"\"\2\177\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5,\3\2\2\2"+
		"\7\60\3\2\2\2\t\64\3\2\2\2\138\3\2\2\2\r=\3\2\2\2\17A\3\2\2\2\21G\3\2"+
		"\2\2\23L\3\2\2\2\25O\3\2\2\2\27S\3\2\2\2\31V\3\2\2\2\33Z\3\2\2\2\35]\3"+
		"\2\2\2\37a\3\2\2\2!n\3\2\2\2#q\3\2\2\2%w\3\2\2\2\'(\7r\2\2()\7w\2\2)*"+
		"\7u\2\2*+\7j\2\2+\4\3\2\2\2,-\7r\2\2-.\7q\2\2./\7r\2\2/\6\3\2\2\2\60\61"+
		"\7c\2\2\61\62\7f\2\2\62\63\7f\2\2\63\b\3\2\2\2\64\65\7u\2\2\65\66\7w\2"+
		"\2\66\67\7d\2\2\67\n\3\2\2\289\7o\2\29:\7w\2\2:;\7n\2\2;<\7v\2\2<\f\3"+
		"\2\2\2=>\7f\2\2>?\7k\2\2?@\7x\2\2@\16\3\2\2\2AB\7r\2\2BC\7t\2\2CD\7k\2"+
		"\2DE\7p\2\2EF\7v\2\2F\20\3\2\2\2GH\7j\2\2HI\7c\2\2IJ\7n\2\2JK\7v\2\2K"+
		"\22\3\2\2\2LM\7n\2\2MN\7v\2\2N\24\3\2\2\2OP\7n\2\2PQ\7v\2\2QR\7g\2\2R"+
		"\26\3\2\2\2ST\7i\2\2TU\7v\2\2U\30\3\2\2\2VW\7i\2\2WX\7v\2\2XY\7g\2\2Y"+
		"\32\3\2\2\2Z[\7g\2\2[\\\7s\2\2\\\34\3\2\2\2]^\7p\2\2^_\7g\2\2_`\7s\2\2"+
		"`\36\3\2\2\2ab\7<\2\2b \3\2\2\2co\7\62\2\2df\7/\2\2ed\3\2\2\2ef\3\2\2"+
		"\2fg\3\2\2\2gk\4\63;\2hj\4\62;\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2"+
		"\2lo\3\2\2\2mk\3\2\2\2nc\3\2\2\2ne\3\2\2\2o\"\3\2\2\2pr\t\2\2\2qp\3\2"+
		"\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\b\22\2\2v$\3\2\2\2wx\13"+
		"\2\2\2xy\b\23\3\2yz\3\2\2\2z{\b\23\2\2{&\3\2\2\2\7\2ekns\4\2\3\2\3\23"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}