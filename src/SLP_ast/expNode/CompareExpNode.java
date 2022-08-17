package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class CompareExpNode implements Node {
	private final Node left;
	private final Node right;
	private final String op;

	public CompareExpNode(Node left, Node right, String op) {
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "CompareExp: " + left.toPrint(indent) + " op: " + op + right.toPrint(indent);
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		errors.addAll(left.checkSemantics(env, symbolTable));
		errors.addAll(right.checkSemantics(env, symbolTable));

		return errors;
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		TypeNode leftType = left.typeCheck(symbolTable);
		TypeNode rightType = right.typeCheck(symbolTable);
		if (!(SLPUtils.checkIntType(leftType) && SLPUtils.checkIntType(rightType))) {
			throw new SLPUtils.TypeCheckError("Int expression expected for compare operators. Got " + leftType + op + rightType + ".");
		}
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration(String options) {
		StringBuilder sb = new StringBuilder();

		sb.append(left.codeGeneration(options));
		sb.append("pushw $t0\n");
		sb.append(right.codeGeneration(options));
		sb.append("popw $t1\n");
		switch (op) {
			case "<" -> sb.append("lt");
			case "<=" -> sb.append("lte");
			case ">" -> sb.append("gt");
			case ">=" -> sb.append("gte");
		}
		sb.append(" $t0 $t1 $t0\n");

		return sb.toString();
	}
}