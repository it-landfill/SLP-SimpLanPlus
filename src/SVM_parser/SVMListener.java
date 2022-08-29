// Generated from /Users/alessandrobenetton/Library/CloudStorage/OneDrive-AlmaMaterStudiorumUniversitàdiBologna/University/I_Anno/II_[81941]-Compilatori_e_Interpreti/Progetto_CEI/src/SVM_parser/SVM.g4 by ANTLR 4.10.1
package SVM_parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SVMParser}.
 */
public interface SVMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterAssembly(SVMParser.AssemblyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitAssembly(SVMParser.AssemblyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(SVMParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(SVMParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#pushInt}.
	 * @param ctx the parse tree
	 */
	void enterPushInt(SVMParser.PushIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#pushInt}.
	 * @param ctx the parse tree
	 */
	void exitPushInt(SVMParser.PushIntContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#popInt}.
	 * @param ctx the parse tree
	 */
	void enterPopInt(SVMParser.PopIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#popInt}.
	 * @param ctx the parse tree
	 */
	void exitPopInt(SVMParser.PopIntContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#topInt}.
	 * @param ctx the parse tree
	 */
	void enterTopInt(SVMParser.TopIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#topInt}.
	 * @param ctx the parse tree
	 */
	void exitTopInt(SVMParser.TopIntContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#pushBool}.
	 * @param ctx the parse tree
	 */
	void enterPushBool(SVMParser.PushBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#pushBool}.
	 * @param ctx the parse tree
	 */
	void exitPushBool(SVMParser.PushBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#popBool}.
	 * @param ctx the parse tree
	 */
	void enterPopBool(SVMParser.PopBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#popBool}.
	 * @param ctx the parse tree
	 */
	void exitPopBool(SVMParser.PopBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#topBool}.
	 * @param ctx the parse tree
	 */
	void enterTopBool(SVMParser.TopBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#topBool}.
	 * @param ctx the parse tree
	 */
	void exitTopBool(SVMParser.TopBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#li}.
	 * @param ctx the parse tree
	 */
	void enterLi(SVMParser.LiContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#li}.
	 * @param ctx the parse tree
	 */
	void exitLi(SVMParser.LiContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#mov}.
	 * @param ctx the parse tree
	 */
	void enterMov(SVMParser.MovContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#mov}.
	 * @param ctx the parse tree
	 */
	void exitMov(SVMParser.MovContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#lw}.
	 * @param ctx the parse tree
	 */
	void enterLw(SVMParser.LwContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#lw}.
	 * @param ctx the parse tree
	 */
	void exitLw(SVMParser.LwContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#sw}.
	 * @param ctx the parse tree
	 */
	void enterSw(SVMParser.SwContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#sw}.
	 * @param ctx the parse tree
	 */
	void exitSw(SVMParser.SwContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#lb}.
	 * @param ctx the parse tree
	 */
	void enterLb(SVMParser.LbContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#lb}.
	 * @param ctx the parse tree
	 */
	void exitLb(SVMParser.LbContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#sb}.
	 * @param ctx the parse tree
	 */
	void enterSb(SVMParser.SbContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#sb}.
	 * @param ctx the parse tree
	 */
	void exitSb(SVMParser.SbContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(SVMParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(SVMParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#addi}.
	 * @param ctx the parse tree
	 */
	void enterAddi(SVMParser.AddiContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#addi}.
	 * @param ctx the parse tree
	 */
	void exitAddi(SVMParser.AddiContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSub(SVMParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSub(SVMParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#subi}.
	 * @param ctx the parse tree
	 */
	void enterSubi(SVMParser.SubiContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#subi}.
	 * @param ctx the parse tree
	 */
	void exitSubi(SVMParser.SubiContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterMult(SVMParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitMult(SVMParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#multi}.
	 * @param ctx the parse tree
	 */
	void enterMulti(SVMParser.MultiContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#multi}.
	 * @param ctx the parse tree
	 */
	void exitMulti(SVMParser.MultiContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#div}.
	 * @param ctx the parse tree
	 */
	void enterDiv(SVMParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#div}.
	 * @param ctx the parse tree
	 */
	void exitDiv(SVMParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#divi}.
	 * @param ctx the parse tree
	 */
	void enterDivi(SVMParser.DiviContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#divi}.
	 * @param ctx the parse tree
	 */
	void exitDivi(SVMParser.DiviContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#mod}.
	 * @param ctx the parse tree
	 */
	void enterMod(SVMParser.ModContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#mod}.
	 * @param ctx the parse tree
	 */
	void exitMod(SVMParser.ModContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#modi}.
	 * @param ctx the parse tree
	 */
	void enterModi(SVMParser.ModiContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#modi}.
	 * @param ctx the parse tree
	 */
	void exitModi(SVMParser.ModiContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#lt}.
	 * @param ctx the parse tree
	 */
	void enterLt(SVMParser.LtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#lt}.
	 * @param ctx the parse tree
	 */
	void exitLt(SVMParser.LtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#lte}.
	 * @param ctx the parse tree
	 */
	void enterLte(SVMParser.LteContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#lte}.
	 * @param ctx the parse tree
	 */
	void exitLte(SVMParser.LteContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#gt}.
	 * @param ctx the parse tree
	 */
	void enterGt(SVMParser.GtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#gt}.
	 * @param ctx the parse tree
	 */
	void exitGt(SVMParser.GtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#gte}.
	 * @param ctx the parse tree
	 */
	void enterGte(SVMParser.GteContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#gte}.
	 * @param ctx the parse tree
	 */
	void exitGte(SVMParser.GteContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#eq}.
	 * @param ctx the parse tree
	 */
	void enterEq(SVMParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#eq}.
	 * @param ctx the parse tree
	 */
	void exitEq(SVMParser.EqContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#neq}.
	 * @param ctx the parse tree
	 */
	void enterNeq(SVMParser.NeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#neq}.
	 * @param ctx the parse tree
	 */
	void exitNeq(SVMParser.NeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(SVMParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(SVMParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(SVMParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(SVMParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(SVMParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(SVMParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#neg}.
	 * @param ctx the parse tree
	 */
	void enterNeg(SVMParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#neg}.
	 * @param ctx the parse tree
	 */
	void exitNeg(SVMParser.NegContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#printw}.
	 * @param ctx the parse tree
	 */
	void enterPrintw(SVMParser.PrintwContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#printw}.
	 * @param ctx the parse tree
	 */
	void exitPrintw(SVMParser.PrintwContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#printb}.
	 * @param ctx the parse tree
	 */
	void enterPrintb(SVMParser.PrintbContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#printb}.
	 * @param ctx the parse tree
	 */
	void exitPrintb(SVMParser.PrintbContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#beq}.
	 * @param ctx the parse tree
	 */
	void enterBeq(SVMParser.BeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#beq}.
	 * @param ctx the parse tree
	 */
	void exitBeq(SVMParser.BeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(SVMParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(SVMParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#halt}.
	 * @param ctx the parse tree
	 */
	void enterHalt(SVMParser.HaltContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#halt}.
	 * @param ctx the parse tree
	 */
	void exitHalt(SVMParser.HaltContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#jal}.
	 * @param ctx the parse tree
	 */
	void enterJal(SVMParser.JalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#jal}.
	 * @param ctx the parse tree
	 */
	void exitJal(SVMParser.JalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#jr}.
	 * @param ctx the parse tree
	 */
	void enterJr(SVMParser.JrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#jr}.
	 * @param ctx the parse tree
	 */
	void exitJr(SVMParser.JrContext ctx);
}