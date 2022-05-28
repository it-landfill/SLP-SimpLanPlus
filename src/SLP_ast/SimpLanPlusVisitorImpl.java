package SLP_ast;

import SLP_ast.declarationNode.FunNode;
import SLP_ast.declarationNode.VarNode;
import SLP_ast.expNode.*;
import SLP_ast.statementNode.*;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.IntTypeNode;
import SLP_ast.typeNode.VoidTypeNode;
import SLP_parser.SimpLanPlusBaseVisitor;
import SLP_parser.SimpLanPlusParser;

import java.util.ArrayList;

// Per collassare tutti i commenti delle funzioni o espanderli seguire il seguente percorso (IntelliJ IDEA).
// Code > Folding > Collapse Docs Comments / Expand Docs Comments

public class SimpLanPlusVisitorImpl extends SimpLanPlusBaseVisitor<Node> {

	/**
	 * Valutazione "block rule"
	 * <p>
	 * Regola "block : '{' declaration* statement* '}';"
	 *
	 * @param ctx Contesto in analisi.
	 * @return Ritorno di un oggetto BlockNode contenente due ArrayList Node per le declarations e statements del
	 * contesto.
	 */
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

	/**
	 * Valutazione "statement rule"
	 * <p>
	 * Regola "statement : assignment ';' | print ';' | ret ';' | ite | call ';' | block;"
	 * <p>
	 *
	 * @param ctx Contesto in analisi.
	 * @return Ritorno di un oggetto in base a quanto valutato dall'analisi di ctx.
	 */
	@Override
	public Node visitStatement(SimpLanPlusParser.StatementContext ctx) {
		if (ctx.assignment() != null) return visit(ctx.assignment());
		if (ctx.print() != null) return visit(ctx.print());
		if (ctx.ret() != null) return visit(ctx.ret());
		if (ctx.ite() != null) return visit(ctx.ite());
		if (ctx.call() != null) return visit(ctx.call());
		if (ctx.block() != null) return visitBlock(ctx.block());

		// Non dovrei mai arrivarci
		return null;
	}

	/**
	 * Valutazione "assignment rule"
	 * <p>
	 * Regola "assignment : ID '=' exp ;"
	 *
	 * @param ctx Contesto in analisi.
	 * @return Ritorno di un oggetto AssignmentNode contenente l'ID di tipo String e l'espressione di tipo Node
	 * generato dalla visita di quest'ultimo.
	 */
	@Override
	public Node visitAssignment(SimpLanPlusParser.AssignmentContext ctx) {
		String ID = ctx.ID().getText();
		Node exp = visit(ctx.exp());
		return new AssignmentNode(ID, exp);
	}

	/**
	 * Valutazione "print rule"
	 * <p>
	 * Regola "print : 'print' exp;"
	 *
	 * @param ctx Contesto in analisi.
	 * @return Ritorno di un oggetto PrintNode contenente l'espressione di tipo Node generato dalla visita di
	 * quest'ultimo.
	 */
	@Override
	public Node visitPrint(SimpLanPlusParser.PrintContext ctx) {
		Node exp = visit(ctx.exp());
		return new PrintNode(exp);
	}

	/**
	 * Valutazione "ret rule"
	 * <p>
	 * Regola "ret : 'return' (exp)?;"
	 *
	 * @param ctx Contesto in analisi.
	 * @return Ritorno di un oggetto ReturnNode il cui contenuto varia in base alla valutazione dell'exp legata al
	 * ctx in analisi.
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
	 * Valutazione "ite rule"
	 * <p>
	 * Regola "ite : 'if' '(' exp ')' statement ('else' statement)?;"
	 *
	 * @param ctx Contesto in analisi.
	 * @return Ritorno di un oggetto ITENode il cui contenuto varia in base alla valutazione degli statement presenti
	 * in ctx.
	 */
	@Override
	public Node visitIte(SimpLanPlusParser.IteContext ctx) {
		Node cond = visit(ctx.exp());

		// Se l'operatore è errato, non viene generato l'array di statement
		if(ctx.statement().size() == 0) return null;

		Node ifT = visit(ctx.statement().get(0));
		if (ctx.statement().size() == 2) {
			Node ifF = visit(ctx.statement().get(1));
			return new ITENode(cond, ifT, ifF);
		}
		return new ITENode(cond, ifT);
	}

