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
		GT=11, GTE=12, EQ=13, NEQ=14, AND=15, OR=16, NOT=17, COL=18, NUMBER=19, 
		WHITESP=20, ERR=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", "LT", "LTE", 
			"GT", "GTE", "EQ", "NEQ", "AND", "OR", "NOT", "COL", "NUMBER", "WHITESP", 
			"ERR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'print'", 
			"'halt'", "'lt'", "'lte'", "'gt'", "'gte'", "'eq'", "'neq'", "'and'", 
			"'or'", "'not'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", "LT", 
			"LTE", "GT", "GTE", "EQ", "NEQ", "AND", "OR", "NOT", "COL", "NUMBER", 
			"WHITESP", "ERR"
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
		case 20:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u008d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\5\24w\n\24\3\24\3\24\7\24{\n\24\f\24\16\24~\13\24\5\24\u0080"+
		"\n\24\3\25\6\25\u0083\n\25\r\25\16\25\u0084\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3\2\3\5\2\13\f\17\17\""+
		"\"\2\u0090\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2"+
		"\5\62\3\2\2\2\7\66\3\2\2\2\t:\3\2\2\2\13>\3\2\2\2\rC\3\2\2\2\17G\3\2\2"+
		"\2\21M\3\2\2\2\23R\3\2\2\2\25U\3\2\2\2\27Y\3\2\2\2\31\\\3\2\2\2\33`\3"+
		"\2\2\2\35c\3\2\2\2\37g\3\2\2\2!k\3\2\2\2#n\3\2\2\2%r\3\2\2\2\'\177\3\2"+
		"\2\2)\u0082\3\2\2\2+\u0088\3\2\2\2-.\7r\2\2./\7w\2\2/\60\7u\2\2\60\61"+
		"\7j\2\2\61\4\3\2\2\2\62\63\7r\2\2\63\64\7q\2\2\64\65\7r\2\2\65\6\3\2\2"+
		"\2\66\67\7c\2\2\678\7f\2\289\7f\2\29\b\3\2\2\2:;\7u\2\2;<\7w\2\2<=\7d"+
		"\2\2=\n\3\2\2\2>?\7o\2\2?@\7w\2\2@A\7n\2\2AB\7v\2\2B\f\3\2\2\2CD\7f\2"+
		"\2DE\7k\2\2EF\7x\2\2F\16\3\2\2\2GH\7r\2\2HI\7t\2\2IJ\7k\2\2JK\7p\2\2K"+
		"L\7v\2\2L\20\3\2\2\2MN\7j\2\2NO\7c\2\2OP\7n\2\2PQ\7v\2\2Q\22\3\2\2\2R"+
		"S\7n\2\2ST\7v\2\2T\24\3\2\2\2UV\7n\2\2VW\7v\2\2WX\7g\2\2X\26\3\2\2\2Y"+
		"Z\7i\2\2Z[\7v\2\2[\30\3\2\2\2\\]\7i\2\2]^\7v\2\2^_\7g\2\2_\32\3\2\2\2"+
		"`a\7g\2\2ab\7s\2\2b\34\3\2\2\2cd\7p\2\2de\7g\2\2ef\7s\2\2f\36\3\2\2\2"+
		"gh\7c\2\2hi\7p\2\2ij\7f\2\2j \3\2\2\2kl\7q\2\2lm\7t\2\2m\"\3\2\2\2no\7"+
		"p\2\2op\7q\2\2pq\7v\2\2q$\3\2\2\2rs\7<\2\2s&\3\2\2\2t\u0080\7\62\2\2u"+
		"w\7/\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2x|\4\63;\2y{\4\62;\2zy\3\2\2\2{"+
		"~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2\177t\3\2\2\2\177"+
		"v\3\2\2\2\u0080(\3\2\2\2\u0081\u0083\t\2\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0087\b\25\2\2\u0087*\3\2\2\2\u0088\u0089\13\2\2\2\u0089\u008a"+
		"\b\26\3\2\u008a\u008b\3\2\2\2\u008b\u008c\b\26\2\2\u008c,\3\2\2\2\7\2"+
		"v|\177\u0084\4\2\3\2\3\26\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}