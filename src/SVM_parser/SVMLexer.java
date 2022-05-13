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
		PUSH=1, POP=2, ADD=3, SUB=4, MULT=5, DIV=6, PRINT=7, HALT=8, COL=9, NUMBER=10, 
		WHITESP=11, ERR=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", "COL", "NUMBER", 
			"WHITESP", "ERR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'print'", 
			"'halt'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "PRINT", "HALT", "COL", 
			"NUMBER", "WHITESP", "ERR"
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
		case 11:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16[\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\5\13E\n\13\3\13\3\13\7"+
		"\13I\n\13\f\13\16\13L\13\13\5\13N\n\13\3\f\6\fQ\n\f\r\f\16\fR\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\3\2\3\5\2\13\f\17\17\"\"\2^\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5"+
		" \3\2\2\2\7$\3\2\2\2\t(\3\2\2\2\13,\3\2\2\2\r\61\3\2\2\2\17\65\3\2\2\2"+
		"\21;\3\2\2\2\23@\3\2\2\2\25M\3\2\2\2\27P\3\2\2\2\31V\3\2\2\2\33\34\7r"+
		"\2\2\34\35\7w\2\2\35\36\7u\2\2\36\37\7j\2\2\37\4\3\2\2\2 !\7r\2\2!\"\7"+
		"q\2\2\"#\7r\2\2#\6\3\2\2\2$%\7c\2\2%&\7f\2\2&\'\7f\2\2\'\b\3\2\2\2()\7"+
		"u\2\2)*\7w\2\2*+\7d\2\2+\n\3\2\2\2,-\7o\2\2-.\7w\2\2./\7n\2\2/\60\7v\2"+
		"\2\60\f\3\2\2\2\61\62\7f\2\2\62\63\7k\2\2\63\64\7x\2\2\64\16\3\2\2\2\65"+
		"\66\7r\2\2\66\67\7t\2\2\678\7k\2\289\7p\2\29:\7v\2\2:\20\3\2\2\2;<\7j"+
		"\2\2<=\7c\2\2=>\7n\2\2>?\7v\2\2?\22\3\2\2\2@A\7<\2\2A\24\3\2\2\2BN\7\62"+
		"\2\2CE\7/\2\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FJ\4\63;\2GI\4\62;\2HG\3\2"+
		"\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2LJ\3\2\2\2MB\3\2\2\2MD\3\2"+
		"\2\2N\26\3\2\2\2OQ\t\2\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3"+
		"\2\2\2TU\b\f\2\2U\30\3\2\2\2VW\13\2\2\2WX\b\r\3\2XY\3\2\2\2YZ\b\r\2\2"+
		"Z\32\3\2\2\2\7\2DJMR\4\2\3\2\3\r\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}