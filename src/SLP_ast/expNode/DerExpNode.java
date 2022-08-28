package SLP_ast.expNode;

import SLP_ast.Node;
import SLP_ast.STentry;
import SLP_ast.typeNode.FunctionSingatureType;
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
	private int[] stOccupiedBytes;

	public DerExpNode(String ID) {
		this.ID = ID;
		stOccupiedBytes = null;
	}

	@Override
	public ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable) {
		ArrayList<SemanticError> errors = new ArrayList<>();

		entry = symbolTable.findFirstInSymbolTable(ID);
		nestingLevel = Environment.getNestingLevel();

		if (entry == null) {
			errors.add(new SemanticError("Var " + ID + " not declared."));
		} else if (entry.getType() instanceof FunctionSingatureType) {
			errors.add(new SemanticError("Var " + ID + " is a function."));
		}

		// If the nesting levels are different, the variable is not in the same scope.
		if (entry != null && nestingLevel != entry.getNestinglevel()) {
			// Evaluate the difference between the two nesting levels.
			int nEnvs = nestingLevel - entry.getNestinglevel();

			stOccupiedBytes = new int[nEnvs];

			// For each environment between the two nesting levels, get the number of bytes occupied by the variables.
			for (int i = 0; i < nEnvs; i++) {
				stOccupiedBytes[i] = symbolTable.nestingLevelRequiredBytes(nestingLevel-i);
			}

		}

		return errors;
	}

	@Override
	public TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError {
		// Save the STEntry
		entry = symbolTable.findInSymbolTable(ID, entry.getNestinglevel());
		if (entry == null) {
			throw new SLPUtils.TypeCheckError("Variable not declared: " + ID + ".");
		}

		if (entry.getEffect() == STentry.Effects.DECLARED || entry.getEffect() == STentry.Effects.NONE) {
			throw new SLPUtils.TypeCheckError("Variable not initialized: " + ID + ".");
		} else if (entry.getEffect() != STentry.Effects.USED) entry.setEffect(STentry.Effects.USED);

		return entry.getType();
	}

	@Override
	public String codeGeneration(String options) {
		StringBuilder out = new StringBuilder();

		out.append("; Begin load variable ").append(ID).append("\n");

		out.append("mov $t1 $fp\n");

		// If the nesting levels are different, the variable is not in the same scope.
		if (entry != null && nestingLevel != entry.getNestinglevel()) {
			// For each environment between the two nesting levels, use the number of occupied bytes to jump to the previous environment.
			for (int i = 0; i < stOccupiedBytes.length; i++) {
				out.append("lw $t1 ").append(stOccupiedBytes[i] + 1).append("($t1)\n");
			}
		}

		if (options != null && options.equalsIgnoreCase("getAddress")) {
			// Se la variabile in esame (entry) è già un puntatore, allora carico in $t0 l'indirizzo a cui punta il puntatore attuale
			if (entry.isReference()) out.append("lw $t0 ").append(entry.getOffset()).append("($t1)\n");
				// Altrimenti calcolo l'indirizzo a cui deve puntare e lo salvo in $t0
			else out.append("addi $t0 $t1 ").append(entry.getOffset()).append("\n");
		} else {
			if (entry.isReference()) {
				// Se la variabile in esame (entry) è un puntatore, carico in $t0 l'indirizzo a cui punta e, in seguito carico il valore contenuto nella cella puntata.
				out.append("lw $t0 ").append(entry.getOffset()).append("($t1)\n");
				out.append(SLPUtils.checkIntType(entry.getType()) ? "lw" : "lb").append(" $t0 0($t0)\n");
			} else
				out.append(SLPUtils.checkIntType(entry.getType()) ? "lw" : "lb").append(" $t0 ").append(entry.getOffset()).append("($t1)\n");
		}

		out.append("; End load variable ").append(ID).append("\n");

		return out.toString();
	}
}