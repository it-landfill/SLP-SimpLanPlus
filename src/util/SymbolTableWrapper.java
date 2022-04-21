package util;

import ast.STentry;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class SymbolTableWrapper {
	private final HashMap<String, ArrayDeque<STentry>> symbolTable;

	public SymbolTableWrapper() {
		symbolTable = new HashMap<>();
	}

	/**
	 * Controlla se l'elemento esiste nella symbol table allo stesso livello, altrimenti lo aggiunge.
	 * @param entry La entry da aggiungere alla Symbol Table
	 * @return true in caso di errore, false alrimenti
	 */
	public boolean addToSymbolTable(STentry entry) {
		ArrayDeque<STentry> entryStack = symbolTable.getOrDefault(entry.getID(), null);

		// Se l'elemento non esiste, creo tutto da 0 e non devo preoccuparmi di collisioni.
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

		// Se arrivo qua in fondo qualcosa è andato storto, probabilmente la variabile esiste già...
		return true;
	}

	/**
	 * Dato il nome di una entry, ritorna la prima entry (ovvero quella al livello più basso) della symbol table.
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

	/**
	 * Rimuove tutte le entry ad un determinato livello dalla Symbol Table.
	 * @param lev Il livello a cui eliminare le entry.
	 */
	public void removeLevelFromSymbolTable(int lev) {
		// Arraylist in cui salvo le chiavi vuote da eliminare
		ArrayList<String> emptyList = new ArrayList<>();

		// Scorro la ST e, per ogni elemento, se la testa ha il livello che cerco la rimuovo.
		symbolTable.forEach((k,v) -> {
			if(v != null && !v.isEmpty() && v.peek().getNestinglevel()==lev) {
				v.pop();

				// Se la lista diventa vuota, aggiungo la chiave alla lista di chiavi da rimuovere
				if (v.isEmpty()) emptyList.add(k);
			}
		});

		// Itero la lista di chiavi da rimuovere e le rimuovo dall'arraylist
		emptyList.forEach(symbolTable::remove);
	}
}