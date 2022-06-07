package SLP_ast;

import SLP_ast.typeNode.TypeNode;

public class STentry {

    public enum Effects {
        NONE,
        DECLARED,
        INITIALIZED,
        USED
    }

    // Nesting Level
    private final int nl;
    // "sarà utile per l'interprete"
    private final int offset;
    // Servirà in futuro per la mutua ricorsione
    private final String ID;
    // Tipo della variabile
    private final TypeNode type;
    //Se si tratta di una funzione rappresenta il numero di argomenti, altrimenti è -1
    private int nArgs;
    // TODO: COmment
    private Effects effect;

    public STentry(int n, TypeNode t, int os, String ID, Effects effect) {
        nl = n;
        type = t;
        offset = os;
        nArgs = -1;
        this.ID = ID;
        this.effect = effect;
    }

    public int getnArgs() {
        return nArgs;
    }

    public void setnArgs(int nArgs) {
        this.nArgs = nArgs;
    }

    public TypeNode getType() {
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

    public Effects getEffect() {
        return effect;
    }

    public void setEffect(Effects effect) {
        this.effect = effect;
    }

    /**
     * Funzione che ritorna la String contenente le informazioni di una entry della symbol table.
     *
     * @return String
     */
    public String toPrint(String s) {
        return s + "STentry: ID " + ID + "\n" + s + "STentry: nestlev " + nl + "\n" + s + "STentry: type" + (type == null ? " void " : type.toPrint(s + "  ")) + "\n" + s + "STentry: offset " + offset + "\n";
    }
}  