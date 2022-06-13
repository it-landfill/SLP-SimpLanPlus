package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.STentry;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class AssignmentNode implements Node {
	private final String ID;
	private final Node exp;
	private int nestinglevel;
	private STentry entry;

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
		StringBuilder out = new StringBuilder();

		out.append(exp.codeGeneration());
		out.append("move $t1 $fp\n"); //TODO: FP o SP??????
		out.append("lw $t1 0($t1)\n".repeat(nestinglevel - entry.getNestinglevel()));
		out.append("sw $t0 ").append(entry.getOffset()).append("($t1)\n");

		return out.toString();
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();
		nestinglevel = env.nestingLevel;
		entry = env.symbolTable.findFirstInSymbolTable(ID);
		if (entry == null) {
			errors.add(new SemanticError("Var " + ID + " not declared."));
		} else if(entry.getnArgs()!=-1) {
			errors.add(new SemanticError(ID + " is a function, not a variable. You can't assign value to a function."));
		}

		errors.addAll(exp.checkSemantics(env));

		return errors;
	}
}
