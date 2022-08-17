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
		TypeNode leftType = left.typeCheck(symbolTable);
		TypeNode rightType = right.typeCheck(symbolTable);
		if (!(SLPUtils.checkBoolType(leftType) && SLPUtils.checkBoolType(rightType))) {
			throw new SLPUtils.TypeCheckError("Bool expression expected for logic operators. Got " + leftType + op + rightType + ".");
		}
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration(String options) {
		StringBuilder sb = new StringBuilder();

		sb.append(left.codeGeneration(options));
		sb.append("pushb $t0\n");
		sb.append(right.codeGeneration(options));
		sb.append("popb $t1\n");
		switch (op) {
			case "&&" -> sb.append("and");
			case "||" -> sb.append("or");
		}
		sb.append(" $t0 $t1 $t0\n");

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