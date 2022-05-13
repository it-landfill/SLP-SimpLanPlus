package SLP_ast.expNode;

import SLP_ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class DerExpNode implements Node {
	private final String ID;
	//TODO: private STEntry entry - Il prof tiene traccia della STEntry qua dentro e la inizializza in check semantics

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

		if (env.symbolTable.findFirstInSymbolTable(ID) == null) {
			errors.add(new SemanticError("Var " + ID + " not declared."));
		}
		// Il prof se trova una entry la salva nella variabile entry.

		return errors;
	}
}
