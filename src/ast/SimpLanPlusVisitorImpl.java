package ast;

import ast.declarationNode.FunNode;
import ast.declarationNode.VarNode;
import ast.statementNode.*;
import ast.typeNode.BoolTypeNode;
import ast.typeNode.IntTypeNode;
import parser.SimpLanPlusBaseVisitor;
import parser.SimpLanPlusParser;

import java.util.ArrayList;

// ctx potrebbe (non siamo sicuri) rappresentare un sottoalbero dell'albero con il nodo attuale come radice.
// Da ragionare con balu o il professore (meglio balu).

public class SimpLanPlusVisitorImpl extends SimpLanPlusBaseVisitor<Node> {
	@Override
	public Node visitBlock(SimpLanPlusParser.BlockContext ctx) {
		ArrayList<Node> declarations = new ArrayList<>();
		ArrayList<Node> statements = new ArrayList<>();


		for (SimpLanPlusParser.DeclarationContext dc : ctx.declaration()) {
			declarations.add(visit(dc));
		}

		for (SimpLanPlusParser.StatementContext sc : ctx.statement()) {
			statements.add(visit(sc));
		}

		return new BlockNode(declarations, statements);
	}

	// Declarations
	@Override
	public Node visitDeclaration(SimpLanPlusParser.DeclarationContext ctx) {
		if (ctx.decFun() != null) return visit(ctx.decFun());
		if (ctx.decVar() != null) return visit(ctx.decVar());

		//Non dovrei mai arrivare qui
		return null;
	}

	@Override
	public Node visitDecVar(SimpLanPlusParser.DecVarContext ctx) {
		Node type = visit(ctx.type());
		String ID = ctx.ID().getText();
		if (ctx.exp() != null) {
			Node exp = visit(ctx.exp());
			return new VarNode(ID, type, exp);
		}
		return new VarNode(ID, type);
	}

	@Override
	public Node visitDecFun(SimpLanPlusParser.DecFunContext ctx) {
		String ID = ctx.ID().getText();
		Node retType = null;
		Node block = visit(ctx.block());
		ArrayList<Node> args = null;

		if (ctx.type() != null) retType = visit(ctx.type());

		if (ctx.arg() != null && !ctx.arg().isEmpty()) {
			args = new ArrayList<>();
			for (SimpLanPlusParser.ArgContext arg : ctx.arg()) {
				args.add(visit(arg));
			}
		}

		return new FunNode(retType, ID, args, block);
	}

	// Statements
	@Override
	public Node visitStatement(SimpLanPlusParser.StatementContext ctx) {
		if (ctx.assignment() != null) return visit(ctx.assignment());
		if (ctx.print() != null) return visit(ctx.print());
		if (ctx.ret() != null) return visit(ctx.ret());
		if (ctx.ite() != null) return visit(ctx.ite());
		if (ctx.call() != null) System.out.println("Call");
		if (ctx.block() != null) return visitBlock(ctx.block());

		// Non dovrei mai arrivarci
		return null;
	}

	@Override
	public Node visitAssignment(SimpLanPlusParser.AssignmentContext ctx) {
		String ID = ctx.ID().getText();
		Node exp = visit(ctx.exp());
		return new AssignmentNode(ID, exp);
	}

	@Override
	public Node visitPrint(SimpLanPlusParser.PrintContext ctx) {
		Node exp = visit(ctx.exp());
		return new PrintNode(exp);
	}

	@Override
	public Node visitRet(SimpLanPlusParser.RetContext ctx) {
		if (ctx.exp() != null) {
			Node exp = visit(ctx.exp());
			return new ReturnNode(exp);
		}
		return new ReturnNode();
	}

	@Override
	public Node visitIte(SimpLanPlusParser.IteContext ctx) {
		Node cond = visit(ctx.exp());
		Node ifT = visit(ctx.statement().get(0));
		if (ctx.statement().size() == 2) {
			Node ifF = visit(ctx.statement().get(1));
			return new ITENode(cond, ifT, ifF);
		}
		return new ITENode(cond, ifT);
	}

	@Override
	public Node visitCall(SimpLanPlusParser.CallContext ctx) {
		String ID = ctx.ID().getText();

		if (ctx.exp() != null && !ctx.exp().isEmpty()) {
			ArrayList<Node> params = new ArrayList<>();
			for (SimpLanPlusParser.ExpContext exp : ctx.exp()) {
				params.add(visit(exp));
			}
			return new CallNode(ID, params);
		}

		return new CallNode(ID);
	}

	/**
	 * Valutazione type rule
	 * Valutazione della regola "type : INTEGER | BOOLEAN;"
	 *
	 * TODO: Ha senso avere due tipi diversi? Il prof li fa, ma potenzialmente basterebbe un typeNode
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorniamo un nodo del tipo presente nel contesto (ctx) in esame
	 */
	@Override
	public Node visitType(SimpLanPlusParser.TypeContext ctx){
		if (ctx.INTEGER() != null) return new IntTypeNode();
		if (ctx.BOOLEAN() != null) return new BoolTypeNode();
		return null;
	}
}
