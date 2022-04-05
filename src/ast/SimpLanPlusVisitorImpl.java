package ast;

import parser.SimpLanPlusBaseVisitor;
import parser.SimpLanPlusParser;

import java.util.ArrayList;

public class SimpLanPlusVisitorImpl extends SimpLanPlusBaseVisitor<Node> {
	@Override
	public Node visitBlock(SimpLanPlusParser.BlockContext ctx) {
		ArrayList<Node> declarations = new ArrayList<>();
		ArrayList<Node> statements = new ArrayList<>();

		for(SimpLanPlusParser.DeclarationContext dc: ctx.declaration()){
			declarations.add(visit(dc));
		}

		for(SimpLanPlusParser.StatementContext sc: ctx.statement()){
			statements.add(visit(sc));
		}

		return new BlockNode(declarations, statements);
	}

	@Override
	public Node visitStatement(SimpLanPlusParser.StatementContext ctx) {
		return super.visitStatement(ctx);
	}

	@Override
	public Node visitDeclaration(SimpLanPlusParser.DeclarationContext ctx) {
		return super.visitDeclaration(ctx);
	}

	@Override
	public Node visitDecFun(SimpLanPlusParser.DecFunContext ctx) {
		return super.visitDecFun(ctx);
	}

	@Override
	public Node visitDecVar(SimpLanPlusParser.DecVarContext ctx) {
		return super.visitDecVar(ctx);
	}

	@Override
	public Node visitType(SimpLanPlusParser.TypeContext ctx) {
		return super.visitType(ctx);
	}

	@Override
	public Node visitArg(SimpLanPlusParser.ArgContext ctx) {
		return super.visitArg(ctx);
	}

	@Override
	public Node visitAssignment(SimpLanPlusParser.AssignmentContext ctx) {
		return super.visitAssignment(ctx);
	}

	@Override
	public Node visitPrint(SimpLanPlusParser.PrintContext ctx) {
		return super.visitPrint(ctx);
	}

	@Override
	public Node visitRet(SimpLanPlusParser.RetContext ctx) {
		return super.visitRet(ctx);
	}

	@Override
	public Node visitIte(SimpLanPlusParser.IteContext ctx) {
		return super.visitIte(ctx);
	}

	@Override
	public Node visitCall(SimpLanPlusParser.CallContext ctx) {
		return super.visitCall(ctx);
	}

	@Override
	public Node visitBaseExp(SimpLanPlusParser.BaseExpContext ctx) {
		return super.visitBaseExp(ctx);
	}

	@Override
	public Node visitBinExp(SimpLanPlusParser.BinExpContext ctx) {
		return super.visitBinExp(ctx);
	}

	@Override
	public Node visitDerExp(SimpLanPlusParser.DerExpContext ctx) {
		return super.visitDerExp(ctx);
	}

	@Override
	public Node visitValExp(SimpLanPlusParser.ValExpContext ctx) {
		return super.visitValExp(ctx);
	}

	@Override
	public Node visitNegExp(SimpLanPlusParser.NegExpContext ctx) {
		return super.visitNegExp(ctx);
	}

	@Override
	public Node visitBoolExp(SimpLanPlusParser.BoolExpContext ctx) {
		return super.visitBoolExp(ctx);
	}

	@Override
	public Node visitCallExp(SimpLanPlusParser.CallExpContext ctx) {
		return super.visitCallExp(ctx);
	}

	@Override
	public Node visitNotExp(SimpLanPlusParser.NotExpContext ctx) {
		return super.visitNotExp(ctx);
	}
}
