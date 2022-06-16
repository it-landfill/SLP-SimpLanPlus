package SLP_ast.statementNode;

import SLP_ast.Node;
import SLP_ast.STentry;
import SLP_ast.typeNode.TypeNode;
import SLP_ast.typeNode.VoidTypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class AssignmentNode implements Node {
	private final String ID;
	private STentry entry;
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
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		entry = symbolTable.findInSymbolTable(ID, entry.getNestinglevel()); // Mi serve perchè copio le symbolTable
		if (entry == null) {
			throw new SLPUtils.TypeCheckError("L'ID richiamato non risulta essere dichiarato.");
		}

		if (!(SLPUtils.checkTypes(exp.typeCheck(symbolTable), entry.getType()))) {
			throw new SLPUtils.TypeCheckError("Al asgm (=) non sono associati i tipi corretti.");
		}

		if (entry.getEffect() == STentry.Effects.DECLARED) entry.setEffect(STentry.Effects.INITIALIZED);

		return new VoidTypeNode();
	}

	@Override
	public String codeGeneration() {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

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
