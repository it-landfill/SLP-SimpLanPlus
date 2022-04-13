package ast.statementNode;

import ast.Node;
import ast.STentry;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class CallNode implements Node {
	private final String funcName;
	private final ArrayList<Node> params;

	public CallNode(String funcName, ArrayList<Node> params) {
		this.funcName = funcName;
		this.params = params;
	}

	public CallNode(String funcName) {
		this.funcName = funcName;
		params = null;
	}

	@Override
	public String toPrint(String indent) {
		StringBuilder out = new StringBuilder();

		out.append(indent).append("call").append(funcName);

		if (params!=null && !params.isEmpty()) {
			out.append(" params ");
			for (Node n : params) {
				out.append(n.toPrint(indent));
			}
		}

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
		 ArrayList<SemanticError> errors = new ArrayList<>();
		 HashMap<String, STentry> hm = env.getCurrentLevelSymTable();

		 STentry f = null;

		 int nl = env.nestingLevel;
		 while (f == null && nl>=0) {
			 hm = env.symTable.get(nl--);
			 f = hm.getOrDefault(funcName,null);
		 }

		 if (f == null) {
			 errors.add(new SemanticError("Fun " + funcName + " does not exist in scope"));
		 } else {
			 if (f.getnArgs() == -1) {
				 errors.add(new SemanticError("Fun " + funcName + " is not a function"));
			 }
			 if (params != null) {
				 if (f.getnArgs() != params.size()) {
					 errors.add(new SemanticError("Parameter number for " + funcName + " does not match. Expected " + f.getnArgs() + ". Have" + params.size()));
				 }
			 } else {
				 if (f.getnArgs() != 0) {
					 errors.add(new SemanticError("Parameter number for " + funcName + " does not match. Expected " + f.getnArgs() + ". Have 0"));
				 }
			 }
		 }

		if (params != null) {
			for (Node n : params) {
				errors.addAll(n.checkSemantics(env));
			}
		}
		return errors;
	}
}
