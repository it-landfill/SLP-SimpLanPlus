// Generated from /Users/alessandrobenetton/Library/CloudStorage/OneDrive-AlmaMaterStudiorumUniversitàdiBologna/University/I_Anno/II_[81941]-Compilatori_e_Interpreti/Progetto_CEI/src/SVM_parser/SVM.g4 by ANTLR 4.10.1
package SVM_parser;

import java.util.HashMap;

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
	 * Enter a parse tree produced by {@link SVMParser#push}.
	 * @param ctx the parse tree
	 */
	void enterPush(SVMParser.PushContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#push}.
	 * @param ctx the parse tree
	 */
	void exitPush(SVMParser.PushContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#pop}.
	 * @param ctx the parse tree
	 */
	void enterPop(SVMParser.PopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#pop}.
	 * @param ctx the parse tree
	 */
	void exitPop(SVMParser.PopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#top}.
	 * @param ctx the parse tree
	 */
	void enterTop(SVMParser.TopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#top}.
	 * @param ctx the parse tree
	 */
	void exitTop(SVMParser.TopContext ctx);
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
	 * Enter a parse tree produced by {@link SVMParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(SVMParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(SVMParser.PrintContext ctx);
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