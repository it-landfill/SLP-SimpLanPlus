package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.IntTypeNode;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class ArithmExpNode implements Node {
	private final Node left;
	private final Node right;
	private final String op;

	public ArithmExpNode(Node left, Node right, String op) {
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "AritmExp: " + left.toPrint(indent) + " op: " + op + right.toPrint(indent)+"\n";
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		if (! ( SLPUtils.checkIntType(left.typeCheck(symbolTable)) &&
				SLPUtils.checkIntType(right.typeCheck(symbolTable)) ) ) {
			throw new SLPUtils.TypeCheckError("Un termine dell'operazione aritmetica (+, -, *, /) non è di tipo corretto.");
		}
		return new IntTypeNode();
	}

	@Override
	public String codeGeneration() {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		errors.addAll(left.checkSemantics(env));
		errors.addAll(right.checkSemantics(env));

		return errors;
	}
}