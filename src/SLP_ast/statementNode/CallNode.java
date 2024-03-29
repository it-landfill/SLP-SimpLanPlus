package SLP_ast.statementNode;

import SLP_ast.ArgNode;
import SLP_ast.Node;
import SLP_ast.STentry;
import SLP_ast.expNode.DerExpNode;
import SLP_ast.typeNode.FunctionSingatureType;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class CallNode implements Node {
	private final String funcName;
	private final ArrayList<Node> actualParams;
	private boolean expNode;
	private FunctionSingatureType signature;

	public CallNode(String funcName, ArrayList<Node> params) {
		this.funcName = funcName;
		this.expNode = false;
		this.actualParams = params;
	}

	public CallNode(String funcName) {
		this(funcName, null);
	}

	public void setExpNode(boolean expNode) {
		this.expNode = expNode;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		STentry entry = symbolTable.findFirstInSymbolTable(funcName);

		if (entry == null) {
			errors.add(new SemanticError("Fun " + funcName + " does not exist in scope."));
		} else {
			// If the type is not function signature type, then entry is a variable.
			if (!(entry.getType() instanceof FunctionSingatureType)) {
				errors.add(new SemanticError("Fun " + funcName + " is not a function."));
				return errors;
			}

			signature = (FunctionSingatureType) entry.getType();

			ArrayList<ArgNode> formalParams = signature.getArguments();

			if (actualParams != null) {
				if (formalParams == null || formalParams.size() != actualParams.size()) {
					errors.add(new SemanticError("Parameter number for " + funcName + " does not match. Expected " + (formalParams == null ? 0 : formalParams.size()) + ". Have " + actualParams.size() + "."));
				}
			} else {
				if (formalParams != null && formalParams.size() != 0) {
					errors.add(new SemanticError("Parameter number for " + funcName + " does not match. Expected " + formalParams.size() + ". Have 0."));
				}
			}
		}

		if (actualParams != null) {
			for (Node n : actualParams) {
				errors.addAll(n.checkSemantics(env, symbolTable));
			}
		}

		return errors;
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		STentry entry = symbolTable.findFirstInSymbolTable(funcName);

		FunctionSingatureType signature = (FunctionSingatureType) entry.getType();

		if (actualParams != null) {
			ArrayList<ArgNode> formalParams = signature.getArguments();
			Node pa;
			ArgNode pf;
			TypeNode ta, tf;
			for (int i = 0; i < actualParams.size(); i++) {
				pa = actualParams.get(i);
				pf = formalParams.get(i);
				ta = pa.typeCheck(symbolTable);
				tf = pf.typeCheck(symbolTable);

				if (pf.isByReference() && !(pa instanceof DerExpNode))
					throw new SLPUtils.TypeCheckError("In function call " + entry.getID() + ", parameter " + pf.getArgName() + " should be a variable (parameter is set as var in function declaration).");
				if (!SLPUtils.checkTypes(ta, tf))
					throw new SLPUtils.TypeCheckError("In function call " + entry.getID() + ", parameter " + pf.getArgName() + " should be " + tf + ", type found: " + ta + ".");
			}
		}

		return (expNode ? signature.getReturnType() : new VoidTypeNode());
	}

	@Override
	public String codeGeneration(String options) {
		StringBuilder sb = new StringBuilder();

		sb.append("; Begin function call ").append(expNode ? "with return " : "").append(funcName).append("\n");
		sb.append("pushw $fp\n");
		if (actualParams != null) {
			for (int i = actualParams.size() - 1; i >= 0; i--) {
				ArgNode arg = signature.getArguments().get(i);
				sb.append("; Saving actual parameter ").append(arg.isByReference() ? "by reference " : "").append(arg.getArgName()).append("\n");
				if (arg.isByReference()) {
					sb.append(actualParams.get(i).codeGeneration("getAddress"));
					sb.append("pushw $t0\n");
				} else {
					sb.append(actualParams.get(i).codeGeneration(options));
					sb.append(SLPUtils.checkIntType(arg.getType()) ? "pushw" : "pushb").append(" $t0\n");
				}
			}
		}
		sb.append("jal ").append(signature.getLabel()).append("\n");
		sb.append("; End function call ").append(expNode ? "with return " : "").append(funcName).append("\n");

		return sb.toString();
	}

}
