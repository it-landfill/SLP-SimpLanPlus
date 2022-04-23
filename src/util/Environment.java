package util;

import java.util.*;

import ast.STentry;

public class Environment {

	// Generazione della Symbol Table
	public SymbolTableWrapper symbolTable;

	// Variabile utilizzata dall'interprete.
	public int offset;
	// Tiene traccia della funzione di cui stiamo analizzando il body
	public String baseFun;
	// Livello di nesting dell'enviroment attuale
	public int nestingLevel;

	public Environment() {
		this.symbolTable = new SymbolTableWrapper();
		this.offset = 0;
		this.baseFun = null;
		this.nestingLevel = -1;
	}
}
