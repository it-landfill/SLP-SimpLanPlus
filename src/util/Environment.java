package util;

import java.util.*;

import ast.STentry;

public class Environment {

	// Symbol Table (Secondo esercizio)
	public SymbolTableWrapper symbolTable;

	// Non si sa bene la sua utilità.
	public int offset;
	// Tiene traccia della funzione di cui stiamo analizzando il body
	public String baseFun;
	//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle è symTable.get(nestingLevel)
	public int nestingLevel;

	public Environment() {
		this.symbolTable = new SymbolTableWrapper();
		this.offset = 0;
		this.baseFun = null;
		this.nestingLevel = -1;
	}
}
