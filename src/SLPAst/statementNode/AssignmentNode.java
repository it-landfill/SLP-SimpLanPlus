package SLPAst.statementNode;

import SLPAst.Node;
import SLPAst.STentry;
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
		return exp.codeGeneration() + "TODO: Assignment";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		STentry entry = env.symbolTable.findFirstInSymbolTable(ID);
		if (entry == null) {
			errors.add(new SemanticError("Var " + ID + " not declared."));
		} else if(entry.getnArgs()!=-1) {
			errors.add(new SemanticError(ID + " is a function, not a variable. You can't assign value to a function."));
		}

		errors.addAll(exp.checkSemantics(env));

		return errors;
	}
}
