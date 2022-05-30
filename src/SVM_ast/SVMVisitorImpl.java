package SVM_ast;

import SVM_parser.SVMBaseVisitor;
import SVM_parser.SVMLexer;
import SVM_parser.SVMParser;
import interpreter.ExecuteVM;

public class SVMVisitorImpl extends SVMBaseVisitor<Void> {

	public int[] code = new int[ExecuteVM.CODESIZE];
	private int i = 0;

	@Override
	public Void visitAssembly(SVMParser.AssemblyContext ctx) {
		visitChildren(ctx);
		return null;
	}

	@Override
	public Void visitPush(SVMParser.PushContext ctx) {
		code[i++] = SVMParser.PUSH;
		code[i++] = Integer.parseInt(String.valueOf(ctx.src.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitPop(SVMParser.PopContext ctx) {
		code[i++] = SVMParser.POP;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitTop(SVMParser.TopContext ctx) {
		code[i++] = SVMParser.TOP;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitAdd(SVMParser.AddContext ctx) {
		code[i++] = SVMParser.ADD;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitSub(SVMParser.SubContext ctx) {
		code[i++] = SVMParser.SUB;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitMul(SVMParser.MulContext ctx) {
		code[i++] = SVMParser.MUL;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitDiv(SVMParser.DivContext ctx) {
		code[i++] = SVMParser.DIV;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitLt(SVMParser.LtContext ctx) {
		code[i++] = SVMParser.LT;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitLte(SVMParser.LteContext ctx) {
		code[i++] = SVMParser.LTE;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitGt(SVMParser.GtContext ctx) {
		code[i++] = SVMParser.GT;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitGte(SVMParser.GteContext ctx) {
		code[i++] = SVMParser.GTE;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitEq(SVMParser.EqContext ctx) {
		code[i++] = SVMParser.EQ;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitNeq(SVMParser.NeqContext ctx) {
		// Calcolo una EQ e la nego
		code[i++] = SVMParser.EQ;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		code[i++] = SVMParser.NOT;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitAnd(SVMParser.AndContext ctx) {
		code[i++] = SVMParser.AND;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitOr(SVMParser.OrContext ctx) {
		code[i++] = SVMParser.OR;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitNot(SVMParser.NotContext ctx) {
		code[i++] = SVMParser.NOT;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.src.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitPrint(SVMParser.PrintContext ctx) {
		code[i++] = SVMParser.PRINT;
		code[i++] = Integer.parseInt(String.valueOf(ctx.src.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitLi(SVMParser.LiContext ctx) {
		code[i++] = SVMParser.LI;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(ctx.n.getText());
		return null;
	}

	@Override
	public Void visitMov(SVMParser.MovContext ctx) {
		code[i++] = SVMParser.MOV;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.src.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitNeg(SVMParser.NegContext ctx) {
		code[i++] = SVMParser.NEG;
		code[i++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(1)));
		code[i++] = Integer.parseInt(String.valueOf(ctx.src.getText().charAt(1)));
		return null;
	}

	@Override
	public Void visitHalt(SVMParser.HaltContext ctx) {
		code[i++] = SVMParser.HALT;
		return null;
	}
}
