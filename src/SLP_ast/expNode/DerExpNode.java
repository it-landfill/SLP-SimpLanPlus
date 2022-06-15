package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.STentry;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;

import java.util.ArrayList;

public class DerExpNode implements Node {
	private final String ID;
	private STentry entry;
	private int nestingLevel;

	public DerExpNode(String ID) {
		this.ID = ID;
	}

	@Override
	public String toPrint(String indent) {
		return indent + " DER: " + ID;
	}


	@Override
	public TypeNode typeCheck() throws SLPUtils.TypeCheckError {
		if (entry == null) {
			System.out.println("L'ID richiamato non risulta essere dichiarato.");
			throw new SLPUtils.TypeCheckError("L'ID richiamato (" + ID + ") non risulta essere dichiarato.");
		}

		if (entry.getEffect() == STentry.Effects.DECLARED || entry.getEffect() == STentry.Effects.NONE) {
			throw new SLPUtils.TypeCheckError("L'ID richiamato (" + ID + ") non risulta essere inizializzato.");
		} else if (entry.getEffect() != STentry.Effects.USED) entry.setEffect(STentry.Effects.USED);

		return entry.getType();
	}

	@Override
	public String codeGeneration() {
		return "";
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		entry = env.symbolTable.findFirstInSymbolTable(ID);
		nestingLevel = env.nestingLevel;
		if (entry == null) {
			errors.add(new SemanticError("Var " + ID + " not declared."));
		}

		return errors;
	}
}
