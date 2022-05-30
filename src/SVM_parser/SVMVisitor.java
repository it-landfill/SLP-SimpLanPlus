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
	 * Visit a parse tree produced by {@link SVMParser#push}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPush(SVMParser.PushContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#pop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPop(SVMParser.PopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#top}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop(SVMParser.TopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(SVMParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(SVMParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(SVMParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(SVMParser.DivContext ctx);
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
	 * Visit a parse tree produced by {@link SVMParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(SVMParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#li}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLi(SVMParser.LiContext ctx);
	/**
	 * Visit a parse tree produced by {@link SVMParser#halt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalt(SVMParser.HaltContext ctx);
}