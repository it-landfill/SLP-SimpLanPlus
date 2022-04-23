package ast;
public class STentry {

	private final int nl;     // Nesting Level
	private final int offset; // "sarà utile per l'interprete"
	private final String ID; // Servirà in futuro per la mutua ricorsione
	private Node type;  // Tipo della variabile
	private int nArgs; //Se si tratta di una funzione rappresenta il numero di argomenti, altrimenti è -1

	// TODO: Da eliminare creando un tipo "void"
	public STentry(int n, int os, String ID) {
		nl = n;
		offset = os;
		nArgs = -1;
		this.ID = ID;
	}

	public STentry(int n, Node t, int os, String ID) {
		nl = n;
		type = t;
		offset = os;
		nArgs = -1;
		this.ID = ID;
	}

	public int getnArgs() {
		return nArgs;
	}

	public void setnArgs(int nArgs) {
		this.nArgs = nArgs;
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

	public String getID() {
		return ID;
	}

	/**
	 * Funzione che ritorna la String contenente le informazioni di una entry della symbol table.
	 * @return String
	 */
	public String toPrint(String s) {
		return s + "STentry: ID " + ID + "\n" + s + "STentry: nestlev " + nl + "\n" + s + "STentry: type" + (type == null ? " void " : type.toPrint(s + "  ")) + "\n" + s + "STentry: offset " + offset + "\n";
	}
}  