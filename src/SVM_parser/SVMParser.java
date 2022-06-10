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
		NEG=21, PRINT=22, BEQ=23, HALT=24, JMP=25, SYMBOLS=26, LABEL=27, REG=28, 
		MEM=29, STRING=30, COL=31, NUMBER=32, WHITESP=33, LINECOMMENTS=34;
	public static final int
		RULE_assembly = 0, RULE_instruction = 1, RULE_push = 2, RULE_pop = 3, 
		RULE_top = 4, RULE_li = 5, RULE_mov = 6, RULE_lw = 7, RULE_sw = 8, RULE_add = 9, 
		RULE_sub = 10, RULE_mult = 11, RULE_div = 12, RULE_lt = 13, RULE_lte = 14, 
		RULE_gt = 15, RULE_gte = 16, RULE_eq = 17, RULE_neq = 18, RULE_and = 19, 
		RULE_or = 20, RULE_not = 21, RULE_neg = 22, RULE_print = 23, RULE_beq = 24, 
		RULE_label = 25, RULE_halt = 26, RULE_jmp = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"assembly", "instruction", "push", "pop", "top", "li", "mov", "lw", "sw", 
			"add", "sub", "mult", "div", "lt", "lte", "gt", "gte", "eq", "neq", "and", 
			"or", "not", "neg", "print", "beq", "label", "halt", "jmp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'push'", "'pop'", "'top'", "'li'", "'mov'", "'lw'", "'sw'", "'add'", 
			"'sub'", "'mult'", "'div'", "'lt'", "'lte'", "'gt'", "'gte'", "'eq'", 
			"'neq'", "'and'", "'or'", "'not'", "'neg'", "'print'", "'beq'", "'halt'", 
			"'jmp'", "'_'", null, null, null, null, "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUSH", "POP", "TOP", "LI", "MOV", "LW", "SW", "ADD", "SUB", "MULT", 
			"DIV", "LT", "LTE", "GT", "GTE", "EQ", "NEQ", "AND", "OR", "NOT", "NEG", 
			"PRINT", "BEQ", "HALT", "JMP", "SYMBOLS", "LABEL", "REG", "MEM", "STRING", 
			"COL", "NUMBER", "WHITESP", "LINECOMMENTS"
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUSH) | (1L << POP) | (1L << TOP) | (1L << LI) | (1L << MOV) | (1L << LW) | (1L << ADD) | (1L << SUB) | (1L << MULT) | (1L << DIV) | (1L << LT) | (1L << LTE) | (1L << GT) | (1L << GTE) | (1L << EQ) | (1L << NEQ) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << NEG) | (1L << PRINT) | (1L << BEQ) | (1L << HALT) | (1L << JMP) | (1L << LABEL))) != 0)) {
				{
				{
				setState(56);
				instruction();
				}
				}
				setState(61);
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
		public JmpContext jmp() {
			return getRuleContext(JmpContext.class,0);
		}
		public BeqContext beq() {
			return getRuleContext(BeqContext.class,0);
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
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				label();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				push();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				pop();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				top();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				li();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(67);
				mov();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(68);
				lw();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(69);
				sw();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(70);
				add();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(71);
				sub();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(72);
				mult();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(73);
				div();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(74);
				lt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(75);
				lte();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(76);
				gt();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(77);
				gte();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(78);
				eq();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(79);
				neq();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(80);
				and();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(81);
				or();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(82);
				not();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(83);
				neg();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(84);
				print();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(85);
				jmp();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(86);
				beq();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(87);
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
			setState(90);
			match(PUSH);
			setState(91);
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
			setState(93);
			match(POP);
			setState(94);
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
			setState(96);
			match(TOP);
			setState(97);
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
			setState(99);
			match(LI);
			setState(100);
			((LiContext)_localctx).dest = match(REG);
			setState(101);
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
			setState(103);
			match(MOV);
			setState(104);
			((MovContext)_localctx).dest = match(REG);
			setState(105);
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
			setState(107);
			match(LW);
			setState(108);
			((LwContext)_localctx).reg = match(REG);
			setState(109);
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
			setState(111);
			match(LW);
			setState(112);
			((SwContext)_localctx).reg = match(REG);
			setState(113);
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
			setState(115);
			match(ADD);
			setState(116);
			((AddContext)_localctx).dest = match(REG);
			setState(117);
			((AddContext)_localctx).reg1 = match(REG);
			setState(118);
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
			setState(120);
			match(SUB);
			setState(121);
			((SubContext)_localctx).dest = match(REG);
			setState(122);
			((SubContext)_localctx).reg1 = match(REG);
			setState(123);
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
			setState(125);
			match(MULT);
			setState(126);
			((MultContext)_localctx).dest = match(REG);
			setState(127);
			((MultContext)_localctx).reg1 = match(REG);
			setState(128);
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
			setState(130);
			match(DIV);
			setState(131);
			((DivContext)_localctx).dest = match(REG);
			setState(132);
			((DivContext)_localctx).reg1 = match(REG);
			setState(133);
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
			setState(135);
			match(LT);
			setState(136);
			((LtContext)_localctx).dest = match(REG);
			setState(137);
			((LtContext)_localctx).reg1 = match(REG);
			setState(138);
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
			setState(140);
			match(LTE);
			setState(141);
			((LteContext)_localctx).dest = match(REG);
			setState(142);
			((LteContext)_localctx).reg1 = match(REG);
			setState(143);
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
			setState(145);
			match(GT);
			setState(146);
			((GtContext)_localctx).dest = match(REG);
			setState(147);
			((GtContext)_localctx).reg1 = match(REG);
			setState(148);
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
			setState(150);
			match(GTE);
			setState(151);
			((GteContext)_localctx).dest = match(REG);
			setState(152);
			((GteContext)_localctx).reg1 = match(REG);
			setState(153);
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
			setState(155);
			match(EQ);
			setState(156);
			((EqContext)_localctx).dest = match(REG);
			setState(157);
			((EqContext)_localctx).reg1 = match(REG);
			setState(158);
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
			setState(160);
			match(NEQ);
			setState(161);
			((NeqContext)_localctx).dest = match(REG);
			setState(162);
			((NeqContext)_localctx).reg1 = match(REG);
			setState(163);
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
			setState(165);
			match(AND);
			setState(166);
			((AndContext)_localctx).dest = match(REG);
			setState(167);
			((AndContext)_localctx).reg1 = match(REG);
			setState(168);
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
			setState(170);
			match(OR);
			setState(171);
			((OrContext)_localctx).dest = match(REG);
			setState(172);
			((OrContext)_localctx).reg1 = match(REG);
			setState(173);
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
			setState(175);
			match(NOT);
			setState(176);
			((NotContext)_localctx).dest = match(REG);
			setState(177);
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
			setState(179);
			match(NEG);
			setState(180);
			((NegContext)_localctx).dest = match(REG);
			setState(181);
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
			setState(183);
			match(PRINT);
			setState(184);
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

	public static class BeqContext extends ParserRuleContext {
		public Token reg1;
		public Token reg2;
		public Token lab;
		public TerminalNode BEQ() { return getToken(SVMParser.BEQ, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public BeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterBeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitBeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitBeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeqContext beq() throws RecognitionException {
		BeqContext _localctx = new BeqContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_beq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(BEQ);
			setState(187);
			((BeqContext)_localctx).reg1 = match(REG);
			setState(188);
			((BeqContext)_localctx).reg2 = match(REG);
			setState(189);
			((BeqContext)_localctx).lab = match(LABEL);
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
		public Token lab;
		public TerminalNode COL() { return getToken(SVMParser.COL, 0); }
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
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
		enterRule(_localctx, 50, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			((LabelContext)_localctx).lab = match(LABEL);
			setState(192);
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
		enterRule(_localctx, 52, RULE_halt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
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

	public static class JmpContext extends ParserRuleContext {
		public Token lab;
		public TerminalNode JMP() { return getToken(SVMParser.JMP, 0); }
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public JmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterJmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitJmp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitJmp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JmpContext jmp() throws RecognitionException {
		JmpContext _localctx = new JmpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_jmp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(JMP);
			setState(197);
			((JmpContext)_localctx).lab = match(LABEL);
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
		"\u0004\u0001\"\u00c8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001Y\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0000\u0000\u001c\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.0246\u0000\u0000\u00c5\u0000;\u0001\u0000\u0000\u0000\u0002X"+
		"\u0001\u0000\u0000\u0000\u0004Z\u0001\u0000\u0000\u0000\u0006]\u0001\u0000"+
		"\u0000\u0000\b`\u0001\u0000\u0000\u0000\nc\u0001\u0000\u0000\u0000\fg"+
		"\u0001\u0000\u0000\u0000\u000ek\u0001\u0000\u0000\u0000\u0010o\u0001\u0000"+
		"\u0000\u0000\u0012s\u0001\u0000\u0000\u0000\u0014x\u0001\u0000\u0000\u0000"+
		"\u0016}\u0001\u0000\u0000\u0000\u0018\u0082\u0001\u0000\u0000\u0000\u001a"+
		"\u0087\u0001\u0000\u0000\u0000\u001c\u008c\u0001\u0000\u0000\u0000\u001e"+
		"\u0091\u0001\u0000\u0000\u0000 \u0096\u0001\u0000\u0000\u0000\"\u009b"+
		"\u0001\u0000\u0000\u0000$\u00a0\u0001\u0000\u0000\u0000&\u00a5\u0001\u0000"+
		"\u0000\u0000(\u00aa\u0001\u0000\u0000\u0000*\u00af\u0001\u0000\u0000\u0000"+
		",\u00b3\u0001\u0000\u0000\u0000.\u00b7\u0001\u0000\u0000\u00000\u00ba"+
		"\u0001\u0000\u0000\u00002\u00bf\u0001\u0000\u0000\u00004\u00c2\u0001\u0000"+
		"\u0000\u00006\u00c4\u0001\u0000\u0000\u00008:\u0003\u0002\u0001\u0000"+
		"98\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000;<\u0001\u0000\u0000\u0000<\u0001\u0001\u0000\u0000\u0000=;\u0001"+
		"\u0000\u0000\u0000>Y\u00032\u0019\u0000?Y\u0003\u0004\u0002\u0000@Y\u0003"+
		"\u0006\u0003\u0000AY\u0003\b\u0004\u0000BY\u0003\n\u0005\u0000CY\u0003"+
		"\f\u0006\u0000DY\u0003\u000e\u0007\u0000EY\u0003\u0010\b\u0000FY\u0003"+
		"\u0012\t\u0000GY\u0003\u0014\n\u0000HY\u0003\u0016\u000b\u0000IY\u0003"+
		"\u0018\f\u0000JY\u0003\u001a\r\u0000KY\u0003\u001c\u000e\u0000LY\u0003"+
		"\u001e\u000f\u0000MY\u0003 \u0010\u0000NY\u0003\"\u0011\u0000OY\u0003"+
		"$\u0012\u0000PY\u0003&\u0013\u0000QY\u0003(\u0014\u0000RY\u0003*\u0015"+
		"\u0000SY\u0003,\u0016\u0000TY\u0003.\u0017\u0000UY\u00036\u001b\u0000"+
		"VY\u00030\u0018\u0000WY\u00034\u001a\u0000X>\u0001\u0000\u0000\u0000X"+
		"?\u0001\u0000\u0000\u0000X@\u0001\u0000\u0000\u0000XA\u0001\u0000\u0000"+
		"\u0000XB\u0001\u0000\u0000\u0000XC\u0001\u0000\u0000\u0000XD\u0001\u0000"+
		"\u0000\u0000XE\u0001\u0000\u0000\u0000XF\u0001\u0000\u0000\u0000XG\u0001"+
		"\u0000\u0000\u0000XH\u0001\u0000\u0000\u0000XI\u0001\u0000\u0000\u0000"+
		"XJ\u0001\u0000\u0000\u0000XK\u0001\u0000\u0000\u0000XL\u0001\u0000\u0000"+
		"\u0000XM\u0001\u0000\u0000\u0000XN\u0001\u0000\u0000\u0000XO\u0001\u0000"+
		"\u0000\u0000XP\u0001\u0000\u0000\u0000XQ\u0001\u0000\u0000\u0000XR\u0001"+
		"\u0000\u0000\u0000XS\u0001\u0000\u0000\u0000XT\u0001\u0000\u0000\u0000"+
		"XU\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XW\u0001\u0000\u0000"+
		"\u0000Y\u0003\u0001\u0000\u0000\u0000Z[\u0005\u0001\u0000\u0000[\\\u0005"+
		"\u001c\u0000\u0000\\\u0005\u0001\u0000\u0000\u0000]^\u0005\u0002\u0000"+
		"\u0000^_\u0005\u001c\u0000\u0000_\u0007\u0001\u0000\u0000\u0000`a\u0005"+
		"\u0003\u0000\u0000ab\u0005\u001c\u0000\u0000b\t\u0001\u0000\u0000\u0000"+
		"cd\u0005\u0004\u0000\u0000de\u0005\u001c\u0000\u0000ef\u0005 \u0000\u0000"+
		"f\u000b\u0001\u0000\u0000\u0000gh\u0005\u0005\u0000\u0000hi\u0005\u001c"+
		"\u0000\u0000ij\u0005\u001c\u0000\u0000j\r\u0001\u0000\u0000\u0000kl\u0005"+
		"\u0006\u0000\u0000lm\u0005\u001c\u0000\u0000mn\u0005\u001d\u0000\u0000"+
		"n\u000f\u0001\u0000\u0000\u0000op\u0005\u0006\u0000\u0000pq\u0005\u001c"+
		"\u0000\u0000qr\u0005\u001d\u0000\u0000r\u0011\u0001\u0000\u0000\u0000"+
		"st\u0005\b\u0000\u0000tu\u0005\u001c\u0000\u0000uv\u0005\u001c\u0000\u0000"+
		"vw\u0005\u001c\u0000\u0000w\u0013\u0001\u0000\u0000\u0000xy\u0005\t\u0000"+
		"\u0000yz\u0005\u001c\u0000\u0000z{\u0005\u001c\u0000\u0000{|\u0005\u001c"+
		"\u0000\u0000|\u0015\u0001\u0000\u0000\u0000}~\u0005\n\u0000\u0000~\u007f"+
		"\u0005\u001c\u0000\u0000\u007f\u0080\u0005\u001c\u0000\u0000\u0080\u0081"+
		"\u0005\u001c\u0000\u0000\u0081\u0017\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005\u000b\u0000\u0000\u0083\u0084\u0005\u001c\u0000\u0000\u0084\u0085"+
		"\u0005\u001c\u0000\u0000\u0085\u0086\u0005\u001c\u0000\u0000\u0086\u0019"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0005\f\u0000\u0000\u0088\u0089\u0005"+
		"\u001c\u0000\u0000\u0089\u008a\u0005\u001c\u0000\u0000\u008a\u008b\u0005"+
		"\u001c\u0000\u0000\u008b\u001b\u0001\u0000\u0000\u0000\u008c\u008d\u0005"+
		"\r\u0000\u0000\u008d\u008e\u0005\u001c\u0000\u0000\u008e\u008f\u0005\u001c"+
		"\u0000\u0000\u008f\u0090\u0005\u001c\u0000\u0000\u0090\u001d\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0005\u000e\u0000\u0000\u0092\u0093\u0005\u001c"+
		"\u0000\u0000\u0093\u0094\u0005\u001c\u0000\u0000\u0094\u0095\u0005\u001c"+
		"\u0000\u0000\u0095\u001f\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u000f"+
		"\u0000\u0000\u0097\u0098\u0005\u001c\u0000\u0000\u0098\u0099\u0005\u001c"+
		"\u0000\u0000\u0099\u009a\u0005\u001c\u0000\u0000\u009a!\u0001\u0000\u0000"+
		"\u0000\u009b\u009c\u0005\u0010\u0000\u0000\u009c\u009d\u0005\u001c\u0000"+
		"\u0000\u009d\u009e\u0005\u001c\u0000\u0000\u009e\u009f\u0005\u001c\u0000"+
		"\u0000\u009f#\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0011\u0000\u0000"+
		"\u00a1\u00a2\u0005\u001c\u0000\u0000\u00a2\u00a3\u0005\u001c\u0000\u0000"+
		"\u00a3\u00a4\u0005\u001c\u0000\u0000\u00a4%\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005\u0012\u0000\u0000\u00a6\u00a7\u0005\u001c\u0000\u0000\u00a7"+
		"\u00a8\u0005\u001c\u0000\u0000\u00a8\u00a9\u0005\u001c\u0000\u0000\u00a9"+
		"\'\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\u0013\u0000\u0000\u00ab\u00ac"+
		"\u0005\u001c\u0000\u0000\u00ac\u00ad\u0005\u001c\u0000\u0000\u00ad\u00ae"+
		"\u0005\u001c\u0000\u0000\u00ae)\u0001\u0000\u0000\u0000\u00af\u00b0\u0005"+
		"\u0014\u0000\u0000\u00b0\u00b1\u0005\u001c\u0000\u0000\u00b1\u00b2\u0005"+
		"\u001c\u0000\u0000\u00b2+\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0015"+
		"\u0000\u0000\u00b4\u00b5\u0005\u001c\u0000\u0000\u00b5\u00b6\u0005\u001c"+
		"\u0000\u0000\u00b6-\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0016\u0000"+
		"\u0000\u00b8\u00b9\u0005\u001c\u0000\u0000\u00b9/\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0005\u0017\u0000\u0000\u00bb\u00bc\u0005\u001c\u0000\u0000"+
		"\u00bc\u00bd\u0005\u001c\u0000\u0000\u00bd\u00be\u0005\u001b\u0000\u0000"+
		"\u00be1\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u001b\u0000\u0000\u00c0"+
		"\u00c1\u0005\u001f\u0000\u0000\u00c13\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0005\u0018\u0000\u0000\u00c35\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005"+
		"\u0019\u0000\u0000\u00c5\u00c6\u0005\u001b\u0000\u0000\u00c67\u0001\u0000"+
		"\u0000\u0000\u0002;X";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}