package SLP_ast;

import SLP_ast.typeNode.TypeNode;
import util.Environment;
import util.SLPUtils;
import util.SemanticError;
import util.SymbolTableWrapper;

import java.util.ArrayList;

public interface Node {

	TypeNode typeCheck(SymbolTableWrapper symbolTable) throws SLPUtils.TypeCheckError;

	String codeGeneration(String options);

	ArrayList<SemanticError> checkSemantics(Environment env, SymbolTableWrapper symbolTable);

}  