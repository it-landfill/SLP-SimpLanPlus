package SVM_ast;

import SVM_parser.SVMBaseVisitor;
import SVM_parser.SVMLexer;
import SVM_parser.SVMParser;
import interpreter.ExecuteVM;

public class SVMVisitorImpl extends SVMBaseVisitor<Void> {

	public int[] code = new int[ExecuteVM.CODESIZE];
	private int i = 0;

	@Override
	public Void visitAssembly(SVMParser.AssemblyContext ctx) {
		visitChildren(ctx);
		return null;
	}

	@Override
	public Void visitInstruction(SVMParser.InstructionContext ctx) {
		switch (ctx.getStart().getType()) {
			case SVMLexer.PUSH:
				if(ctx.n != null) {
					code[i++] = SVMParser.PUSH;
					code[i++] = Integer.parseInt(ctx.n.getText());
				}
				break;
			case SVMLexer.POP:
				code[i++] = SVMParser.POP;
				break;
			case SVMLexer.ADD:
				code[i++] = SVMParser.ADD;
				break;
			case SVMLexer.SUB:
				code[i++] = SVMParser.SUB;
				break;
			case SVMLexer.MULT:
				code[i++] = SVMParser.MULT;
				break;
			case SVMLexer.DIV:
				code[i++] = SVMParser.DIV;
				break;
			case SVMLexer.PRINT:
				code[i++] = SVMParser.PRINT;
				break;
			case SVMLexer.HALT:
				code[i++] = SVMParser.HALT;
				break;
			default:
				break;	// Invalid instruction
		}
		return null;
	}
}
