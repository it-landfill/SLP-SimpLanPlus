package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.STentry;
import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public class DerExpNode implements Node {
	private final String ID;
	private STentry entry;
	private int nestingLevel;
	private int stOccupiedBytes;

	public DerExpNode(String ID) {
		this.ID = ID;
	}

	@Override
	public String toPrint(String indent) {
		return indent + " DER: " + ID;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		entry = symbolTable.findFirstInSymbolTable(ID);
		nestingLevel = Environment.getNestingLevel();
		if (entry == null) {
			errors.add(new SemanticError("Var " + ID + " not declared."));
		}

		stOccupiedBytes =  symbolTable.nestingLevelRequiredBytes(Environment.getNestingLevel());

		return errors;
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		entry = symbolTable.findInSymbolTable(ID, entry.getNestinglevel()); // Mi serve perchè copio le symbolTable
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
	public String codeGeneration(String options) {
		StringBuilder out = new StringBuilder();

		out.append("; Begin load variable ").append(ID).append("\n");

		// Parte comune, risalgo la catena di fp
		out.append("mov $t1 $fp\n");
		out.append(("lw $t1 " + stOccupiedBytes + 4 + "($t1)\n").repeat(nestingLevel - entry.getNestinglevel()));

		if (options != null && options.equalsIgnoreCase("getAddress")){
			// Se la variabile in esame (entry) è già un puntatore, allora carico in $t0 l'indirizzo a cui punta il puntatore attuale
			if (entry.isReference()) out.append("lw $t0 ").append(entry.getOffset()).append("($t1)\n");
			// Altrimenti calcolo l'indirizzo a cui deve puntare e lo salvo in $t0
			else out.append("addi $t0 $t1 ").append(entry.getOffset()).append("\n");
		} else {
			if (entry.isReference()) {
				// Se la variabile in esame (entry) è un puntatore, carico in $t0 l'indirizzo a cui punta e, in seguito carico il valore contenuto nella cella puntata.
				out.append("lw $t0 ").append(entry.getOffset()).append("($t1)\n");
				out.append(SLPUtils.checkIntType(entry.getType()) ? "lw" : "lb").append(" $t0 0($t0)\n");
			} else out.append(SLPUtils.checkIntType(entry.getType()) ? "lw" : "lb").append(" $t0 ").append(entry.getOffset()).append("($t1)\n");
		}

		out.append("; End load variable ").append(ID).append("\n");

		return out.toString();
	}
}
