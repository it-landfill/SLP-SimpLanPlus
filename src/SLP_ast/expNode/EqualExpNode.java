package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.BoolTypeNode;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class EqualExpNode implements Node {
	private final Node left;
	private final Node right;
	private final String op;
	private TypeNode type;

	public EqualExpNode(Node left, Node right, String op) {
		this.left = left;
		this.right = right;
		this.op = op;
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
		if (!SLPUtils.checkTypes(leftType, rightType)) {
			throw new SLPUtils.TypeCheckError("Type mismatch between \"arg1\" and \"arg2\". Got " + leftType + op + rightType + ".");
		}
		type = leftType;
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration(String options) {
		StringBuilder sb = new StringBuilder();
		boolean isInt = SLPUtils.checkIntType(type);

		sb.append(left.codeGeneration(options));
		sb.append(isInt ? "pushw" : "pushb").append(" $t0\n");
		sb.append(right.codeGeneration(options));
		sb.append(isInt ? "popw" : "popb").append(" $t1\n");
		switch (op) {
			case "==" -> sb.append("eq");
			case "!=" -> sb.append("neq");
		}
		sb.append(" $t0 $t1 $t0\n");

		return sb.toString();
	}

}