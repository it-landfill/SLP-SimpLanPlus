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
		GT=11, GTE=12, COL=13, NUMBER=14, WHITESP=15, ERR=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", "LT", "LTE", 
			"GT", "GTE", "COL", "NUMBER", "WHITESP", "ERR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'print'", 
			"'halt'", "'lt'", "'lte'", "'gt'", "'gte'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", "LT", 
			"LTE", "GT", "GTE", "COL", "NUMBER", "WHITESP", "ERR"
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
		case 15:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22q\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\5\17[\n\17\3\17\3\17\7\17_\n\17\f\17\16\17b\13\17\5\17d\n\17"+
		"\3\20\6\20g\n\20\r\20\16\20h\3\20\3\20\3\21\3\21\3\21\3\21\3\21\2\2\22"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22\3\2\3\5\2\13\f\17\17\"\"\2t\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5(\3\2\2\2\7,\3\2\2\2\t\60\3"+
		"\2\2\2\13\64\3\2\2\2\r9\3\2\2\2\17=\3\2\2\2\21C\3\2\2\2\23H\3\2\2\2\25"+
		"K\3\2\2\2\27O\3\2\2\2\31R\3\2\2\2\33V\3\2\2\2\35c\3\2\2\2\37f\3\2\2\2"+
		"!l\3\2\2\2#$\7r\2\2$%\7w\2\2%&\7u\2\2&\'\7j\2\2\'\4\3\2\2\2()\7r\2\2)"+
		"*\7q\2\2*+\7r\2\2+\6\3\2\2\2,-\7c\2\2-.\7f\2\2./\7f\2\2/\b\3\2\2\2\60"+
		"\61\7u\2\2\61\62\7w\2\2\62\63\7d\2\2\63\n\3\2\2\2\64\65\7o\2\2\65\66\7"+
		"w\2\2\66\67\7n\2\2\678\7v\2\28\f\3\2\2\29:\7f\2\2:;\7k\2\2;<\7x\2\2<\16"+
		"\3\2\2\2=>\7r\2\2>?\7t\2\2?@\7k\2\2@A\7p\2\2AB\7v\2\2B\20\3\2\2\2CD\7"+
		"j\2\2DE\7c\2\2EF\7n\2\2FG\7v\2\2G\22\3\2\2\2HI\7n\2\2IJ\7v\2\2J\24\3\2"+
		"\2\2KL\7n\2\2LM\7v\2\2MN\7g\2\2N\26\3\2\2\2OP\7i\2\2PQ\7v\2\2Q\30\3\2"+
		"\2\2RS\7i\2\2ST\7v\2\2TU\7g\2\2U\32\3\2\2\2VW\7<\2\2W\34\3\2\2\2Xd\7\62"+
		"\2\2Y[\7/\2\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\`\4\63;\2]_\4\62;\2^]\3"+
		"\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ad\3\2\2\2b`\3\2\2\2cX\3\2\2\2cZ\3"+
		"\2\2\2d\36\3\2\2\2eg\t\2\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2i"+
		"j\3\2\2\2jk\b\20\2\2k \3\2\2\2lm\13\2\2\2mn\b\21\3\2no\3\2\2\2op\b\21"+
		"\2\2p\"\3\2\2\2\7\2Z`ch\4\2\3\2\3\21\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}