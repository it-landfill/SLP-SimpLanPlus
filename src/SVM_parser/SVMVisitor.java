// Generated from /Users/alessandrobenetton/Library/CloudStorage/OneDrive-AlmaMaterStudiorumUniversitàdiBologna/University/I_Anno/II_[81941]-Compilatori_e_Interpreti/Progetto_CEI/src/SVM_parser/SVM.g4 by ANTLR 4.10.1
package SVM_parser;

import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SVMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SVMVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssembly(SVMParser.AssemblyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(SVMParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#pushInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPushInt(SVMParser.PushIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#popInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPopInt(SVMParser.PopIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#topInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopInt(SVMParser.TopIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#pushBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPushBool(SVMParser.PushBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#popBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPopBool(SVMParser.PopBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#topBool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopBool(SVMParser.TopBoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#li}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLi(SVMParser.LiContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#mov}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMov(SVMParser.MovContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#lw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLw(SVMParser.LwContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#sw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSw(SVMParser.SwContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#lb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLb(SVMParser.LbContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#sb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSb(SVMParser.SbContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(SVMParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#addi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddi(SVMParser.AddiContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(SVMParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#subi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubi(SVMParser.SubiContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(SVMParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#multi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulti(SVMParser.MultiContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(SVMParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#divi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivi(SVMParser.DiviContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#lt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLt(SVMParser.LtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#lte}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLte(SVMParser.LteContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#gt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGt(SVMParser.GtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#gte}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGte(SVMParser.GteContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#eq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(SVMParser.EqContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#neq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeq(SVMParser.NeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(SVMParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(SVMParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(SVMParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#neg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeg(SVMParser.NegContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#printw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintw(SVMParser.PrintwContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#printb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintb(SVMParser.PrintbContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#beq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeq(SVMParser.BeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(SVMParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#halt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalt(SVMParser.HaltContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#jal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJal(SVMParser.JalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#jr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJr(SVMParser.JrContext ctx);
}