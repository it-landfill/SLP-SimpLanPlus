package SLP_ast;

import java.util.ArrayList;

import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

// Scheletro base per tutte le classi future.
public interface Node {
	//  fa il type checking e ritorna:
	//  per una espressione, il suo tipo (oggetto BoolTypeNode o IntTypeNode)
	//  per una dichiarazione, "null"
	TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError;

	String codeGeneration(String options);

	ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable);

}  