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
		GT=11, GTE=12, EQ=13, NEQ=14, AND=15, OR=16, COL=17, NUMBER=18, WHITESP=19, 
		ERR=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", "LT", "LTE", 
			"GT", "GTE", "EQ", "NEQ", "AND", "OR", "COL", "NUMBER", "WHITESP", "ERR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'print'", 
			"'halt'", "'lt'", "'lte'", "'gt'", "'gte'", "'eq'", "'neq'", "'and'", 
			"'or'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", "LT", 
			"LTE", "GT", "GTE", "EQ", "NEQ", "AND", "OR", "COL", "NUMBER", "WHITESP", 
			"ERR"
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
		case 19:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0087\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\5\23q\n\23\3\23"+
		"\3\23\7\23u\n\23\f\23\16\23x\13\23\5\23z\n\23\3\24\6\24}\n\24\r\24\16"+
		"\24~\3\24\3\24\3\25\3\25\3\25\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26\3\2\3\5\2\13\f\17\17\"\"\2\u008a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\3+\3\2\2\2\5\60\3\2\2\2\7\64\3\2\2\2\t8\3\2\2\2\13<\3\2\2\2\rA"+
		"\3\2\2\2\17E\3\2\2\2\21K\3\2\2\2\23P\3\2\2\2\25S\3\2\2\2\27W\3\2\2\2\31"+
		"Z\3\2\2\2\33^\3\2\2\2\35a\3\2\2\2\37e\3\2\2\2!i\3\2\2\2#l\3\2\2\2%y\3"+
		"\2\2\2\'|\3\2\2\2)\u0082\3\2\2\2+,\7r\2\2,-\7w\2\2-.\7u\2\2./\7j\2\2/"+
		"\4\3\2\2\2\60\61\7r\2\2\61\62\7q\2\2\62\63\7r\2\2\63\6\3\2\2\2\64\65\7"+
		"c\2\2\65\66\7f\2\2\66\67\7f\2\2\67\b\3\2\2\289\7u\2\29:\7w\2\2:;\7d\2"+
		"\2;\n\3\2\2\2<=\7o\2\2=>\7w\2\2>?\7n\2\2?@\7v\2\2@\f\3\2\2\2AB\7f\2\2"+
		"BC\7k\2\2CD\7x\2\2D\16\3\2\2\2EF\7r\2\2FG\7t\2\2GH\7k\2\2HI\7p\2\2IJ\7"+
		"v\2\2J\20\3\2\2\2KL\7j\2\2LM\7c\2\2MN\7n\2\2NO\7v\2\2O\22\3\2\2\2PQ\7"+
		"n\2\2QR\7v\2\2R\24\3\2\2\2ST\7n\2\2TU\7v\2\2UV\7g\2\2V\26\3\2\2\2WX\7"+
		"i\2\2XY\7v\2\2Y\30\3\2\2\2Z[\7i\2\2[\\\7v\2\2\\]\7g\2\2]\32\3\2\2\2^_"+
		"\7g\2\2_`\7s\2\2`\34\3\2\2\2ab\7p\2\2bc\7g\2\2cd\7s\2\2d\36\3\2\2\2ef"+
		"\7c\2\2fg\7p\2\2gh\7f\2\2h \3\2\2\2ij\7q\2\2jk\7t\2\2k\"\3\2\2\2lm\7<"+
		"\2\2m$\3\2\2\2nz\7\62\2\2oq\7/\2\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rv\4\63"+
		";\2su\4\62;\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wz\3\2\2\2xv\3\2"+
		"\2\2yn\3\2\2\2yp\3\2\2\2z&\3\2\2\2{}\t\2\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2"+
		"\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\b\24\2\2\u0081(\3\2\2"+
		"\2\u0082\u0083\13\2\2\2\u0083\u0084\b\25\3\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\b\25\2\2\u0086*\3\2\2\2\7\2pvy~\4\2\3\2\3\25\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}