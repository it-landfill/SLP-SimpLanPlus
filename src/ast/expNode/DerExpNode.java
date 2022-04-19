package ast.expNode;

import ast.Node;
import ast.STentry;
import org.stringtemplate.v4.STErrorListener;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

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
		ArrayList<SemanticError> errors =   new ArrayList<>();

		STentry idEntry = STentry.findEntry(ID,env);

		if (idEntry == null) {
			errors.add(new SemanticError("Var  " + ID + " not declared."));
		}

		return errors;
	}
}
