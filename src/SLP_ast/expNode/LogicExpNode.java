package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class LogicExpNode implements Node {
	private final Node left;
	private final Node right;
	private final String op;

	public LogicExpNode(Node left, Node right, String op) {
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "LogicExp: " + left.toPrint(indent) + " op: " + op + right.toPrint(indent);
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		if (!(SLPUtils.checkBoolType(left.typeCheck(symbolTable)) && SLPUtils.checkBoolType(right.typeCheck(symbolTable)))) {
			throw new SLPUtils.TypeCheckError("Un termine dell'operazione logica (&&, ||) non è di tipo corretto.");
		}
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration() {
		StringBuilder sb = new StringBuilder();

		sb.append(left.codeGeneration());
		sb.append("push $t0\n");
		sb.append(right.codeGeneration());
		sb.append("pop $t1\n");
		switch(op) {
			case "&&" -> sb.append("and");
			case "||" -> sb.append("or");
		}
		sb.append(" $t0 $t0 $t1\n");

		return sb.toString();
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		errors.addAll(left.checkSemantics(env, symbolTable));
		errors.addAll(right.checkSemantics(env, symbolTable));

		return errors;
	}
}