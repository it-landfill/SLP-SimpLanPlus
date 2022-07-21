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

    // TODO: COmment
    private Effects effect;
    private final boolean isReference;

    public STentry(int n, TypeNode t, int os, String ID, Effects effect, boolean isReference) {
        nl = n;
        type = t;
        offset = os;
        this.ID = ID;
        this.effect = effect;
        this.isReference = isReference;
    }

    public STentry(int n, TypeNode t, int os, String ID, Effects effect) {
        this(n, t, os, ID, effect, false);
    }

    public boolean isReference() {
        return isReference;
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

    public STentry clone() {
        return new STentry(nl, type, offset, ID, effect, isReference);
    }
}  