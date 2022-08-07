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
		T__0=1, T__1=2, PUSHINT=3, POPINT=4, TOPINT=5, PUSHBOOL=6, POPBOOL=7, 
		TOPBOOL=8, LI=9, MOV=10, LW=11, SW=12, LB=13, SB=14, ADD=15, ADDI=16, 
		SUB=17, SUBI=18, MULT=19, MULTI=20, DIV=21, DIVI=22, MOD=23, MODI=24, 
		LT=25, LTE=26, GT=27, GTE=28, EQ=29, NEQ=30, AND=31, OR=32, NOT=33, NEG=34, 
		PRINTW=35, PRINTB=36, BEQ=37, HALT=38, JAL=39, JR=40, SYMBOLS=41, LABEL=42, 
		REG=43, STRING=44, COL=45, NUMBER=46, WHITESP=47, LINECOMMENTS=48;
	public static final int
		RULE_assembly = 0, RULE_instruction = 1, RULE_pushInt = 2, RULE_popInt = 3, 
		RULE_topInt = 4, RULE_pushBool = 5, RULE_popBool = 6, RULE_topBool = 7, 
		RULE_li = 8, RULE_mov = 9, RULE_lw = 10, RULE_sw = 11, RULE_lb = 12, RULE_sb = 13, 
		RULE_add = 14, RULE_addi = 15, RULE_sub = 16, RULE_subi = 17, RULE_mult = 18, 
		RULE_multi = 19, RULE_div = 20, RULE_divi = 21, RULE_mod = 22, RULE_modi = 23, 
		RULE_lt = 24, RULE_lte = 25, RULE_gt = 26, RULE_gte = 27, RULE_eq = 28, 
		RULE_neq = 29, RULE_and = 30, RULE_or = 31, RULE_not = 32, RULE_neg = 33, 
		RULE_printw = 34, RULE_printb = 35, RULE_beq = 36, RULE_label = 37, RULE_halt = 38, 
		RULE_jal = 39, RULE_jr = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"assembly", "instruction", "pushInt", "popInt", "topInt", "pushBool", 
			"popBool", "topBool", "li", "mov", "lw", "sw", "lb", "sb", "add", "addi", 
			"sub", "subi", "mult", "multi", "div", "divi", "mod", "modi", "lt", "lte", 
			"gt", "gte", "eq", "neq", "and", "or", "not", "neg", "printw", "printb", 
			"beq", "label", "halt", "jal", "jr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'pushw'", "'popw'", "'topw'", "'pushb'", "'popb'", 
			"'topb'", "'li'", "'mov'", "'lw'", "'sw'", "'lb'", "'sb'", "'add'", "'addi'", 
			"'sub'", "'subi'", "'mult'", "'multi'", "'div'", "'divi'", "'mod'", "'modi'", 
			"'lt'", "'lte'", "'gt'", "'gte'", "'eq'", "'neq'", "'and'", "'or'", "'not'", 
			"'neg'", "'printw'", "'printb'", "'beq'", "'halt'", "'jal'", "'jr'", 
			"'_'", null, null, null, "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "PUSHINT", "POPINT", "TOPINT", "PUSHBOOL", "POPBOOL", 
			"TOPBOOL", "LI", "MOV", "LW", "SW", "LB", "SB", "ADD", "ADDI", "SUB", 
			"SUBI", "MULT", "MULTI", "DIV", "DIVI", "MOD", "MODI", "LT", "LTE", "GT", 
			"GTE", "EQ", "NEQ", "AND", "OR", "NOT", "NEG", "PRINTW", "PRINTB", "BEQ", 
			"HALT", "JAL", "JR", "SYMBOLS", "LABEL", "REG", "STRING", "COL", "NUMBER", 
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
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUSHINT) | (1L << POPINT) | (1L << TOPINT) | (1L << PUSHBOOL) | (1L << POPBOOL) | (1L << TOPBOOL) | (1L << LI) | (1L << MOV) | (1L << LW) | (1L << SW) | (1L << LB) | (1L << SB) | (1L << ADD) | (1L << ADDI) | (1L << SUB) | (1L << SUBI) | (1L << MULT) | (1L << MULTI) | (1L << DIV) | (1L << DIVI) | (1L << MOD) | (1L << MODI) | (1L << LT) | (1L << LTE) | (1L << GT) | (1L << GTE) | (1L << EQ) | (1L << NEQ) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << NEG) | (1L << PRINTW) | (1L << PRINTB) | (1L << BEQ) | (1L << HALT) | (1L << JAL) | (1L << JR) | (1L << LABEL))) != 0)) {
				{
				{
				setState(82);
				instruction();
				}
				}
				setState(87);
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
		public PushIntContext pushInt() {
			return getRuleContext(PushIntContext.class,0);
		}
		public PopIntContext popInt() {
			return getRuleContext(PopIntContext.class,0);
		}
		public TopIntContext topInt() {
			return getRuleContext(TopIntContext.class,0);
		}
		public PushBoolContext pushBool() {
			return getRuleContext(PushBoolContext.class,0);
		}
		public PopBoolContext popBool() {
			return getRuleContext(PopBoolContext.class,0);
		}
		public TopBoolContext topBool() {
			return getRuleContext(TopBoolContext.class,0);
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
		public LbContext lb() {
			return getRuleContext(LbContext.class,0);
		}
		public SbContext sb() {
			return getRuleContext(SbContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public AddiContext addi() {
			return getRuleContext(AddiContext.class,0);
		}
		public SubContext sub() {
			return getRuleContext(SubContext.class,0);
		}
		public SubiContext subi() {
			return getRuleContext(SubiContext.class,0);
		}
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public MultiContext multi() {
			return getRuleContext(MultiContext.class,0);
		}
		public DivContext div() {
			return getRuleContext(DivContext.class,0);
		}
		public DiviContext divi() {
			return getRuleContext(DiviContext.class,0);
		}
		public ModContext mod() {
			return getRuleContext(ModContext.class,0);
		}
		public ModiContext modi() {
			return getRuleContext(ModiContext.class,0);
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
		public PrintwContext printw() {
			return getRuleContext(PrintwContext.class,0);
		}
		public PrintbContext printb() {
			return getRuleContext(PrintbContext.class,0);
		}
		public JalContext jal() {
			return getRuleContext(JalContext.class,0);
		}
		public JrContext jr() {
			return getRuleContext(JrContext.class,0);
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
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				label();
				}
				break;
			case PUSHINT:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				pushInt();
				}
				break;
			case POPINT:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				popInt();
				}
				break;
			case TOPINT:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				topInt();
				}
				break;
			case PUSHBOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
				pushBool();
				}
				break;
			case POPBOOL:
				enterOuterAlt(_localctx, 6);
				{
				setState(93);
				popBool();
				}
				break;
			case TOPBOOL:
				enterOuterAlt(_localctx, 7);
				{
				setState(94);
				topBool();
				}
				break;
			case LI:
				enterOuterAlt(_localctx, 8);
				{
				setState(95);
				li();
				}
				break;
			case MOV:
				enterOuterAlt(_localctx, 9);
				{
				setState(96);
				mov();
				}
				break;
			case LW:
				enterOuterAlt(_localctx, 10);
				{
				setState(97);
				lw();
				}
				break;
			case SW:
				enterOuterAlt(_localctx, 11);
				{
				setState(98);
				sw();
				}
				break;
			case LB:
				enterOuterAlt(_localctx, 12);
				{
				setState(99);
				lb();
				}
				break;
			case SB:
				enterOuterAlt(_localctx, 13);
				{
				setState(100);
				sb();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 14);
				{
				setState(101);
				add();
				}
				break;
			case ADDI:
				enterOuterAlt(_localctx, 15);
				{
				setState(102);
				addi();
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 16);
				{
				setState(103);
				sub();
				}
				break;
			case SUBI:
				enterOuterAlt(_localctx, 17);
				{
				setState(104);
				subi();
				}
				break;
			case MULT:
				enterOuterAlt(_localctx, 18);
				{
				setState(105);
				mult();
				}
				break;
			case MULTI:
				enterOuterAlt(_localctx, 19);
				{
				setState(106);
				multi();
				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 20);
				{
				setState(107);
				div();
				}
				break;
			case DIVI:
				enterOuterAlt(_localctx, 21);
				{
				setState(108);
				divi();
				}
				break;
			case MOD:
				enterOuterAlt(_localctx, 22);
				{
				setState(109);
				mod();
				}
				break;
			case MODI:
				enterOuterAlt(_localctx, 23);
				{
				setState(110);
				modi();
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 24);
				{
				setState(111);
				lt();
				}
				break;
			case LTE:
				enterOuterAlt(_localctx, 25);
				{
				setState(112);
				lte();
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 26);
				{
				setState(113);
				gt();
				}
				break;
			case GTE:
				enterOuterAlt(_localctx, 27);
				{
				setState(114);
				gte();
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 28);
				{
				setState(115);
				eq();
				}
				break;
			case NEQ:
				enterOuterAlt(_localctx, 29);
				{
				setState(116);
				neq();
				}
				break;
			case AND:
				enterOuterAlt(_localctx, 30);
				{
				setState(117);
				and();
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 31);
				{
				setState(118);
				or();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 32);
				{
				setState(119);
				not();
				}
				break;
			case NEG:
				enterOuterAlt(_localctx, 33);
				{
				setState(120);
				neg();
				}
				break;
			case PRINTW:
				enterOuterAlt(_localctx, 34);
				{
				setState(121);
				printw();
				}
				break;
			case PRINTB:
				enterOuterAlt(_localctx, 35);
				{
				setState(122);
				printb();
				}
				break;
			case JAL:
				enterOuterAlt(_localctx, 36);
				{
				setState(123);
				jal();
				}
				break;
			case JR:
				enterOuterAlt(_localctx, 37);
				{
				setState(124);
				jr();
				}
				break;
			case BEQ:
				enterOuterAlt(_localctx, 38);
				{
				setState(125);
				beq();
				}
				break;
			case HALT:
				enterOuterAlt(_localctx, 39);
				{
				setState(126);
				halt();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PushIntContext extends ParserRuleContext {
		public Token src;
		public TerminalNode PUSHINT() { return getToken(SVMParser.PUSHINT, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public PushIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pushInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterPushInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitPushInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPushInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PushIntContext pushInt() throws RecognitionException {
		PushIntContext _localctx = new PushIntContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pushInt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(PUSHINT);
			setState(130);
			((PushIntContext)_localctx).src = match(REG);
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

	public static class PopIntContext extends ParserRuleContext {
		public Token dest;
		public TerminalNode POPINT() { return getToken(SVMParser.POPINT, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public PopIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_popInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterPopInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitPopInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPopInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PopIntContext popInt() throws RecognitionException {
		PopIntContext _localctx = new PopIntContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_popInt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(POPINT);
			setState(133);
			((PopIntContext)_localctx).dest = match(REG);
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

	public static class TopIntContext extends ParserRuleContext {
		public Token dest;
		public TerminalNode TOPINT() { return getToken(SVMParser.TOPINT, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public TopIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterTopInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitTopInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitTopInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopIntContext topInt() throws RecognitionException {
		TopIntContext _localctx = new TopIntContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_topInt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(TOPINT);
			setState(136);
			((TopIntContext)_localctx).dest = match(REG);
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

	public static class PushBoolContext extends ParserRuleContext {
		public Token src;
		public TerminalNode PUSHBOOL() { return getToken(SVMParser.PUSHBOOL, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public PushBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pushBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterPushBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitPushBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPushBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PushBoolContext pushBool() throws RecognitionException {
		PushBoolContext _localctx = new PushBoolContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pushBool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(PUSHBOOL);
			setState(139);
			((PushBoolContext)_localctx).src = match(REG);
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

	public static class PopBoolContext extends ParserRuleContext {
		public Token dest;
		public TerminalNode POPBOOL() { return getToken(SVMParser.POPBOOL, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public PopBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_popBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterPopBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitPopBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPopBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PopBoolContext popBool() throws RecognitionException {
		PopBoolContext _localctx = new PopBoolContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_popBool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(POPBOOL);
			setState(142);
			((PopBoolContext)_localctx).dest = match(REG);
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

	public static class TopBoolContext extends ParserRuleContext {
		public Token dest;
		public TerminalNode TOPBOOL() { return getToken(SVMParser.TOPBOOL, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public TopBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterTopBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitTopBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitTopBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopBoolContext topBool() throws RecognitionException {
		TopBoolContext _localctx = new TopBoolContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_topBool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(TOPBOOL);
			setState(145);
			((TopBoolContext)_localctx).dest = match(REG);
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
		enterRule(_localctx, 16, RULE_li);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(LI);
			setState(148);
			((LiContext)_localctx).dest = match(REG);
			setState(149);
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
		enterRule(_localctx, 18, RULE_mov);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(MOV);
			setState(152);
			((MovContext)_localctx).dest = match(REG);
			setState(153);
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
		public Token reg1;
		public Token offset;
		public Token reg2;
		public TerminalNode LW() { return getToken(SVMParser.LW, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
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
		enterRule(_localctx, 20, RULE_lw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(LW);
			setState(156);
			((LwContext)_localctx).reg1 = match(REG);
			setState(157);
			((LwContext)_localctx).offset = match(NUMBER);
			setState(158);
			match(T__0);
			setState(159);
			((LwContext)_localctx).reg2 = match(REG);
			setState(160);
			match(T__1);
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
		public Token reg1;
		public Token offset;
		public Token reg2;
		public TerminalNode SW() { return getToken(SVMParser.SW, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
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
		enterRule(_localctx, 22, RULE_sw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(SW);
			setState(163);
			((SwContext)_localctx).reg1 = match(REG);
			setState(164);
			((SwContext)_localctx).offset = match(NUMBER);
			setState(165);
			match(T__0);
			setState(166);
			((SwContext)_localctx).reg2 = match(REG);
			setState(167);
			match(T__1);
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

	public static class LbContext extends ParserRuleContext {
		public Token reg1;
		public Token offset;
		public Token reg2;
		public TerminalNode LB() { return getToken(SVMParser.LB, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public LbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterLb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitLb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LbContext lb() throws RecognitionException {
		LbContext _localctx = new LbContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(LB);
			setState(170);
			((LbContext)_localctx).reg1 = match(REG);
			setState(171);
			((LbContext)_localctx).offset = match(NUMBER);
			setState(172);
			match(T__0);
			setState(173);
			((LbContext)_localctx).reg2 = match(REG);
			setState(174);
			match(T__1);
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

	public static class SbContext extends ParserRuleContext {
		public Token reg1;
		public Token offset;
		public Token reg2;
		public TerminalNode SB() { return getToken(SVMParser.SB, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public SbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterSb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitSb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitSb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SbContext sb() throws RecognitionException {
		SbContext _localctx = new SbContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(SB);
			setState(177);
			((SbContext)_localctx).reg1 = match(REG);
			setState(178);
			((SbContext)_localctx).offset = match(NUMBER);
			setState(179);
			match(T__0);
			setState(180);
			((SbContext)_localctx).reg2 = match(REG);
			setState(181);
			match(T__1);
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
		enterRule(_localctx, 28, RULE_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(ADD);
			setState(184);
			((AddContext)_localctx).dest = match(REG);
			setState(185);
			((AddContext)_localctx).reg1 = match(REG);
			setState(186);
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

	public static class AddiContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token val;
		public TerminalNode ADDI() { return getToken(SVMParser.ADDI, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public AddiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterAddi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitAddi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAddi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddiContext addi() throws RecognitionException {
		AddiContext _localctx = new AddiContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_addi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(ADDI);
			setState(189);
			((AddiContext)_localctx).dest = match(REG);
			setState(190);
			((AddiContext)_localctx).reg1 = match(REG);
			setState(191);
			((AddiContext)_localctx).val = match(NUMBER);
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
		enterRule(_localctx, 32, RULE_sub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(SUB);
			setState(194);
			((SubContext)_localctx).dest = match(REG);
			setState(195);
			((SubContext)_localctx).reg1 = match(REG);
			setState(196);
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

	public static class SubiContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token val;
		public TerminalNode SUBI() { return getToken(SVMParser.SUBI, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public SubiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterSubi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitSubi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitSubi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubiContext subi() throws RecognitionException {
		SubiContext _localctx = new SubiContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_subi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(SUBI);
			setState(199);
			((SubiContext)_localctx).dest = match(REG);
			setState(200);
			((SubiContext)_localctx).reg1 = match(REG);
			setState(201);
			((SubiContext)_localctx).val = match(NUMBER);
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
		enterRule(_localctx, 36, RULE_mult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(MULT);
			setState(204);
			((MultContext)_localctx).dest = match(REG);
			setState(205);
			((MultContext)_localctx).reg1 = match(REG);
			setState(206);
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

	public static class MultiContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token val;
		public TerminalNode MULTI() { return getToken(SVMParser.MULTI, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public MultiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterMulti(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitMulti(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitMulti(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiContext multi() throws RecognitionException {
		MultiContext _localctx = new MultiContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_multi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(MULTI);
			setState(209);
			((MultiContext)_localctx).dest = match(REG);
			setState(210);
			((MultiContext)_localctx).reg1 = match(REG);
			setState(211);
			((MultiContext)_localctx).val = match(NUMBER);
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
		enterRule(_localctx, 40, RULE_div);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(DIV);
			setState(214);
			((DivContext)_localctx).dest = match(REG);
			setState(215);
			((DivContext)_localctx).reg1 = match(REG);
			setState(216);
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

	public static class DiviContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token val;
		public TerminalNode DIVI() { return getToken(SVMParser.DIVI, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public DiviContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterDivi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitDivi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitDivi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DiviContext divi() throws RecognitionException {
		DiviContext _localctx = new DiviContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_divi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(DIVI);
			setState(219);
			((DiviContext)_localctx).dest = match(REG);
			setState(220);
			((DiviContext)_localctx).reg1 = match(REG);
			setState(221);
			((DiviContext)_localctx).val = match(NUMBER);
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

	public static class ModContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token reg2;
		public TerminalNode MOD() { return getToken(SVMParser.MOD, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public ModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitMod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModContext mod() throws RecognitionException {
		ModContext _localctx = new ModContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(MOD);
			setState(224);
			((ModContext)_localctx).dest = match(REG);
			setState(225);
			((ModContext)_localctx).reg1 = match(REG);
			setState(226);
			((ModContext)_localctx).reg2 = match(REG);
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

	public static class ModiContext extends ParserRuleContext {
		public Token dest;
		public Token reg1;
		public Token val;
		public TerminalNode MODI() { return getToken(SVMParser.MODI, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public ModiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterModi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitModi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitModi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModiContext modi() throws RecognitionException {
		ModiContext _localctx = new ModiContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_modi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(MODI);
			setState(229);
			((ModiContext)_localctx).dest = match(REG);
			setState(230);
			((ModiContext)_localctx).reg1 = match(REG);
			setState(231);
			((ModiContext)_localctx).val = match(NUMBER);
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
		enterRule(_localctx, 48, RULE_lt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(LT);
			setState(234);
			((LtContext)_localctx).dest = match(REG);
			setState(235);
			((LtContext)_localctx).reg1 = match(REG);
			setState(236);
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
		enterRule(_localctx, 50, RULE_lte);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(LTE);
			setState(239);
			((LteContext)_localctx).dest = match(REG);
			setState(240);
			((LteContext)_localctx).reg1 = match(REG);
			setState(241);
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
		enterRule(_localctx, 52, RULE_gt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(GT);
			setState(244);
			((GtContext)_localctx).dest = match(REG);
			setState(245);
			((GtContext)_localctx).reg1 = match(REG);
			setState(246);
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
		enterRule(_localctx, 54, RULE_gte);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(GTE);
			setState(249);
			((GteContext)_localctx).dest = match(REG);
			setState(250);
			((GteContext)_localctx).reg1 = match(REG);
			setState(251);
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
		enterRule(_localctx, 56, RULE_eq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(EQ);
			setState(254);
			((EqContext)_localctx).dest = match(REG);
			setState(255);
			((EqContext)_localctx).reg1 = match(REG);
			setState(256);
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
		enterRule(_localctx, 58, RULE_neq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(NEQ);
			setState(259);
			((NeqContext)_localctx).dest = match(REG);
			setState(260);
			((NeqContext)_localctx).reg1 = match(REG);
			setState(261);
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
		enterRule(_localctx, 60, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(AND);
			setState(264);
			((AndContext)_localctx).dest = match(REG);
			setState(265);
			((AndContext)_localctx).reg1 = match(REG);
			setState(266);
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
		enterRule(_localctx, 62, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(OR);
			setState(269);
			((OrContext)_localctx).dest = match(REG);
			setState(270);
			((OrContext)_localctx).reg1 = match(REG);
			setState(271);
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
		enterRule(_localctx, 64, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(NOT);
			setState(274);
			((NotContext)_localctx).dest = match(REG);
			setState(275);
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
		enterRule(_localctx, 66, RULE_neg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(NEG);
			setState(278);
			((NegContext)_localctx).dest = match(REG);
			setState(279);
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

	public static class PrintwContext extends ParserRuleContext {
		public Token src;
		public TerminalNode PRINTW() { return getToken(SVMParser.PRINTW, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public PrintwContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterPrintw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitPrintw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPrintw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintwContext printw() throws RecognitionException {
		PrintwContext _localctx = new PrintwContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_printw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(PRINTW);
			setState(282);
			((PrintwContext)_localctx).src = match(REG);
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

	public static class PrintbContext extends ParserRuleContext {
		public Token src;
		public TerminalNode PRINTB() { return getToken(SVMParser.PRINTB, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public PrintbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterPrintb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitPrintb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPrintb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintbContext printb() throws RecognitionException {
		PrintbContext _localctx = new PrintbContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_printb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(PRINTB);
			setState(285);
			((PrintbContext)_localctx).src = match(REG);
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
		enterRule(_localctx, 72, RULE_beq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(BEQ);
			setState(288);
			((BeqContext)_localctx).reg1 = match(REG);
			setState(289);
			((BeqContext)_localctx).reg2 = match(REG);
			setState(290);
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
		enterRule(_localctx, 74, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			((LabelContext)_localctx).lab = match(LABEL);
			setState(293);
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
		enterRule(_localctx, 76, RULE_halt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
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

	public static class JalContext extends ParserRuleContext {
		public Token lab;
		public TerminalNode JAL() { return getToken(SVMParser.JAL, 0); }
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public JalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterJal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitJal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitJal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JalContext jal() throws RecognitionException {
		JalContext _localctx = new JalContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_jal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(JAL);
			setState(298);
			((JalContext)_localctx).lab = match(LABEL);
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

	public static class JrContext extends ParserRuleContext {
		public Token dest;
		public TerminalNode JR() { return getToken(SVMParser.JR, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public JrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterJr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitJr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitJr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JrContext jr() throws RecognitionException {
		JrContext _localctx = new JrContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_jr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(JR);
			setState(301);
			((JrContext)_localctx).dest = match(REG);
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
		"\u0004\u00010\u0130\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0001\u0000\u0005\u0000T\b\u0000\n\u0000\f\u0000W\t\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0080\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001(\u0001(\u0000\u0000)\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNP\u0000\u0000\u012d\u0000U\u0001\u0000\u0000\u0000\u0002\u007f\u0001"+
		"\u0000\u0000\u0000\u0004\u0081\u0001\u0000\u0000\u0000\u0006\u0084\u0001"+
		"\u0000\u0000\u0000\b\u0087\u0001\u0000\u0000\u0000\n\u008a\u0001\u0000"+
		"\u0000\u0000\f\u008d\u0001\u0000\u0000\u0000\u000e\u0090\u0001\u0000\u0000"+
		"\u0000\u0010\u0093\u0001\u0000\u0000\u0000\u0012\u0097\u0001\u0000\u0000"+
		"\u0000\u0014\u009b\u0001\u0000\u0000\u0000\u0016\u00a2\u0001\u0000\u0000"+
		"\u0000\u0018\u00a9\u0001\u0000\u0000\u0000\u001a\u00b0\u0001\u0000\u0000"+
		"\u0000\u001c\u00b7\u0001\u0000\u0000\u0000\u001e\u00bc\u0001\u0000\u0000"+
		"\u0000 \u00c1\u0001\u0000\u0000\u0000\"\u00c6\u0001\u0000\u0000\u0000"+
		"$\u00cb\u0001\u0000\u0000\u0000&\u00d0\u0001\u0000\u0000\u0000(\u00d5"+
		"\u0001\u0000\u0000\u0000*\u00da\u0001\u0000\u0000\u0000,\u00df\u0001\u0000"+
		"\u0000\u0000.\u00e4\u0001\u0000\u0000\u00000\u00e9\u0001\u0000\u0000\u0000"+
		"2\u00ee\u0001\u0000\u0000\u00004\u00f3\u0001\u0000\u0000\u00006\u00f8"+
		"\u0001\u0000\u0000\u00008\u00fd\u0001\u0000\u0000\u0000:\u0102\u0001\u0000"+
		"\u0000\u0000<\u0107\u0001\u0000\u0000\u0000>\u010c\u0001\u0000\u0000\u0000"+
		"@\u0111\u0001\u0000\u0000\u0000B\u0115\u0001\u0000\u0000\u0000D\u0119"+
		"\u0001\u0000\u0000\u0000F\u011c\u0001\u0000\u0000\u0000H\u011f\u0001\u0000"+
		"\u0000\u0000J\u0124\u0001\u0000\u0000\u0000L\u0127\u0001\u0000\u0000\u0000"+
		"N\u0129\u0001\u0000\u0000\u0000P\u012c\u0001\u0000\u0000\u0000RT\u0003"+
		"\u0002\u0001\u0000SR\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000"+
		"US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000V\u0001\u0001\u0000"+
		"\u0000\u0000WU\u0001\u0000\u0000\u0000X\u0080\u0003J%\u0000Y\u0080\u0003"+
		"\u0004\u0002\u0000Z\u0080\u0003\u0006\u0003\u0000[\u0080\u0003\b\u0004"+
		"\u0000\\\u0080\u0003\n\u0005\u0000]\u0080\u0003\f\u0006\u0000^\u0080\u0003"+
		"\u000e\u0007\u0000_\u0080\u0003\u0010\b\u0000`\u0080\u0003\u0012\t\u0000"+
		"a\u0080\u0003\u0014\n\u0000b\u0080\u0003\u0016\u000b\u0000c\u0080\u0003"+
		"\u0018\f\u0000d\u0080\u0003\u001a\r\u0000e\u0080\u0003\u001c\u000e\u0000"+
		"f\u0080\u0003\u001e\u000f\u0000g\u0080\u0003 \u0010\u0000h\u0080\u0003"+
		"\"\u0011\u0000i\u0080\u0003$\u0012\u0000j\u0080\u0003&\u0013\u0000k\u0080"+
		"\u0003(\u0014\u0000l\u0080\u0003*\u0015\u0000m\u0080\u0003,\u0016\u0000"+
		"n\u0080\u0003.\u0017\u0000o\u0080\u00030\u0018\u0000p\u0080\u00032\u0019"+
		"\u0000q\u0080\u00034\u001a\u0000r\u0080\u00036\u001b\u0000s\u0080\u0003"+
		"8\u001c\u0000t\u0080\u0003:\u001d\u0000u\u0080\u0003<\u001e\u0000v\u0080"+
		"\u0003>\u001f\u0000w\u0080\u0003@ \u0000x\u0080\u0003B!\u0000y\u0080\u0003"+
		"D\"\u0000z\u0080\u0003F#\u0000{\u0080\u0003N\'\u0000|\u0080\u0003P(\u0000"+
		"}\u0080\u0003H$\u0000~\u0080\u0003L&\u0000\u007fX\u0001\u0000\u0000\u0000"+
		"\u007fY\u0001\u0000\u0000\u0000\u007fZ\u0001\u0000\u0000\u0000\u007f["+
		"\u0001\u0000\u0000\u0000\u007f\\\u0001\u0000\u0000\u0000\u007f]\u0001"+
		"\u0000\u0000\u0000\u007f^\u0001\u0000\u0000\u0000\u007f_\u0001\u0000\u0000"+
		"\u0000\u007f`\u0001\u0000\u0000\u0000\u007fa\u0001\u0000\u0000\u0000\u007f"+
		"b\u0001\u0000\u0000\u0000\u007fc\u0001\u0000\u0000\u0000\u007fd\u0001"+
		"\u0000\u0000\u0000\u007fe\u0001\u0000\u0000\u0000\u007ff\u0001\u0000\u0000"+
		"\u0000\u007fg\u0001\u0000\u0000\u0000\u007fh\u0001\u0000\u0000\u0000\u007f"+
		"i\u0001\u0000\u0000\u0000\u007fj\u0001\u0000\u0000\u0000\u007fk\u0001"+
		"\u0000\u0000\u0000\u007fl\u0001\u0000\u0000\u0000\u007fm\u0001\u0000\u0000"+
		"\u0000\u007fn\u0001\u0000\u0000\u0000\u007fo\u0001\u0000\u0000\u0000\u007f"+
		"p\u0001\u0000\u0000\u0000\u007fq\u0001\u0000\u0000\u0000\u007fr\u0001"+
		"\u0000\u0000\u0000\u007fs\u0001\u0000\u0000\u0000\u007ft\u0001\u0000\u0000"+
		"\u0000\u007fu\u0001\u0000\u0000\u0000\u007fv\u0001\u0000\u0000\u0000\u007f"+
		"w\u0001\u0000\u0000\u0000\u007fx\u0001\u0000\u0000\u0000\u007fy\u0001"+
		"\u0000\u0000\u0000\u007fz\u0001\u0000\u0000\u0000\u007f{\u0001\u0000\u0000"+
		"\u0000\u007f|\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f"+
		"~\u0001\u0000\u0000\u0000\u0080\u0003\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0005\u0003\u0000\u0000\u0082\u0083\u0005+\u0000\u0000\u0083\u0005\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005\u0004\u0000\u0000\u0085\u0086\u0005"+
		"+\u0000\u0000\u0086\u0007\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0005"+
		"\u0000\u0000\u0088\u0089\u0005+\u0000\u0000\u0089\t\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0005\u0006\u0000\u0000\u008b\u008c\u0005+\u0000\u0000"+
		"\u008c\u000b\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0007\u0000\u0000"+
		"\u008e\u008f\u0005+\u0000\u0000\u008f\r\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0005\b\u0000\u0000\u0091\u0092\u0005+\u0000\u0000\u0092\u000f"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0005\t\u0000\u0000\u0094\u0095\u0005"+
		"+\u0000\u0000\u0095\u0096\u0005.\u0000\u0000\u0096\u0011\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0005\n\u0000\u0000\u0098\u0099\u0005+\u0000\u0000"+
		"\u0099\u009a\u0005+\u0000\u0000\u009a\u0013\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0005\u000b\u0000\u0000\u009c\u009d\u0005+\u0000\u0000\u009d\u009e"+
		"\u0005.\u0000\u0000\u009e\u009f\u0005\u0001\u0000\u0000\u009f\u00a0\u0005"+
		"+\u0000\u0000\u00a0\u00a1\u0005\u0002\u0000\u0000\u00a1\u0015\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005\f\u0000\u0000\u00a3\u00a4\u0005+\u0000"+
		"\u0000\u00a4\u00a5\u0005.\u0000\u0000\u00a5\u00a6\u0005\u0001\u0000\u0000"+
		"\u00a6\u00a7\u0005+\u0000\u0000\u00a7\u00a8\u0005\u0002\u0000\u0000\u00a8"+
		"\u0017\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\r\u0000\u0000\u00aa\u00ab"+
		"\u0005+\u0000\u0000\u00ab\u00ac\u0005.\u0000\u0000\u00ac\u00ad\u0005\u0001"+
		"\u0000\u0000\u00ad\u00ae\u0005+\u0000\u0000\u00ae\u00af\u0005\u0002\u0000"+
		"\u0000\u00af\u0019\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u000e\u0000"+
		"\u0000\u00b1\u00b2\u0005+\u0000\u0000\u00b2\u00b3\u0005.\u0000\u0000\u00b3"+
		"\u00b4\u0005\u0001\u0000\u0000\u00b4\u00b5\u0005+\u0000\u0000\u00b5\u00b6"+
		"\u0005\u0002\u0000\u0000\u00b6\u001b\u0001\u0000\u0000\u0000\u00b7\u00b8"+
		"\u0005\u000f\u0000\u0000\u00b8\u00b9\u0005+\u0000\u0000\u00b9\u00ba\u0005"+
		"+\u0000\u0000\u00ba\u00bb\u0005+\u0000\u0000\u00bb\u001d\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0005\u0010\u0000\u0000\u00bd\u00be\u0005+\u0000\u0000"+
		"\u00be\u00bf\u0005+\u0000\u0000\u00bf\u00c0\u0005.\u0000\u0000\u00c0\u001f"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005\u0011\u0000\u0000\u00c2\u00c3"+
		"\u0005+\u0000\u0000\u00c3\u00c4\u0005+\u0000\u0000\u00c4\u00c5\u0005+"+
		"\u0000\u0000\u00c5!\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\u0012\u0000"+
		"\u0000\u00c7\u00c8\u0005+\u0000\u0000\u00c8\u00c9\u0005+\u0000\u0000\u00c9"+
		"\u00ca\u0005.\u0000\u0000\u00ca#\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005"+
		"\u0013\u0000\u0000\u00cc\u00cd\u0005+\u0000\u0000\u00cd\u00ce\u0005+\u0000"+
		"\u0000\u00ce\u00cf\u0005+\u0000\u0000\u00cf%\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0005\u0014\u0000\u0000\u00d1\u00d2\u0005+\u0000\u0000\u00d2\u00d3"+
		"\u0005+\u0000\u0000\u00d3\u00d4\u0005.\u0000\u0000\u00d4\'\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d6\u0005\u0015\u0000\u0000\u00d6\u00d7\u0005+\u0000"+
		"\u0000\u00d7\u00d8\u0005+\u0000\u0000\u00d8\u00d9\u0005+\u0000\u0000\u00d9"+
		")\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0016\u0000\u0000\u00db\u00dc"+
		"\u0005+\u0000\u0000\u00dc\u00dd\u0005+\u0000\u0000\u00dd\u00de\u0005."+
		"\u0000\u0000\u00de+\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u0017\u0000"+
		"\u0000\u00e0\u00e1\u0005+\u0000\u0000\u00e1\u00e2\u0005+\u0000\u0000\u00e2"+
		"\u00e3\u0005+\u0000\u0000\u00e3-\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005"+
		"\u0018\u0000\u0000\u00e5\u00e6\u0005+\u0000\u0000\u00e6\u00e7\u0005+\u0000"+
		"\u0000\u00e7\u00e8\u0005.\u0000\u0000\u00e8/\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0005\u0019\u0000\u0000\u00ea\u00eb\u0005+\u0000\u0000\u00eb\u00ec"+
		"\u0005+\u0000\u0000\u00ec\u00ed\u0005+\u0000\u0000\u00ed1\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ef\u0005\u001a\u0000\u0000\u00ef\u00f0\u0005+\u0000"+
		"\u0000\u00f0\u00f1\u0005+\u0000\u0000\u00f1\u00f2\u0005+\u0000\u0000\u00f2"+
		"3\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005\u001b\u0000\u0000\u00f4\u00f5"+
		"\u0005+\u0000\u0000\u00f5\u00f6\u0005+\u0000\u0000\u00f6\u00f7\u0005+"+
		"\u0000\u0000\u00f75\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005\u001c\u0000"+
		"\u0000\u00f9\u00fa\u0005+\u0000\u0000\u00fa\u00fb\u0005+\u0000\u0000\u00fb"+
		"\u00fc\u0005+\u0000\u0000\u00fc7\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005"+
		"\u001d\u0000\u0000\u00fe\u00ff\u0005+\u0000\u0000\u00ff\u0100\u0005+\u0000"+
		"\u0000\u0100\u0101\u0005+\u0000\u0000\u01019\u0001\u0000\u0000\u0000\u0102"+
		"\u0103\u0005\u001e\u0000\u0000\u0103\u0104\u0005+\u0000\u0000\u0104\u0105"+
		"\u0005+\u0000\u0000\u0105\u0106\u0005+\u0000\u0000\u0106;\u0001\u0000"+
		"\u0000\u0000\u0107\u0108\u0005\u001f\u0000\u0000\u0108\u0109\u0005+\u0000"+
		"\u0000\u0109\u010a\u0005+\u0000\u0000\u010a\u010b\u0005+\u0000\u0000\u010b"+
		"=\u0001\u0000\u0000\u0000\u010c\u010d\u0005 \u0000\u0000\u010d\u010e\u0005"+
		"+\u0000\u0000\u010e\u010f\u0005+\u0000\u0000\u010f\u0110\u0005+\u0000"+
		"\u0000\u0110?\u0001\u0000\u0000\u0000\u0111\u0112\u0005!\u0000\u0000\u0112"+
		"\u0113\u0005+\u0000\u0000\u0113\u0114\u0005+\u0000\u0000\u0114A\u0001"+
		"\u0000\u0000\u0000\u0115\u0116\u0005\"\u0000\u0000\u0116\u0117\u0005+"+
		"\u0000\u0000\u0117\u0118\u0005+\u0000\u0000\u0118C\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0005#\u0000\u0000\u011a\u011b\u0005+\u0000\u0000\u011bE"+
		"\u0001\u0000\u0000\u0000\u011c\u011d\u0005$\u0000\u0000\u011d\u011e\u0005"+
		"+\u0000\u0000\u011eG\u0001\u0000\u0000\u0000\u011f\u0120\u0005%\u0000"+
		"\u0000\u0120\u0121\u0005+\u0000\u0000\u0121\u0122\u0005+\u0000\u0000\u0122"+
		"\u0123\u0005*\u0000\u0000\u0123I\u0001\u0000\u0000\u0000\u0124\u0125\u0005"+
		"*\u0000\u0000\u0125\u0126\u0005-\u0000\u0000\u0126K\u0001\u0000\u0000"+
		"\u0000\u0127\u0128\u0005&\u0000\u0000\u0128M\u0001\u0000\u0000\u0000\u0129"+
		"\u012a\u0005\'\u0000\u0000\u012a\u012b\u0005*\u0000\u0000\u012bO\u0001"+
		"\u0000\u0000\u0000\u012c\u012d\u0005(\u0000\u0000\u012d\u012e\u0005+\u0000"+
		"\u0000\u012eQ\u0001\u0000\u0000\u0000\u0002U\u007f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}