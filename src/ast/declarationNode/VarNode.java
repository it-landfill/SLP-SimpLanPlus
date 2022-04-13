package ast.declarationNode;

import ast.Node;
import ast.STentry;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class VarNode implements Node {
	private final String ID;
	private final Node type;
	private final Node exp;

	public VarNode(String ID, Node type, Node exp) {
		this.ID = ID;
		this.type = type;
		this.exp = exp;
	}

	public VarNode(String ID, Node type) {
		this.ID = ID;
		this.type = type;
		this.exp = null;
	}

	@Override
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();
		out.append(indent).append("var: ").append(type.toPrint(indent)).append(" ").append(ID);
		if (exp != null) out.append(" ").append(exp.toPrint(indent));
		return out.toString();
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
		HashMap<String, STentry> hm = env.getCurrentLevelSymTable();
		ArrayList<SemanticError> errors = new ArrayList<>();

		STentry entry = new STentry(env.nestingLevel,type,env.offset);

		if(hm.put(ID,entry) != null) errors.add(new SemanticError("Var id "+ID+" already declared"));

		if (exp != null) errors.addAll(exp.checkSemantics(env));

		return errors;
	}
}
