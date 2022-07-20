package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class PrintNode implements Node {
	private final Node exp;
	private TypeNode type;

	public PrintNode(Node exp) {
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "print: " + exp.toPrint(indent);
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		type = exp.typeCheck(symbolTable);
		return new VoidTypeNode();
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		return exp.checkSemantics(env, symbolTable);
	}

	@Override
	public String codeGeneration() {

		return "; Print \n" + exp.codeGeneration() +
				(SLPUtils.checkIntType(type) ? "printw" : "printb") + " $t0\n";
	}
}
