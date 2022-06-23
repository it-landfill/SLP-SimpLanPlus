package SLP_ast.typeNode;

public class VoidableTypeNode extends VoidTypeNode{

	private final TypeNode alternativeType;

	public VoidableTypeNode(TypeNode alternativeType) {
		this.alternativeType = alternativeType;
	}

	public TypeNode getAlternativeType() {
		return alternativeType;
	}
}
