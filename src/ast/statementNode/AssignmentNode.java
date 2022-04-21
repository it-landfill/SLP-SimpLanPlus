package ast.statementNode;

import ast.Node;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class AssignmentNode implements Node {
	private final String ID;
	private final Node exp;

	public AssignmentNode(String ID, Node exp) {
		this.ID = ID;
		this.exp = exp;
	}

	@Override
	public String toPrint(String indent) {
		return indent + "assignment: " + ID + " " + exp.toPrint(indent);
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
		ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

		if (env.symbolTable.findFirstInSymbolTable(ID) == null) {
			errors.add(new SemanticError("Var " + ID + " not declared."));
		}

		errors.addAll(exp.checkSemantics(env));

		return errors;
	}
}
