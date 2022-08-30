package SLP_ast;

import SLP_ast.declarationNode.FunNode;
import SLP_ast.declarationNode.VarNode;
import SLP_ast.expNode.*;
import SLP_ast.statementNode.*;
import SLP_ast.typeNode.*;
import SLP_parser.SimpLanPlusBaseVisitor;
import SLP_parser.SimpLanPlusParser;

import java.util.ArrayList;

// Per collassare tutti i commenti delle funzioni o espanderli seguire il seguente percorso (IntelliJ IDEA).
// Code > Folding > Collapse Docs Comments / Expand Docs Comments

public class SimpLanPlusVisitorImpl extends SimpLanPlusBaseVisitor<Node> {

	/**
	 * Evaluating "program rule"
	 * <p>
	 * Rule: "program : '{' declaration* statement* '}' EOF;"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a ProgramNode object containing two ArrayList Node, one for declarations, the other for statements.
	 */
	@Override
	public Node visitProgram(SimpLanPlusParser.ProgramContext ctx) {
		ArrayList<Node> declarations = new ArrayList<>();
		ArrayList<Node> statements = new ArrayList<>();

		for (SimpLanPlusParser.DeclarationContext dc : ctx.declaration()) {
			declarations.add(visit(dc));
		}

		for (SimpLanPlusParser.StatementContext sc : ctx.statement()) {
			statements.add(visit(sc));
		}

		return new BlockNode(declarations, statements, true);
	}

	/**
	 * Evaluating "block rule"
	 * <p>
	 * Rule: "block : '{' decVar* statement* '}';"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a BlockNode object containing two ArrayList Node, one for declarations, the other for statements.
	 */
	@Override
	public Node visitBlock(SimpLanPlusParser.BlockContext ctx) {
		ArrayList<Node> declarations = new ArrayList<>();
		ArrayList<Node> statements = new ArrayList<>();

		for (SimpLanPlusParser.DecVarContext dc : ctx.decVar()) {
			declarations.add(visit(dc));
		}

		for (SimpLanPlusParser.StatementContext sc : ctx.statement()) {
			statements.add(visit(sc));
		}

		return new BlockNode(declarations, statements, false);
	}

	/**
	 * Valutazione "statement rule"
	 * <p>
	 * Rule: "statement : assignment ';' | print ';' | ret ';' | ite | call ';' | block;"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns change according to ctx evaluation.
	 */
	@Override
	public Node visitStatement(SimpLanPlusParser.StatementContext ctx) {
		if (ctx.assignment() != null) return visit(ctx.assignment());
		if (ctx.print() != null) return visit(ctx.print());
		if (ctx.ret() != null) return visit(ctx.ret());
		if (ctx.ite() != null) return visit(ctx.ite());
		if (ctx.call() != null) return visit(ctx.call());
		if (ctx.block() != null) return visitBlock(ctx.block());

		// Should never be reached.
		return null;
	}

	/**
	 * Evaluating "assignment rule"
	 * <p>
	 * Rule: "assignment : ID '=' exp ;"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns an AssignmentNode object containing a string ID and a Node expression.
	 */
	@Override
	public Node visitAssignment(SimpLanPlusParser.AssignmentContext ctx) {
		String ID = ctx.ID().getText();
		Node exp = visit(ctx.exp());
		return new AssignmentNode(ID, exp);
	}

	/**
	 * Evaluating "print rule"
	 * <p>
	 * Rule: "print : 'print' exp;"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a PrintNode object containing the Node expression to be printed.
	 */
	@Override
	public Node visitPrint(SimpLanPlusParser.PrintContext ctx) {
		Node exp = visit(ctx.exp());
		return new PrintNode(exp);
	}

	/**
	 * Evaluating "ret rule"
	 * <p>
	 * Rule: "ret : 'return' (exp)?;"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a ReturnNode that can contain a Node representing the return value, this Node will be null if the
	 * function is void.
	 */
	@Override
	public Node visitRet(SimpLanPlusParser.RetContext ctx) {
		if (ctx.exp() != null) {
			Node exp = visit(ctx.exp());
			return new ReturnNode(exp);
		}
		return new ReturnNode();
	}

	/**
	 * Evaluating "ite rule"
	 * <p>
	 * Rule: "ite : 'if' '(' exp ')' statement ('else' statement)?;"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a ITENode that contains a Node representing the condition, another node for the true branch, and
	 * a third node for the false branch (if present).
	 */
	@Override
	public Node visitIte(SimpLanPlusParser.IteContext ctx) {
		Node cond = visit(ctx.exp());

		// If the statement size is 0, there hase been an error in program parsing.
		if (ctx.statement().size() == 0) return null;

		Node ifT = visit(ctx.statement().get(0));
		if (ctx.statement().size() == 2) {
			Node ifF = visit(ctx.statement().get(1));
			return new ITENode(cond, ifT, ifF);
		}
		return new ITENode(cond, ifT);
	}

