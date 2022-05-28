package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.STentry;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class DerExpNode implements Node {
	private final String ID;
	private STentry entry;
	private int nestingLevel;

	public DerExpNode(String ID) {
		this.ID = ID;
	}

	@Override
	public String toPrint(String indent) {
		return indent + " DER: " + ID;
	}


	@Override
	public Node typeCheck() {
		return null;
	}

	@Override
	public String codeGeneration() {
		return "TODO: DerExp" + ID + "\n";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		entry = env.symbolTable.findFirstInSymbolTable(ID);
		nestingLevel = env.nestingLevel;
		if (entry == null) {
			errors.add(new SemanticError("Var " + ID + " not declared."));
		}

		return errors;
	}
}
