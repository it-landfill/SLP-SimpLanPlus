package util;

import java.util.ArrayList;
import java.util.HashMap;

import ast.STentry;

public class Environment {
	// FIXME: Migliorare il livello di visibilità (Non dovrebbe essere public)

	// Symbol Table (Secondo esercizio)
	// TODO: Si può fare con stack?
	public ArrayList<HashMap<String, STentry>> symTable = new ArrayList<HashMap<String, STentry>>();

	//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle è symTable.get(nestingLevel)
	public int nestingLevel = -1;

	// Non si sa bene la sua utilità.
	public int offset = 0;

	// Tiene traccia della funzione di cui stiamo analizzando il body
	public String baseFun = null;

	public HashMap<String, STentry> getCurrentLevelSymTable() {
		return symTable.get(nestingLevel);
	}
}
