// Generated from /Users/alessandrobenetton/Library/CloudStorage/OneDrive-AlmaMaterStudiorumUniversitàdiBologna/University/I_Anno/II_[81941]-Compilatori_e_Interpreti/Progetto_CEI/src/SVM_parser/SVM.g4 by ANTLR 4.10.1
package SVM_parser;

import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUSH=1, POP=2, TOP=3, LI=4, MOV=5, LW=6, SW=7, ADD=8, SUB=9, MULT=10, 
		DIV=11, LT=12, LTE=13, GT=14, GTE=15, EQ=16, NEQ=17, AND=18, OR=19, NOT=20, 
		NEG=21, PRINT=22, HALT=23, SYMBOLS=24, REG=25, MEM=26, STRING=27, COL=28, 
		NUMBER=29, WHITESP=30, LINECOMMENTS=31;
	public static final int
		RULE_assembly = 0, RULE_instruction = 1, RULE_push = 2, RULE_pop = 3, 
		RULE_top = 4, RULE_li = 5, RULE_mov = 6, RULE_lw = 7, RULE_sw = 8, RULE_add = 9, 
		RULE_sub = 10, RULE_mult = 11, RULE_div = 12, RULE_lt = 13, RULE_lte = 14, 
		RULE_gt = 15, RULE_gte = 16, RULE_eq = 17, RULE_neq = 18, RULE_and = 19, 
		RULE_or = 20, RULE_not = 21, RULE_neg = 22, RULE_print = 23, RULE_label = 24, 
		RULE_halt = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"assembly", "instruction", "push", "pop", "top", "li", "mov", "lw", "sw", 
			"add", "sub", "mult", "div", "lt", "lte", "gt", "gte", "eq", "neq", "and", 
			"or", "not", "neg", "print", "label", "halt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'push'", "'pop'", "'top'", "'li'", "'mov'", "'lw'", "'sw'", "'add'", 
			"'sub'", "'mult'", "'div'", "'lt'", "'lte'", "'gt'", "'gte'", "'eq'", 
			"'neq'", "'and'", "'or'", "'not'", "'neg'", "'print'", "'halt'", "'_'", 
			null, null, null, "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUSH", "POP", "TOP", "LI", "MOV", "LW", "SW", "ADD", "SUB", "MULT", 
			"DIV", "LT", "LTE", "GT", "GTE", "EQ", "NEQ", "AND", "OR", "NOT", "NEG", 
			"PRINT", "HALT", "SYMBOLS", "REG", "MEM", "STRING", "COL", "NUMBER", 
			"WHITESP", "LINECOMMENTS"
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

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SVMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class AssemblyContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterAssembly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitAssembly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAssembly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_assembly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUSH) | (1L << POP) | (1L << TOP) | (1L << LI) | (1L << MOV) | (1L << LW) | (1L << ADD) | (1L << SUB) | (1L << MULT) | (1L << DIV) | (1L << LT) | (1L << LTE) | (1L << GT) | (1L << GTE) | (1L << EQ) | (1L << NEQ) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << NEG) | (1L << PRINT) | (1L << HALT) | (1L << STRING))) != 0)) {
				{
				{
				setState(52);
				instruction();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public PushContext push() {
			return getRuleContext(PushContext.class,0);
		}
		public PopContext pop() {
			return getRuleContext(PopContext.class,0);
		}
		public TopContext top() {
			return getRuleContext(TopContext.class,0);
		}
		public LiContext li() {
			return getRuleContext(LiContext.class,0);
		}
		public MovContext mov() {
			return getRuleContext(MovContext.class,0);
		}
		public LwContext lw() {
			return getRuleContext(LwContext.class,0);
		}
		public SwContext sw() {
			return getRuleContext(SwContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public SubContext sub() {
			return getRuleContext(SubContext.class,0);
		}
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public DivContext div() {
			return getRuleContext(DivContext.class,0);
		}
		public LtContext lt() {
			return getRuleContext(LtContext.class,0);
		}
		public LteContext lte() {
			return getRuleContext(LteContext.class,0);
		}
		public GtContext gt() {
			return getRuleContext(GtContext.class,0);
		}
		public GteContext gte() {
			return getRuleContext(GteContext.class,0);
		}
		public EqContext eq() {
			return getRuleContext(EqContext.class,0);
		}
		public NeqContext neq() {
			return getRuleContext(NeqContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public HaltContext halt() {
			return getRuleContext(HaltContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				label();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				push();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				pop();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				top();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(62);
				li();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(63);
				mov();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(64);
				lw();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(65);
				sw();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(66);
				add();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(67);
				sub();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(68);
				mult();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(69);
				div();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(70);
				lt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(71);
				lte();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(72);
				gt();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(73);
				gte();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(74);
				eq();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(75);
				neq();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(76);
				and();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(77);
				or();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(78);
				not();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(79);
				neg();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(80);
				print();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(81);
				halt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PushContext extends ParserRuleContext {
		public Token src;
		public TerminalNode PUSH() { return getToken(SVMParser.PUSH, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public PushContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_push; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterPush(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitPush(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPush(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PushContext push() throws RecognitionException {
		PushContext _localctx = new PushContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_push);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(PUSH);
			setState(85);
			((PushContext)_localctx).src = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PopContext extends ParserRuleContext {
		public Token dest;
		public TerminalNode POP() { return getToken(SVMParser.POP, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public PopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterPop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitPop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PopContext pop() throws RecognitionException {
		PopContext _localctx = new PopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(POP);
			setState(88);
			((PopContext)_localctx).dest = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopContext extends ParserRuleContext {
		public Token dest;
		public TerminalNode TOP() { return getToken(SVMParser.TOP, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public TopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_top; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterTop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitTop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitTop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopContext top() throws RecognitionException {
		TopContext _localctx = new TopContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_top);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(TOP);
			setState(91);
			((TopContext)_localctx).dest = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiContext extends ParserRuleContext {
		public Token dest;
		public Token n;
		public TerminalNode LI() { return getToken(SVMParser.LI, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public LiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_li; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterLi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitLi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiContext li() throws RecognitionException {
		LiContext _localctx = new LiContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_li);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(LI);
			setState(94);
			((LiContext)_localctx).dest = match(REG);
			setState(95);
			((LiContext)_localctx).n = match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MovContext extends ParserRuleContext {
		public Token dest;
		public Token src;
		public TerminalNode MOV() { return getToken(SVMParser.MOV, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public MovContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mov; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterMov(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitMov(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitMov(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MovContext mov() throws RecognitionException {
		MovContext _localctx = new MovContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mov);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(MOV);
			setState(98);
			((MovContext)_localctx).dest = match(REG);
			setState(99);
			((MovContext)_localctx).src = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LwContext extends ParserRuleContext {
		public Token reg;
		public Token mem;
		public TerminalNode LW() { return getToken(SVMParser.LW, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public TerminalNode MEM() { return getToken(SVMParser.MEM, 0); }
		public LwContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterLw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitLw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LwContext lw() throws RecognitionException {
		LwContext _localctx = new LwContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(LW);
			setState(102);
			((LwContext)_localctx).reg = match(REG);
			setState(103);
			((LwContext)_localctx).mem = match(MEM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwContext extends ParserRuleContext {
		public Token reg;
		public Token mem;
		public TerminalNode LW() { return getToken(SVMParser.LW, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public TerminalNode MEM() { return getToken(SVMParser.MEM, 0); }
		public SwContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterSw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitSw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitSw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwContext sw() throws RecognitionException {
		SwContext _localctx = new SwContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(LW);
			setState(106);
			((SwContext)_localctx).reg = match(REG);
			setState(107);
			((SwContext)_localctx).mem = match(MEM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode ADD() { return getToken(SVMParser.ADD, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(ADD);
			setState(110);
			((AddContext)_localctx).dest = match(REG);
			setState(111);
			((AddContext)_localctx).reg1 = match(REG);
			setState(112);
			((AddContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode SUB() { return getToken(SVMParser.SUB, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public SubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubContext sub() throws RecognitionException {
		SubContext _localctx = new SubContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(SUB);
			setState(115);
			((SubContext)_localctx).dest = match(REG);
			setState(116);
			((SubContext)_localctx).reg1 = match(REG);
			setState(117);
			((SubContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode MULT() { return getToken(SVMParser.MULT, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultContext mult() throws RecognitionException {
		MultContext _localctx = new MultContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(MULT);
			setState(120);
			((MultContext)_localctx).dest = match(REG);
			setState(121);
			((MultContext)_localctx).reg1 = match(REG);
			setState(122);
			((MultContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DivContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode DIV() { return getToken(SVMParser.DIV, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public DivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_div; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivContext div() throws RecognitionException {
		DivContext _localctx = new DivContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_div);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(DIV);
			setState(125);
			((DivContext)_localctx).dest = match(REG);
			setState(126);
			((DivContext)_localctx).reg1 = match(REG);
			setState(127);
			((DivContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LtContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode LT() { return getToken(SVMParser.LT, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public LtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitLt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LtContext lt() throws RecognitionException {
		LtContext _localctx = new LtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(LT);
			setState(130);
			((LtContext)_localctx).dest = match(REG);
			setState(131);
			((LtContext)_localctx).reg1 = match(REG);
			setState(132);
			((LtContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LteContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode LTE() { return getToken(SVMParser.LTE, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public LteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lte; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterLte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitLte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLte(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LteContext lte() throws RecognitionException {
		LteContext _localctx = new LteContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lte);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(LTE);
			setState(135);
			((LteContext)_localctx).dest = match(REG);
			setState(136);
			((LteContext)_localctx).reg1 = match(REG);
			setState(137);
			((LteContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GtContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode GT() { return getToken(SVMParser.GT, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public GtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterGt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitGt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitGt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GtContext gt() throws RecognitionException {
		GtContext _localctx = new GtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_gt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(GT);
			setState(140);
			((GtContext)_localctx).dest = match(REG);
			setState(141);
			((GtContext)_localctx).reg1 = match(REG);
			setState(142);
			((GtContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GteContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode GTE() { return getToken(SVMParser.GTE, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public GteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gte; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterGte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitGte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitGte(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GteContext gte() throws RecognitionException {
		GteContext _localctx = new GteContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_gte);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(GTE);
			setState(145);
			((GteContext)_localctx).dest = match(REG);
			setState(146);
			((GteContext)_localctx).reg1 = match(REG);
			setState(147);
			((GteContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode EQ() { return getToken(SVMParser.EQ, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public EqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitEq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqContext eq() throws RecognitionException {
		EqContext _localctx = new EqContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(EQ);
			setState(150);
			((EqContext)_localctx).dest = match(REG);
			setState(151);
			((EqContext)_localctx).reg1 = match(REG);
			setState(152);
			((EqContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NeqContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode NEQ() { return getToken(SVMParser.NEQ, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public NeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterNeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitNeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitNeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NeqContext neq() throws RecognitionException {
		NeqContext _localctx = new NeqContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_neq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(NEQ);
			setState(155);
			((NeqContext)_localctx).dest = match(REG);
			setState(156);
			((NeqContext)_localctx).reg1 = match(REG);
			setState(157);
			((NeqContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode AND() { return getToken(SVMParser.AND, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(AND);
			setState(160);
			((AndContext)_localctx).dest = match(REG);
			setState(161);
			((AndContext)_localctx).reg1 = match(REG);
			setState(162);
			((AndContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode OR() { return getToken(SVMParser.OR, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(OR);
			setState(165);
			((OrContext)_localctx).dest = match(REG);
			setState(166);
			((OrContext)_localctx).reg1 = match(REG);
			setState(167);
			((OrContext)_localctx).reg2 = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotContext extends ParserRuleContext {
		public Token dest;
		public Token src;
		public TerminalNode NOT() { return getToken(SVMParser.NOT, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(NOT);
			setState(170);
			((NotContext)_localctx).dest = match(REG);
			setState(171);
			((NotContext)_localctx).src = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NegContext extends ParserRuleContext {
		public Token dest;
		public Token src;
		public TerminalNode NEG() { return getToken(SVMParser.NEG, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public NegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitNeg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitNeg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegContext neg() throws RecognitionException {
		NegContext _localctx = new NegContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_neg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(NEG);
			setState(174);
			((NegContext)_localctx).dest = match(REG);
			setState(175);
			((NegContext)_localctx).src = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public Token src;
		public TerminalNode PRINT() { return getToken(SVMParser.PRINT, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(PRINT);
			setState(178);
			((PrintContext)_localctx).src = match(REG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(SVMParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SVMParser.STRING, i);
		}
		public TerminalNode COL() { return getToken(SVMParser.COL, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(SVMParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SVMParser.NUMBER, i);
		}
		public List<TerminalNode> SYMBOLS() { return getTokens(SVMParser.SYMBOLS); }
		public TerminalNode SYMBOLS(int i) {
			return getToken(SVMParser.SYMBOLS, i);
		}
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(STRING);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYMBOLS) | (1L << STRING) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(181);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYMBOLS) | (1L << STRING) | (1L << NUMBER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			match(COL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HaltContext extends ParserRuleContext {
		public TerminalNode HALT() { return getToken(SVMParser.HALT, 0); }
		public HaltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_halt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterHalt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitHalt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitHalt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HaltContext halt() throws RecognitionException {
		HaltContext _localctx = new HaltContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_halt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(HALT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00c0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0005\u00006\b\u0000\n\u0000"+
		"\f\u00009\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001S\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0005\u0018\u00b7\b\u0018\n"+
		"\u0018\f\u0018\u00ba\t\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0000\u0000\u001a\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02\u0000\u0001"+
		"\u0003\u0000\u0018\u0018\u001b\u001b\u001d\u001d\u00be\u00007\u0001\u0000"+
		"\u0000\u0000\u0002R\u0001\u0000\u0000\u0000\u0004T\u0001\u0000\u0000\u0000"+
		"\u0006W\u0001\u0000\u0000\u0000\bZ\u0001\u0000\u0000\u0000\n]\u0001\u0000"+
		"\u0000\u0000\fa\u0001\u0000\u0000\u0000\u000ee\u0001\u0000\u0000\u0000"+
		"\u0010i\u0001\u0000\u0000\u0000\u0012m\u0001\u0000\u0000\u0000\u0014r"+
		"\u0001\u0000\u0000\u0000\u0016w\u0001\u0000\u0000\u0000\u0018|\u0001\u0000"+
		"\u0000\u0000\u001a\u0081\u0001\u0000\u0000\u0000\u001c\u0086\u0001\u0000"+
		"\u0000\u0000\u001e\u008b\u0001\u0000\u0000\u0000 \u0090\u0001\u0000\u0000"+
		"\u0000\"\u0095\u0001\u0000\u0000\u0000$\u009a\u0001\u0000\u0000\u0000"+
		"&\u009f\u0001\u0000\u0000\u0000(\u00a4\u0001\u0000\u0000\u0000*\u00a9"+
		"\u0001\u0000\u0000\u0000,\u00ad\u0001\u0000\u0000\u0000.\u00b1\u0001\u0000"+
		"\u0000\u00000\u00b4\u0001\u0000\u0000\u00002\u00bd\u0001\u0000\u0000\u0000"+
		"46\u0003\u0002\u0001\u000054\u0001\u0000\u0000\u000069\u0001\u0000\u0000"+
		"\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008\u0001\u0001"+
		"\u0000\u0000\u000097\u0001\u0000\u0000\u0000:S\u00030\u0018\u0000;S\u0003"+
		"\u0004\u0002\u0000<S\u0003\u0006\u0003\u0000=S\u0003\b\u0004\u0000>S\u0003"+
		"\n\u0005\u0000?S\u0003\f\u0006\u0000@S\u0003\u000e\u0007\u0000AS\u0003"+
		"\u0010\b\u0000BS\u0003\u0012\t\u0000CS\u0003\u0014\n\u0000DS\u0003\u0016"+
		"\u000b\u0000ES\u0003\u0018\f\u0000FS\u0003\u001a\r\u0000GS\u0003\u001c"+
		"\u000e\u0000HS\u0003\u001e\u000f\u0000IS\u0003 \u0010\u0000JS\u0003\""+
		"\u0011\u0000KS\u0003$\u0012\u0000LS\u0003&\u0013\u0000MS\u0003(\u0014"+
		"\u0000NS\u0003*\u0015\u0000OS\u0003,\u0016\u0000PS\u0003.\u0017\u0000"+
		"QS\u00032\u0019\u0000R:\u0001\u0000\u0000\u0000R;\u0001\u0000\u0000\u0000"+
		"R<\u0001\u0000\u0000\u0000R=\u0001\u0000\u0000\u0000R>\u0001\u0000\u0000"+
		"\u0000R?\u0001\u0000\u0000\u0000R@\u0001\u0000\u0000\u0000RA\u0001\u0000"+
		"\u0000\u0000RB\u0001\u0000\u0000\u0000RC\u0001\u0000\u0000\u0000RD\u0001"+
		"\u0000\u0000\u0000RE\u0001\u0000\u0000\u0000RF\u0001\u0000\u0000\u0000"+
		"RG\u0001\u0000\u0000\u0000RH\u0001\u0000\u0000\u0000RI\u0001\u0000\u0000"+
		"\u0000RJ\u0001\u0000\u0000\u0000RK\u0001\u0000\u0000\u0000RL\u0001\u0000"+
		"\u0000\u0000RM\u0001\u0000\u0000\u0000RN\u0001\u0000\u0000\u0000RO\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000"+
		"S\u0003\u0001\u0000\u0000\u0000TU\u0005\u0001\u0000\u0000UV\u0005\u0019"+
		"\u0000\u0000V\u0005\u0001\u0000\u0000\u0000WX\u0005\u0002\u0000\u0000"+
		"XY\u0005\u0019\u0000\u0000Y\u0007\u0001\u0000\u0000\u0000Z[\u0005\u0003"+
		"\u0000\u0000[\\\u0005\u0019\u0000\u0000\\\t\u0001\u0000\u0000\u0000]^"+
		"\u0005\u0004\u0000\u0000^_\u0005\u0019\u0000\u0000_`\u0005\u001d\u0000"+
		"\u0000`\u000b\u0001\u0000\u0000\u0000ab\u0005\u0005\u0000\u0000bc\u0005"+
		"\u0019\u0000\u0000cd\u0005\u0019\u0000\u0000d\r\u0001\u0000\u0000\u0000"+
		"ef\u0005\u0006\u0000\u0000fg\u0005\u0019\u0000\u0000gh\u0005\u001a\u0000"+
		"\u0000h\u000f\u0001\u0000\u0000\u0000ij\u0005\u0006\u0000\u0000jk\u0005"+
		"\u0019\u0000\u0000kl\u0005\u001a\u0000\u0000l\u0011\u0001\u0000\u0000"+
		"\u0000mn\u0005\b\u0000\u0000no\u0005\u0019\u0000\u0000op\u0005\u0019\u0000"+
		"\u0000pq\u0005\u0019\u0000\u0000q\u0013\u0001\u0000\u0000\u0000rs\u0005"+
		"\t\u0000\u0000st\u0005\u0019\u0000\u0000tu\u0005\u0019\u0000\u0000uv\u0005"+
		"\u0019\u0000\u0000v\u0015\u0001\u0000\u0000\u0000wx\u0005\n\u0000\u0000"+
		"xy\u0005\u0019\u0000\u0000yz\u0005\u0019\u0000\u0000z{\u0005\u0019\u0000"+
		"\u0000{\u0017\u0001\u0000\u0000\u0000|}\u0005\u000b\u0000\u0000}~\u0005"+
		"\u0019\u0000\u0000~\u007f\u0005\u0019\u0000\u0000\u007f\u0080\u0005\u0019"+
		"\u0000\u0000\u0080\u0019\u0001\u0000\u0000\u0000\u0081\u0082\u0005\f\u0000"+
		"\u0000\u0082\u0083\u0005\u0019\u0000\u0000\u0083\u0084\u0005\u0019\u0000"+
		"\u0000\u0084\u0085\u0005\u0019\u0000\u0000\u0085\u001b\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005\r\u0000\u0000\u0087\u0088\u0005\u0019\u0000\u0000"+
		"\u0088\u0089\u0005\u0019\u0000\u0000\u0089\u008a\u0005\u0019\u0000\u0000"+
		"\u008a\u001d\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u000e\u0000\u0000"+
		"\u008c\u008d\u0005\u0019\u0000\u0000\u008d\u008e\u0005\u0019\u0000\u0000"+
		"\u008e\u008f\u0005\u0019\u0000\u0000\u008f\u001f\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0005\u000f\u0000\u0000\u0091\u0092\u0005\u0019\u0000\u0000"+
		"\u0092\u0093\u0005\u0019\u0000\u0000\u0093\u0094\u0005\u0019\u0000\u0000"+
		"\u0094!\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u0010\u0000\u0000\u0096"+
		"\u0097\u0005\u0019\u0000\u0000\u0097\u0098\u0005\u0019\u0000\u0000\u0098"+
		"\u0099\u0005\u0019\u0000\u0000\u0099#\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0005\u0011\u0000\u0000\u009b\u009c\u0005\u0019\u0000\u0000\u009c\u009d"+
		"\u0005\u0019\u0000\u0000\u009d\u009e\u0005\u0019\u0000\u0000\u009e%\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0005\u0012\u0000\u0000\u00a0\u00a1\u0005"+
		"\u0019\u0000\u0000\u00a1\u00a2\u0005\u0019\u0000\u0000\u00a2\u00a3\u0005"+
		"\u0019\u0000\u0000\u00a3\'\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\u0013"+
		"\u0000\u0000\u00a5\u00a6\u0005\u0019\u0000\u0000\u00a6\u00a7\u0005\u0019"+
		"\u0000\u0000\u00a7\u00a8\u0005\u0019\u0000\u0000\u00a8)\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0005\u0014\u0000\u0000\u00aa\u00ab\u0005\u0019\u0000"+
		"\u0000\u00ab\u00ac\u0005\u0019\u0000\u0000\u00ac+\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0005\u0015\u0000\u0000\u00ae\u00af\u0005\u0019\u0000\u0000"+
		"\u00af\u00b0\u0005\u0019\u0000\u0000\u00b0-\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0005\u0016\u0000\u0000\u00b2\u00b3\u0005\u0019\u0000\u0000\u00b3"+
		"/\u0001\u0000\u0000\u0000\u00b4\u00b8\u0005\u001b\u0000\u0000\u00b5\u00b7"+
		"\u0007\u0000\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7\u00ba"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9"+
		"\u0001\u0000\u0000\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b8"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u001c\u0000\u0000\u00bc1\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0005\u0017\u0000\u0000\u00be3\u0001\u0000"+
		"\u0000\u0000\u00037R\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}