package util;

import java.util.ArrayList;
import java.util.HashMap;

import ast.STentry;

public class Environment {
	// FIXME: Migliorare il livello di visibilità (Non dovrebbe essere public)

	// Symbol Table (Secondo esercizio)
	public ArrayList<HashMap<String, STentry>> symTable = new ArrayList<HashMap<String, STentry>>();

	//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle è symTable.get(nestingLevel)
	public int nestingLevel = -1;

	// Non si sa bene la sua utilità.
	public int offset = 0;
}
