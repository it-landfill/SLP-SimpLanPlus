package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.typeNode.IntTypeNode;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class NegExpNode implements Node {

	private final Node exp;

	public NegExpNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent) {
		return indent + " negative: " + exp.toString();
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		if (!SLPUtils.checkIntType(exp.typeCheck(symbolTable))) {
			throw new SLPUtils.TypeCheckError("Al neg (-) non è associato un tipo integer.");
		}
		return new IntTypeNode();
	}

	@Override
	public String codeGeneration(String options) {
		return exp.codeGeneration(options) + "neg $t0 $t0\n";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		return exp.checkSemantics(env, symbolTable);
	}
}
