package util;

import SLP_ast.STentry;
import SLP_ast.typeNode.FunctionSingatureType;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SymbolTableWrapper {

    // Generate a HashMap (Symbol Table) with a String key and an ArrayDeque of STEntry objects.
    private final HashMap<String, ArrayDeque<STentry>> symbolTable;

    public SymbolTableWrapper() {
        symbolTable = new HashMap<>();
    }

    public SymbolTableWrapper(HashMap<String, ArrayDeque<STentry>> st) {

        this();

        st.forEach((k, v) -> {
            ArrayDeque<STentry> newAl = new ArrayDeque<>();
            v.forEach(el -> newAl.add(el.clone()));
            symbolTable.put(k, newAl);
        });

    }

    /**
     * Check if the element exists in the symbol table at the specified nesting level.
     * If it does, return true, otherwise add it to the symbol table and return false.
     *
     * @param entry Entry to be added to the symbol table.
     * @return true if the element already exists, false otherwise.
     */
    public boolean addToSymbolTable(STentry entry) {
        // Search for the input entry in the Hash Map. If the search is unsuccessful, it returns null.
        ArrayDeque<STentry> entryStack = symbolTable.getOrDefault(entry.getID(), null);

        // If the element doesn't exist, an entry is created in the Hash Map containing the input entry.
        if (entryStack == null || entryStack.isEmpty()) {
            entryStack = new ArrayDeque<>();
            entryStack.push(entry);
            symbolTable.put(entry.getID(), entryStack);
            return false;
        }

        // If the top element of the stack has a different nesting level than mine, then I have no collisions.
        STentry head = entryStack.peek();
        if (head != null && entry.getNestinglevel() != head.getNestinglevel()) {
            entryStack.push(entry);
            return false;
        }

        // If I reach this return, the addition of the entry was not successful.
        return true;
    }

    /**
     * Given an entry name, returns the first entry (the one with the highest nesting level) with the given name in
     * the symbol table.
     *
     * @param ID ID of the entry.
     * @return null if the entry does not exist, STentry otherwise.
     */
    public STentry findFirstInSymbolTable(String ID) {
        ArrayDeque<STentry> entryStack = symbolTable.getOrDefault(ID, null);

        if (entryStack != null && !entryStack.isEmpty()) {
            return entryStack.peek();
        }

        return null;
    }

    /**
     * Given an entry name and a nesting level, returns the entry with the given name and nesting level in the symbol
     * table.
     *
     * @param ID ID of the entry.
     * @param nestingLevel nesting level of the entry.
     * @return null if the entry does not exist, STentry otherwise.
     */
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
     * Removes all the entries from the symbol table at a specified nesting level.
     *
     * @param lev Nesting level to remove.
     */
    public void removeLevelFromSymbolTable(int lev) {
        // Save the keys that have no value to be deleted later.
        ArrayList<String> emptyList = new ArrayList<>();

        // For each entry in the symbol table, remove the head if it has the requested nesting level.
        symbolTable.forEach((k, v) -> {
            if (v != null && !v.isEmpty() && v.peek().getNestinglevel() == lev) {
                v.pop();

                // If after the removal, the arraydeque is empty, mark the key for removal.
                if (v.isEmpty()) emptyList.add(k);
            }
        });

        // Remove all the empty keys from the symbol table.
        emptyList.forEach(symbolTable::remove);
    }

    /**
     *
     * @return Returns a copy of the symbolTable.
     */
    public SymbolTableWrapper clone() {
        return new SymbolTableWrapper(symbolTable);
    }

    /**
     * Adds all the functions in the given symbol table to the current one.
     * @param st Source symbol table.
     */
    public void cloneFunctions(SymbolTableWrapper st){
        st.symbolTable.forEach((k,v) -> {
            for (STentry e : v){
                if (e.getType() instanceof FunctionSingatureType) {
                    addToSymbolTable(e);
                }
            }
        });
    }

    /**
     * Merges the effects of the given symbol table in the current one.
     * This function is used to update effects after an ITE with both true and false branch.
     * @param st Source symbol table
     */
    public void merge(SymbolTableWrapper st) {
        symbolTable.forEach((k,v) -> {
            STentry e1 = findFirstInSymbolTable(k);
            STentry e2 = st.findInSymbolTable(k, e1.getNestinglevel());
            // Update the effects only in these cases: _xD -> D, IxU | UxI -> U
            // Since the two symbol tables are always the product of a clone, I don't have to consider the case
            // where e2 is null.
            if (e1.getEffect().compareTo(e2.getEffect())!=0) {
                if (e2.getEffect() == STentry.Effects.DECLARED) e1.setEffect(STentry.Effects.DECLARED); // _xD -> D
                else if ((e1.getEffect() == STentry.Effects.INITIALIZED && e2.getEffect() == STentry.Effects.USED) || (e1.getEffect() == STentry.Effects.USED && e2.getEffect() == STentry.Effects.INITIALIZED)) e1.setEffect(STentry.Effects.USED); // IxU | UxI -> U
            }
        });
    }

    /**
     * Compares the effects of the given symbol table to the ones in the current one
     * and updates the current ones if they are lower.
     *
     * @param st Source symbol table
     */
    public void update(SymbolTableWrapper st) {
        symbolTable.forEach((k,v) -> {
            STentry e1 = findFirstInSymbolTable(k);
            STentry e2 = st.findInSymbolTable(k, e1.getNestinglevel());
            if (e2 != null) {
                if (e1.getEffect().compareTo(e2.getEffect()) < 0) {
                    e1.setEffect(e2.getEffect());
                }
            }
        });
    }

    /**
     * Evaluates the amount of bytes needed in order to allocate memory for a specific nesting level.
     * @param nl The nesting level to allocate.
     * @return The number of bytes to allocate.
     */
    public int nestingLevelRequiredBytes(int nl) {
        AtomicInteger bytes = new AtomicInteger();
        symbolTable.forEach((k,v) -> {
           STentry e = findInSymbolTable(k, nl);
           if (e != null) {
               if (SLPUtils.checkIntType(e.getType())) bytes.addAndGet(4);
               else if (SLPUtils.checkBoolType(e.getType())) bytes.addAndGet(1);
           }
        });
        return bytes.get();
    }

    /**
     * For each element in the symbolTable at a specific nesting level, adds a warning if the element has not been used yet.
     * @param nestinglevel The specified nesting level.
     * @return String containing all the unused warnings.
     */
    public String findUnused(int nestinglevel) {
        StringBuilder  sb = new StringBuilder();
        symbolTable.forEach((k,v) -> {
            STentry e = findInSymbolTable(k, nestinglevel);
            if (e != null && (e.getEffect() == STentry.Effects.DECLARED || e.getEffect() == STentry.Effects.INITIALIZED)) {
                sb.append("[WARNING] Variable ").append(e.getID()).append(" not used\n");
            }
        });
        return sb.toString();
    }

}