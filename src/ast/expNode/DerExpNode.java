package ast.expNode;

import ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class DerExpNode implements Node {
	private final String ID;

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
		return null;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		if (env.symbolTable.findFirstInSymbolTable(ID) == null) {
			errors.add(new SemanticError("Var " + ID + " not declared."));
		}

		return errors;
	}
}
