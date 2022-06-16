package util;

import SLP_ast.STentry;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class SymbolTableWrapper {
    // Creazione di una Hash Table (la Symbol Table) avente come chiave una String e un ArrayDeque di STentry
    private final HashMap<String, ArrayDeque<STentry>> symbolTable;

    public SymbolTableWrapper() {
        symbolTable = new HashMap<>();
    }

    public SymbolTableWrapper(HashMap<String, ArrayDeque<STentry>> st) {

        symbolTable = new HashMap<>();

        st.forEach((k, v) -> {
            ArrayDeque<STentry> newAl = new ArrayDeque<>();
            v.forEach(el -> newAl.add(el.clone()));
            symbolTable.put(k,newAl);
        });

    }

    /**
     * Controlla se l'elemento esiste nella symbol table allo stesso livello, altrimenti lo aggiunge.
     *
     * @param entry La entry da aggiungere alla Symbol Table
     * @return true in caso di errore, false altrimenti
     */
    public boolean addToSymbolTable(STentry entry) {
        // Ricerca dell'entry in input  nell'Hash Map. In caso di ricerca senza successo ritorno null.
        ArrayDeque<STentry> entryStack = symbolTable.getOrDefault(entry.getID(), null);

        // Se l'elemento non esiste, viene creata una entry nella Hash Map contenente l'entry in input.
        // In questo caso, non devo preoccuparmi di controllare il nesting level di altre entry con medesimo
        // identificativo.
        if (entryStack == null || entryStack.isEmpty()) {
            entryStack = new ArrayDeque<>();
            entryStack.push(entry);
            symbolTable.put(entry.getID(), entryStack);
            return false;
        }

        // Se l'elemento in testa dello stack ha un nesting level diverso dal mio, allora non ho collisioni
        STentry head = entryStack.peek();
        if (head != null && entry.getNestinglevel() != head.getNestinglevel()) {
            // Tutte le condizioni sono verificare, posso aggiungere la entry allo stack senza problemi
            entryStack.push(entry);
            return false;
        }

        // Se arrivo qua in fondo qualcosa è andato storto, probabilmente la entry esiste già.
        return true;
    }

    /**
     * Dato il nome di una entry, ritorna la prima entry (ovvero quella al livello più basso) della symbol table.
     *
     * @param ID Il nome della entry da cercare.
     * @return null se non trova la chiave nella HashMap, STentry corrispondente altrimenti.
     */
    public STentry findFirstInSymbolTable(String ID) {
        ArrayDeque<STentry> entryStack = symbolTable.getOrDefault(ID, null);

        if (entryStack != null && !entryStack.isEmpty()) {
            return entryStack.peek();
        }

        return null;
    }

    // TODO: Comment
    public STentry findInSymbolTable(String ID, int nestingLevel) {
        ArrayDeque<STentry> entryStack = symbolTable.getOrDefault(ID, null);

        if (entryStack != null && !entryStack.isEmpty()) {
            for (STentry st: entryStack){
                if (nestingLevel == st.getNestinglevel()) return st;
            }
        }

        return null;
    }


    /**
     * Rimuove tutte le entry da un determinato livello dalla Symbol Table.
     *
     * @param lev Il livello a cui eliminare le entry.
     */
    public void removeLevelFromSymbolTable(int lev) {
        // Arraylist in cui salvo le chiavi vuote da eliminare
        ArrayList<String> emptyList = new ArrayList<>();

        // Scorro la Symbol Table e, per ogni elemento, se la testa ha il livello che cerco la rimuovo.
        symbolTable.forEach((k, v) -> {
            if (v != null && !v.isEmpty() && v.peek().getNestinglevel() == lev) {
                v.pop();

                // Se la lista diventa vuota, aggiungo la chiave alla lista di chiavi da rimuovere
                if (v.isEmpty()) emptyList.add(k);
            }
        });

        // Itero la lista di chiavi da rimuovere e le rimuovo dall'arraylist
        emptyList.forEach(symbolTable::remove);
    }

    public SymbolTableWrapper clone() {
        return new SymbolTableWrapper(symbolTable);
    }


    public void update(SymbolTableWrapper st) {
        symbolTable.forEach((k,v) -> {
            STentry e1 = findFirstInSymbolTable(k);
            STentry e2 = st.findInSymbolTable(k, e1.getNestinglevel());
            if (e1.getEffect() != e2.getEffect()) e1.setEffect(e2.getEffect());
        });
    }

}
