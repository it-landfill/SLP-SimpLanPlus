package util;

public class SemanticError {

    // Variabile contenente il messaggio di errore semantico.
    public final String msg;

    public SemanticError(String msg) {
        this.msg = msg;
    }

    /**
     * Funzione che ritorna la String contenente l'errore semantico.
     *
     * @return String
     */
    @Override
    public String toString() {
        return msg;
    }
}