	/**
	 * Valutazione "call rule"
	 * <p>
	 * Regola "call : ID '(' (exp(',' exp)*)? ')';"
	 *
	 * @param ctx Contesto in analisi.
	 * @return Ritorno di un oggetto CallNode il cui contenuto varia in base alla valutazione dell'espressione presente
	 * in ctx.
	 */
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
	 * Valutazione "declaration rule"
	 * <p>
	 * Regola "declaration : decFun | decVar ;"
	 *
	 * @param ctx Contesto in analisi.
	 * @return Ritorno di un oggetto in base a quanto valutato dall'analisi di ctx.
	 */
	// Declarations
	@Override
	public Node visitDeclaration(SimpLanPlusParser.DeclarationContext ctx) {
		if (ctx.decFun() != null) return visit(ctx.decFun());
		if (ctx.decVar() != null) return visit(ctx.decVar());

		//Non dovrei mai arrivare qui
		return null;
	}

	/**
	 * Valutazione "decFun rule"
	 * <p>
	 * Regola "decFun : (type | 'void') ID '(' (arg (',' arg)*)? ')' block ;"
	 *
	 * @param ctx Contesto in analisi.
	 * @return Ritorno di un oggetto in base a quanto valutato dall'analisi di ctx.
	 */
	@Override
	public Node visitDecFun(SimpLanPlusParser.DecFunContext ctx) {
		String ID = ctx.ID().getText();
		Node retType = null;
		Node block = visit(ctx.block());
		ArrayList<ArgNode> args = null;

		if (ctx.type() != null) retType = visit(ctx.type());
		else retType = new VoidTypeNode();

		if (ctx.arg() != null && !ctx.arg().isEmpty()) {
			args = new ArrayList<>();
			for (SimpLanPlusParser.ArgContext arg : ctx.arg()) {
				args.add(visitArg(arg));
			}
		}

		return new FunNode(retType, ID, args, block);
	}

	/**
	 * Valutazione "decVar rule"
	 * <p>
	 * Regola "decVar : type ID ('=' exp)? ';' ;"
	 *
	 * @param ctx Contesto in analisi.
	 * @return Ritorno di un oggetto in base a quanto valutato dall'analisi di ctx.
	 */
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

	/**
	 * Valutazione "type rule"
	 * <p>
	 * Regola "type : INTEGER | BOOLEAN;"
	 * <p>
	 * TODO: Ha senso avere due tipi diversi? Il prof li fa, potenzialmente basterebbe un typeNode
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo del tipo presente nel contesto (ctx) in esame
	 */
	@Override
	public Node visitType(SimpLanPlusParser.TypeContext ctx) {
		if (ctx.INTEGER() != null) return new IntTypeNode();
		if (ctx.BOOLEAN() != null) return new BoolTypeNode();
		return null;

	}

	/**
	 * Valutazione "arg rule"
	 * <p>
	 * Regola "arg : ('var')? type ID;"
	 * <p>
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo contenente le informazioni di un argomento
	 */
	@Override
	public ArgNode visitArg(SimpLanPlusParser.ArgContext ctx) {

		boolean byReference = ctx.VAR() != null; // TODO: Controllare se funziona
		String ID = ctx.ID().getText();
		Node type = visit(ctx.type());

		return new ArgNode(type, ID, byReference);
	}

	/**
	 * Valutazione "baseExp rule" (Expressions)
	 * <p>
	 * Regola "exp : '(' exp ')' #baseExp"
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo BaseExpNode dato dalla visita dell'espressione del contesto in analisi.
	 */
	@Override
	public Node visitBaseExp(SimpLanPlusParser.BaseExpContext ctx) {
		return new BaseExpNode(visit(ctx.exp()));
	}

	/**
	 * Valutazione "negExp rule" (Expressions)
	 * <p>
	 * Regola "exp : '-' exp #negExp"
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo NegExpNode dato dalla visita dell'espressione del contesto in analisi.
	 */
	@Override
	public Node visitNegExp(SimpLanPlusParser.NegExpContext ctx) {
		return new NegExpNode(visit(ctx.exp()));
	}

	/**
	 * Valutazione "notExp rule" (Expressions)
	 * <p>
	 * Regola "exp : '!' exp #notExp"
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo NotExpNode dato dalla visita dell'espressione del contesto in analisi.
	 */
	@Override
	public Node visitNotExp(SimpLanPlusParser.NotExpContext ctx) {
		return new NotExpNode(visit(ctx.exp()));
	}