	/**
	 * Evaluating "call rule"
	 * <p>
	 * Rule: "call : ID '(' (exp(',' exp)*)? ')';"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a CallNode.
	 */
	@Override
	public Node visitCall(SimpLanPlusParser.CallContext ctx) {
		String ID = ctx.ID().getText();

		// Evaluate the actual parameters only if exp is not null.
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
	 * Evaluating "declaration rule"
	 * <p>
	 * Rule: "declaration : decFun | decVar ;"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns change according to ctx evaluation.
	 */
	@Override
	public Node visitDeclaration(SimpLanPlusParser.DeclarationContext ctx) {
		if (ctx.decFun() != null) return visit(ctx.decFun());
		if (ctx.decVar() != null) return visit(ctx.decVar());

		// Should never be reached.
		return null;
	}

	/**
	 * Evaluating "decFun rule"
	 * <p>
	 * Rule: "decFun : (type | 'void') ID '(' (arg (',' arg)*)? ')' block ;"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a FunNode containing the function signature and body.
	 */
	@Override
	public Node visitDecFun(SimpLanPlusParser.DecFunContext ctx) {
		String ID = ctx.ID().getText();

		TypeNode retType = null;
		ArrayList<ArgNode> args;
		FunctionSingatureType signature;

		Node block = visit(ctx.block());

		// Evaluation of return type for the function.
		if (ctx.type() != null) {
			Node tmpType = visit(ctx.type());
			if (!(tmpType instanceof TypeNode)) System.out.println("[INTERNAL ERROR] Casting to typeNode failed");
			else retType = (TypeNode) tmpType;
		} else retType = new VoidTypeNode();

		// Evaluation of formal parameters for the function.
		if (ctx.arg() != null && !ctx.arg().isEmpty()) {
			args = new ArrayList<>();
			for (SimpLanPlusParser.ArgContext arg : ctx.arg()) {
				args.add(visitArg(arg));
			}
		} else args = null;

		// Generate the function signature
		signature = new FunctionSingatureType(args, retType);

		return new FunNode(ID, signature, block);
	}

	/**
	 * Evaluating "decVar rule"
	 * <p>
	 * Rule: "decVar : type ID ('=' exp)? ';' ;"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a VarNode containing ID, type of the variable, and optional start value of the variable.
	 */
	@Override
	public Node visitDecVar(SimpLanPlusParser.DecVarContext ctx) {
		TypeNode type = null;

		Node tmpType = visit(ctx.type());
		if (!(tmpType instanceof TypeNode)) System.out.println("[INTERNAL ERROR] Casting to typeNode failed");
		else type = (TypeNode) tmpType;

		String ID = ctx.ID().getText();
		if (ctx.exp() != null) {
			Node exp = visit(ctx.exp());
			return new VarNode(ID, type, exp);
		}
		return new VarNode(ID, type);
	}

	/**
	 * Evaluating "type rule"
	 * <p>
	 * Rule: "type : INTEGER | BOOLEAN;"
	 * <p>
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a TypeNode based on context.
	 */
	@Override
	public Node visitType(SimpLanPlusParser.TypeContext ctx) {
		if (ctx.INTEGER() != null) return new IntTypeNode();
		if (ctx.BOOLEAN() != null) return new BoolTypeNode();

		// Should never be reached.
		return null;
	}

	/**
	 * Evaluating "arg rule"
	 * <p>
	 * Rule: "arg : ('var')? type ID;"
	 * <p>
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a ArgNode representing the formal parametrs of the function.
	 */
	@Override
	public ArgNode visitArg(SimpLanPlusParser.ArgContext ctx) {

		boolean byReference = ctx.VAR() != null;
		String ID = ctx.ID().getText();

		TypeNode type = null;

		Node tmpType = visit(ctx.type());
		if (!(tmpType instanceof TypeNode)) System.out.println("[INTERNAL ERROR] Casting to typeNode failed");
		else type = (TypeNode) tmpType;

		return new ArgNode(type, ID, byReference);
	}

	/**
	 * Evaluating "baseExp rule" (Expressions)
	 * <p>
	 * Rule: "exp : '(' exp ')' #baseExp"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a BaseExpNode.
	 */
	@Override
	public Node visitBaseExp(SimpLanPlusParser.BaseExpContext ctx) {
		return new BaseExpNode(visit(ctx.exp()));
	}

	/**
	 * Evaluating "negExp rule" (Expressions)
	 * <p>
	 * Rule: "exp : '-' exp #negExp"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a NegExpNode.
	 */
	@Override
	public Node visitNegExp(SimpLanPlusParser.NegExpContext ctx) {
		return new NegExpNode(visit(ctx.exp()));
	}

	/**
	 * Evaluating "notExp rule" (Expressions)
	 * <p>
	 * Rule: "exp : '!' exp #notExp"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a NotExpNode.
	 */
	@Override
	public Node visitNotExp(SimpLanPlusParser.NotExpContext ctx) {
		return new NotExpNode(visit(ctx.exp()));
	}

	/**
	 * Evaluating "derExp rule" (Expressions)
	 * <p>
	 * Rule: "ID #derExp"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a DerExpNode.
	 */
	@Override
	public Node visitDerExp(SimpLanPlusParser.DerExpContext ctx) {
		return new DerExpNode(ctx.ID().toString());
	}

	/**
	 * Evaluating "Arithm rule" (Expressions)
	 * <p>
	 * Rule: "exp : left=exp op=('*' | '/' | '%')   right=exp #arithmExp
	 * | left=exp op=('+' | '-')               right=exp #arithmExp
	 * <p>
	 *
	 * @param ctx Evaluation context.
	 * @return Returns an ArithmExpNode.
	 */
	@Override
	public Node visitArithmExp(SimpLanPlusParser.ArithmExpContext ctx) {
		Node left = visit(ctx.left);
		String op = ctx.op.getText();
		Node right = visit(ctx.right);
		return new ArithmExpNode(left, right, op);
	}

	/**
	 * Evaluating "compare rule" (Expressions)
	 * <p>
	 * Rule: "exp :
	 * | left=exp op=('<' | '<=' | '>' | '>=') right=exp #compExp"
	 * <p>
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a CompExpNode.
	 */
	@Override
	public Node visitCompareExp(SimpLanPlusParser.CompareExpContext ctx) {
		Node left = visit(ctx.left);
		String op = ctx.op.getText();
		Node right = visit(ctx.right);
		return new CompareExpNode(left, right, op);
	}

	/**
	 * Evaluating "equal rule" (Expressions)
	 * <p>
	 * Rule: "exp :
	 * | left=exp op=('=='| '!=')              right=exp #equalExp"
	 * <p>
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a EqualExpNode.
	 */
	@Override
	public Node visitEqualExp(SimpLanPlusParser.EqualExpContext ctx) {
		Node left = visit(ctx.left);
		String op = ctx.op.getText();
		Node right = visit(ctx.right);
		return new EqualExpNode(left, right, op);
	}

	/**
	 * Evaluating "logic rule" (Expressions)
	 * <p>
	 * Rule: "exp :
	 * | left=exp op='&&'                      right=exp #logicExp
	 * | left=exp op='||'                      right=exp #logicExp"
	 * <p>
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a LogicExpNode.
	 */
	@Override
	public Node visitLogicExp(SimpLanPlusParser.LogicExpContext ctx) {
		Node left = visit(ctx.left);
		String op = ctx.op.getText();
		Node right = visit(ctx.right);
		return new LogicExpNode(left, right, op);
	}

	/**
	 * Evaluating "callExp rule" (Expressions)
	 * <p>
	 * Rule: "exp : call #callExp"
	 * <p>
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a CallExpNode.
	 */
	@Override
	public Node visitCallExp(SimpLanPlusParser.CallExpContext ctx) {
		return new CallExpNode(visit(ctx.call()));
	}

	/**
	 * Evaluating "boolExp rule" (Expressions)
	 * <p>
	 * Rule: "exp : BOOL #boolExp"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a BoolExpNode.
	 */
	@Override
	public Node visitBoolExp(SimpLanPlusParser.BoolExpContext ctx) {
		String val = ctx.BOOL().toString();
		return new BoolExpNode(val.equals("true"));
	}

	/**
	 * Evaluating "valExp rule" (Expressions)
	 * <p>
	 * Rule: "exp : NUMBER	#valExp"
	 *
	 * @param ctx Evaluation context.
	 * @return Returns a ValExpNode.
	 */
	@Override
	public Node visitValExp(SimpLanPlusParser.ValExpContext ctx) {
		String valS = ctx.NUMBER().toString();
		int val = Integer.parseInt(valS);
		return new ValExpNode(val);
	}
}
