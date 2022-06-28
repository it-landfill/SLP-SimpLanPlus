package util;

public class Environment {

    // Variabile utilizzata dall'interprete.
    private int offset;
    // Livello di nesting dell'enviroment attuale
    private static int nestingLevel = -1;

    public Environment() {
        this.offset = 1;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void offsetAddInt() {
        this.offset+=4;
    }

    public void offsetAddBool() {
        this.offset+=1;
    }

    public int getNestingLevel() {
        return nestingLevel;
    }

    public static void setNestingLevel(int nl) {
        nestingLevel = nl;
    }

    public static void incrementNestingLevel() {
        nestingLevel++;
    }

    public static void decrementNestingLevel() {
        nestingLevel--;
    }
}