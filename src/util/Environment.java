package util;

public class Environment {

    // Generazione della Symbol Table
    public SymbolTableWrapper symbolTable;

    // Variabile utilizzata dall'interprete.
    public int offset;
    // Livello di nesting dell'enviroment attuale
    public int nestingLevel;

    public Environment() {
        this.symbolTable = new SymbolTableWrapper();
        this.offset = 0;
        this.nestingLevel = -1;
    }

    public Environment(int offset, int nestingLevel) {
        this.symbolTable = new SymbolTableWrapper();
        this.offset = offset;
        this.nestingLevel = nestingLevel;
    }
}
