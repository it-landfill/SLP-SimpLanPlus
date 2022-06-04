package util;

import SLP_ast.Node;

public class TypeChecking {

    //valuta se il tipo "a" <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
    public static boolean isSubtype (Node a, Node b) {
        return a.getClass().equals(b.getClass()) ;
    }
}
