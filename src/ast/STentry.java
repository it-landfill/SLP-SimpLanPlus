package ast;

import util.Environment;

import java.util.HashMap;

public class STentry {

	private final int nl;     // Nesting Level
	private Node type;  // Tipo della variabile?
	private int offset; // "sarà utile per l'interprete"
	private int nArgs;

	public STentry(int n, int os) {
		nl = n;
		offset = os;
		nArgs = -1;
	}

	public STentry(int n, Node t, int os) {
		nl = n;
		type = t;
		offset = os;
		nArgs = -1;
	}

	public int getnArgs() {
		return nArgs;
	}

	public void setnArgs(int nArgs) {
		this.nArgs = nArgs;
	}

	public void addType(Node t) {
		type = t;
	}

	public Node getType() {
		return type;
	}

	public int getOffset() {
		return offset;
	}

	public int getNestinglevel() {
		return nl;
	}

	public String toPrint(String s) {
		return s + "STentry: nestlev " + Integer.toString(nl) + "\n" +
				s + "STentry: type\n" +
				type.toPrint(s + "  ") +
				s + "STentry: offset " + Integer.toString(offset) + "\n";
	}

	public static STentry findEntry(String entryName, Environment env) {

		int entryLev = findEntryLevel(entryName,env);
		if (entryLev == -1) return null;

		HashMap<String, STentry> hm = env.symTable.get(entryLev);

		return hm.getOrDefault(entryName,null);
	}

	public static int findEntryLevel(String entryName, Environment env) {
		HashMap<String, STentry> hm;

		STentry idEntry = null;

		// Cerco la funzione nei livelli superiori
		int nl = env.nestingLevel;
		while (idEntry == null && nl>=0) {
			hm = env.symTable.get(nl--);
			idEntry = hm.getOrDefault(entryName,null);
		}

		return nl;
	}
}  