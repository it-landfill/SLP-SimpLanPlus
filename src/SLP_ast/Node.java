package SLP_ast;

import java.util.ArrayList;

import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;

// Scheletro base per tutte le classi future.
public interface Node {

	String toPrint(String indent);

	//  fa il type checking e ritorna:
	//  per una espressione, il suo tipo (oggetto BoolTypeNode o IntTypeNode)
	//  per una dichiarazione, "null"
	TypeNode typeCheck() throws SLPUtils.TypeCheckError;

	String codeGeneration();

	ArrayList<SemanticError> checkSemantics(Environment env);

}  