	/**
	 * Valutazione "derExp rule" (Expressions)
	 * <p>
	 * Regola "ID #derExp"
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo DerExpNode dato dalla visita dell'espressione del contesto in analisi.
	 */
	@Override
	public Node visitDerExp(SimpLanPlusParser.DerExpContext ctx) {
		return new DerExpNode(ctx.ID().toString());
	}

	/**
	 * Valutazione "Arithm rule" (Expressions)
	 * <p>
	 * Regola "exp : left=exp op=('*' | '/')   right=exp #arithmExp
	 * | left=exp op=('+' | '-')               right=exp #arithmExp
	 * <p>
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo ArithmExp dato dalla struttura dell'espressione del contesto in analisi.
	 */
	@Override
	public Node visitArithmExp(SimpLanPlusParser.ArithmExpContext ctx) {
		Node left = visit(ctx.left);
		String op = ctx.op.getText();
		Node right = visit(ctx.right);
		return new ArithmExpNode(left, right, op);
	}

	/**
	 * Valutazione "compare rule" (Expressions)
	 * <p>
	 * Regola "exp :
	 * | left=exp op=('<' | '<=' | '>' | '>=') right=exp #compExp"
	 * <p>
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo CompExp dato dalla struttura dell'espressione del contesto in analisi.
	 */
	@Override
	public Node visitCompareExp(SimpLanPlusParser.CompareExpContext ctx) {
		Node left = visit(ctx.left);
		String op = ctx.op.getText();
		Node right = visit(ctx.right);
		return new CompareExpNode(left, right, op);
	}

	/**
	 * Valutazione "equal rule" (Expressions)
	 * <p>
	 * Regola "exp :
	 * | left=exp op=('=='| '!=')              right=exp #equalExp"
	 * <p>
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo EqualExp dato dalla struttura dell'espressione del contesto in analisi.
	 */
	@Override
	public Node visitEqualExp(SimpLanPlusParser.EqualExpContext ctx) {
		Node left = visit(ctx.left);
		String op = ctx.op.getText();
		Node right = visit(ctx.right);
		return new EqualExpNode(left, right, op);
	}

	/**
	 * Valutazione "logic rule" (Expressions)
	 * <p>
	 * Regola "exp :
	 * | left=exp op='&&'                      right=exp #logicExp
	 * | left=exp op='||'                      right=exp #logicExp"
	 * <p>
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo LogicExp dato dalla struttura dell'espressione del contesto in analisi.
	 */
	@Override
	public Node visitLogicExp(SimpLanPlusParser.LogicExpContext ctx) {
		Node left = visit(ctx.left);
		String op = ctx.op.getText();
		Node right = visit(ctx.right);
		return new LogicExpNode(left, right, op);
	}

	/**
	 * Valutazione "callExp rule" (Expressions)
	 * <p>
	 * Regola "exp : call #callExp"
	 * <p>
	 * TODO: Serve veramente la classe CallExpNode o potrei fare direttamente una return visit...
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo CallExpNode dato dalla visita della call del contesto in analisi.
	 */
	@Override
	public Node visitCallExp(SimpLanPlusParser.CallExpContext ctx) {
		return new CallExpNode(visit(ctx.call()));
	}

	/**
	 * Valutazione "boolExp rule" (Expressions)
	 * <p>
	 * Regola "exp : BOOL #boolExp"
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo BoolExpNode dato dal valore registrato nel contesto.
	 */
	@Override
	public Node visitBoolExp(SimpLanPlusParser.BoolExpContext ctx) {
		String val = ctx.BOOL().toString();
		return new BoolExpNode(val.equals("true"));
	}

	/**
	 * Valutazione "valExp rule" (Expressions)
	 * <p>
	 * Regola "exp : NUMBER	#valExp"
	 *
	 * @param ctx Contesto di analisi
	 * @return Ritorno di un nodo ValExpNode dato dal valore registrato nel contesto.
	 */
	@Override
	public Node visitValExp(SimpLanPlusParser.ValExpContext ctx) {
		String valS = ctx.NUMBER().toString();
		int val = Integer.parseInt(valS);
		return new ValExpNode(val);
	}
}
