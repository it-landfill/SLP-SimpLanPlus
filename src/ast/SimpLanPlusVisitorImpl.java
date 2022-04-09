package ast;

import ast.declarationNode.FunNode;
import ast.declarationNode.VarNode;
import ast.expNode.*;
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

	// Declarations
	@Override
	public Node visitDeclaration(SimpLanPlusParser.DeclarationContext ctx) {
		if (ctx.decFun() != null) return visit(ctx.decFun());
		if (ctx.decVar() != null) return visit(ctx.decVar());

		//Non dovrei mai arrivare qui
		return null;
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

	/*
	 * Valutazione type rule
	 * Valutazione della regola "type : INTEGER | BOOLEAN;"
	 *
	 * TODO: Ha senso avere due tipi diversi? Il prof li fa, ma potenzialmente basterebbe un typeNode
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorniamo un nodo del tipo presente nel contesto (ctx) in esame
	 */
	@Override
	public Node visitType(SimpLanPlusParser.TypeContext ctx) {
		if (ctx.INTEGER() != null) return new IntTypeNode();
		if (ctx.BOOLEAN() != null) return new BoolTypeNode();
		return null;

	}

	/**
	 * arg : ('var')? type ID;
	 * <p>
	 * TODO: Chiedere al professore cosa intede per "passaggio per variabile".
	 *       Noi conosciamo il passaggio per "copia" (creazione di una variabile distinta da quella originale) o
	 *       "riferimento" (utilizzo dell'indirizzo in memoria della variabile)
	 *
	 * @return
	 */
	@Override
	public Node visitArg(SimpLanPlusParser.ArgContext ctx) {

		boolean byReference = ctx.children.get(0).toString().equals("var");
		String ID = ctx.ID().getText();
		Node type = visit(ctx.type());

		return new ArgNode(type, ID, byReference);
	}

	//Expressions

	/**
	 * exp : '(' exp ')' #baseExp
	 *
	 * @param ctx
	 * @return
	 */
	@Override
	public Node visitBaseExp(SimpLanPlusParser.BaseExpContext ctx) {
		return new BaseExpNode(visit(ctx.exp()));
	}

	@Override
	public Node visitNegExp(SimpLanPlusParser.NegExpContext ctx) {
		return new NegExpNode(visit(ctx.exp()));
	}

	@Override
	public Node visitNotExp(SimpLanPlusParser.NotExpContext ctx) {
		return new NotExpNode(visit(ctx.exp()));
	}

	@Override
	public Node visitDerExp(SimpLanPlusParser.DerExpContext ctx) {
		return new DerExpNode(ctx.ID().toString());
	}

	@Override
	public Node visitBinExp(SimpLanPlusParser.BinExpContext ctx) {
		// TODO: Sarebbe concettualmente più corretto dividere binExp in due elementi, uno per le operazioni matematiche e uno per quelle logiche. DA DISCUTERE
		Node left = visit(ctx.left);
		String op = ctx.op.getText();
		Node right = visit(ctx.right);
		return new BinExpNode(left, right, op);
	}

	@Override
	public Node visitCallExp(SimpLanPlusParser.CallExpContext ctx) {
		//FIXME: Serve veramente la classe CallExpNode o potrei fare direttamente una return visit...
		return new CallExpNode(visit(ctx.call()));
	}

	@Override
	public Node visitBoolExp(SimpLanPlusParser.BoolExpContext ctx) {
		String val = ctx.BOOL().toString();
		return new BoolExpNode(val.equals("true"));
	}

	@Override
	public Node visitValExp(SimpLanPlusParser.ValExpContext ctx) {
		String valS = ctx.NUMBER().toString();
		int val = Integer.parseInt(valS);
		return new ValExpNode(val);
	}
}
