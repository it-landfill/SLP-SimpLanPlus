package SVM_ast;

import SVM_parser.SVMBaseVisitor;
import SVM_parser.SVMParser;
import interpreter.ExecuteVM;

import java.util.HashMap;

public class SVMVisitorImpl extends SVMBaseVisitor<Void> {

	private final HashMap<String, Label> labelHM = new HashMap<>();
	public int[] code = new int[ExecuteVM.CODESIZE];
	private int ip = 0;

	/*
	* The main problem with labels is that most of the time the label is needed before it is defined.
	* The only certain thing is that by the end of the program every label should have been defined.
	* This is why label handling happens in two steps:
	*
	* The first step happens while we parse the program:
	* Whenever a label is defined:
	* 1. Generate a label with the current ip
	* 2. Save the label in the labelHM
	*
	* Whenever a label is used:
	* 1.  Search the label in the labelHM
	* 1a. If the label is not found, create a new one with pos = -1
	* 2.  Replace the label with its id in the code.
	*
	* The second step happens after the program parsing reaches 'halt':
	* 1.  Read the code until we find a JMP or a BEQ
	* 2.  Replace the label id with the label's pos.
	* 2a. If the label still does not have a valid pos, throw an error.
	*/
	private int labelLookup(String labelName) {
		Label label = labelHM.get(labelName);
		if (label == null) {
			label = new Label(labelName);
			System.out.println("[WARNING] Label " + labelName + " not found, generating placeholder with id: " + label.id);
			labelHM.put(labelName, label);
		}
		return label.id;
	}

	private Label labelLookup(int labelID) {
		for (Label l : labelHM.values()) {
			if (l.id == labelID) return l;
		}

		return null;
	}

	/*
	 * La funzione sostituisce gli id delle label con la loro posizione corretta
	 * This function replaces the label ids with the correct position
	 */
	private void labelAlign() {
		int i = -1;
		while (++i < ip) {
			switch (code[i]) {
				case SVMParser.PUSHINT, SVMParser.POPINT, SVMParser.TOPINT, SVMParser.PUSHBOOL, SVMParser.POPBOOL, SVMParser.TOPBOOL, SVMParser.JR, SVMParser.PRINTB, SVMParser.PRINTW ->
						i += 1;
				case SVMParser.LI, SVMParser.MOV, SVMParser.NOT, SVMParser.NEG -> i += 2;
				case SVMParser.ADD, SVMParser.ADDI, SVMParser.SUB, SVMParser.SUBI, SVMParser.MULT, SVMParser.MULTI, SVMParser.DIV, SVMParser.MOD, SVMParser.MODI, SVMParser.LW, SVMParser.SW, SVMParser.LB, SVMParser.SB, SVMParser.DIVI, SVMParser.LT, SVMParser.LTE, SVMParser.GT, SVMParser.GTE, SVMParser.EQ, SVMParser.AND, SVMParser.OR ->
						i += 3;
				case SVMParser.JAL -> {
					i++;
					Label tmp = labelLookup(code[i]);
					if (tmp == null) {
						System.out.println("[ERROR] [labelAlign] Label with id: " + code[i] + "Does not exist. Terminating");
						System.exit(1);
					} else if (tmp.pos == -1) {
						System.out.println("[ERROR] [labelAlign] Label with id: " + tmp.id + " and name: " + tmp.name + " does not have a valid pos. Terminating");
						System.exit(1);
					} else {
						code[i] = tmp.pos;
					}
				}
				case SVMParser.BEQ -> {
					i += 3;
					Label tmp = labelLookup(code[i]);
					if (tmp == null) {
						System.out.println("[ERROR] [labelAlign] Label with id: " + code[i] + "Does not exist. Terminating");
						System.exit(1);
					} else if (tmp.pos == -1) {
						System.out.println("[ERROR] [labelAlign] Label with id: " + tmp.id + " and name: " + tmp.name + " does not have a valid pos. Terminating");
						System.exit(1);
					} else {
						code[i] = tmp.pos;
					}
				}
				case SVMParser.HALT -> {
				}
				default -> {
					System.out.println("[ERROR] [labelAlign] Not a valid instruction " + code[i] + " at position " + i + ".Terminating");
					System.exit(1);
				}
			}
		}
	}

	private int regLabelToCode(String label) {
		if (label.equals("$fp")) return -1;
		if (label.equals("$sp")) return -2;
		if (label.equals("$ra")) return -3;
		if (label.equals("$ip")) return -4;
		if (label.equals("$ret")) return -5;
		return Integer.parseInt(String.valueOf(label.charAt(2)));
	}

	@Override
	public Void visitAssembly(SVMParser.AssemblyContext ctx) {
		visitChildren(ctx);
		return null;
	}

	@Override
	public Void visitPushInt(SVMParser.PushIntContext ctx) {
		code[ip++] = SVMParser.PUSHINT;
		code[ip++] = regLabelToCode(ctx.src.getText());
		return null;
	}

	@Override
	public Void visitPopInt(SVMParser.PopIntContext ctx) {
		code[ip++] = SVMParser.POPINT;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		return null;
	}

	@Override
	public Void visitTopInt(SVMParser.TopIntContext ctx) {
		code[ip++] = SVMParser.TOPINT;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		return null;
	}

	@Override
	public Void visitPushBool(SVMParser.PushBoolContext ctx) {
		code[ip++] = SVMParser.PUSHBOOL;
		code[ip++] = regLabelToCode(ctx.src.getText());
		return null;
	}

	@Override
	public Void visitPopBool(SVMParser.PopBoolContext ctx) {
		code[ip++] = SVMParser.POPBOOL;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		return null;
	}

	@Override
	public Void visitTopBool(SVMParser.TopBoolContext ctx) {
		code[ip++] = SVMParser.TOPBOOL;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		return null;
	}

	@Override
	public Void visitAdd(SVMParser.AddContext ctx) {
		code[ip++] = SVMParser.ADD;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitAddi(SVMParser.AddiContext ctx) {
		code[ip++] = SVMParser.ADDI;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = Integer.parseInt(ctx.val.getText());
		return null;
	}

	@Override
	public Void visitSub(SVMParser.SubContext ctx) {
		code[ip++] = SVMParser.SUB;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitSubi(SVMParser.SubiContext ctx) {
		code[ip++] = SVMParser.SUBI;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = Integer.parseInt(ctx.val.getText());
		return null;
	}

	@Override
	public Void visitMult(SVMParser.MultContext ctx) {
		code[ip++] = SVMParser.MULT;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitMulti(SVMParser.MultiContext ctx) {
		code[ip++] = SVMParser.MULTI;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = Integer.parseInt(ctx.val.getText());
		return null;
	}

	@Override
	public Void visitDiv(SVMParser.DivContext ctx) {
		code[ip++] = SVMParser.DIV;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitDivi(SVMParser.DiviContext ctx) {
		code[ip++] = SVMParser.DIVI;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = Integer.parseInt(ctx.val.getText());
		return null;
	}

	@Override
	public Void visitMod(SVMParser.ModContext ctx) {
		code[ip++] = SVMParser.MOD;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitModi(SVMParser.ModiContext ctx) {
		code[ip++] = SVMParser.MODI;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = Integer.parseInt(ctx.val.getText());
		return null;
	}

	@Override
	public Void visitLt(SVMParser.LtContext ctx) {
		code[ip++] = SVMParser.LT;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitLte(SVMParser.LteContext ctx) {
		code[ip++] = SVMParser.LTE;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitGt(SVMParser.GtContext ctx) {
		code[ip++] = SVMParser.GT;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitGte(SVMParser.GteContext ctx) {
		code[ip++] = SVMParser.GTE;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitEq(SVMParser.EqContext ctx) {
		code[ip++] = SVMParser.EQ;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitNeq(SVMParser.NeqContext ctx) {
		// Calcolo una EQ e la nego
		code[ip++] = SVMParser.EQ;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		code[ip++] = SVMParser.NOT;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.dest.getText());
		return null;
	}

	@Override
	public Void visitAnd(SVMParser.AndContext ctx) {
		code[ip++] = SVMParser.AND;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitOr(SVMParser.OrContext ctx) {
		code[ip++] = SVMParser.OR;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitNot(SVMParser.NotContext ctx) {
		code[ip++] = SVMParser.NOT;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.src.getText());
		return null;
	}

	@Override
	public Void visitPrintw(SVMParser.PrintwContext ctx) {
		code[ip++] = SVMParser.PRINTW;
		code[ip++] = regLabelToCode(ctx.src.getText());
		return null;
	}

	@Override
	public Void visitPrintb(SVMParser.PrintbContext ctx) {
		code[ip++] = SVMParser.PRINTB;
		code[ip++] = regLabelToCode(ctx.src.getText());
		return null;
	}

	@Override
	public Void visitLi(SVMParser.LiContext ctx) {
		code[ip++] = SVMParser.LI;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = Integer.parseInt(ctx.n.getText());
		return null;
	}

	@Override
	public Void visitMov(SVMParser.MovContext ctx) {
		code[ip++] = SVMParser.MOV;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.src.getText());
		return null;
	}

	@Override
	public Void visitNeg(SVMParser.NegContext ctx) {
		code[ip++] = SVMParser.NEG;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		code[ip++] = regLabelToCode(ctx.src.getText());
		return null;
	}

	@Override
	public Void visitSw(SVMParser.SwContext ctx) {
		code[ip++] = SVMParser.SW;
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = Integer.parseInt(ctx.offset.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitLw(SVMParser.LwContext ctx) {
		code[ip++] = SVMParser.LW;
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = Integer.parseInt(ctx.offset.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitLb(SVMParser.LbContext ctx) {
		code[ip++] = SVMParser.LB;
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = Integer.parseInt(ctx.offset.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitSb(SVMParser.SbContext ctx) {
		code[ip++] = SVMParser.SB;
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = Integer.parseInt(ctx.offset.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		return null;
	}

	@Override
	public Void visitLabel(SVMParser.LabelContext ctx) {
		// Vedere funzionamento label spiegato all'inizio
		String labName = ctx.lab.getText();
		Label label = labelHM.get(labName);
		if (label == null) {
			label = new Label(labName, ip);
			labelHM.put(labName, label);
		} else {
			label.pos = ip;
		}

		return null;
	}

	@Override
	public Void visitJal(SVMParser.JalContext ctx) {
		// Vedere funzionamento label spiegato all'inizio


		// Salvo l'indirizzo dell'istruzione attuale
		code[ip++] = SVMParser.MOV;
		code[ip++] = regLabelToCode("$ra");
		code[ip++] = regLabelToCode("$ip");

		// Incremento ra dell'offset necessario ad arrivare alla successiva istruzione
		// +4 per ADDI
		// +2 per JAL
		code[ip++] = SVMParser.ADDI;
		code[ip++] = regLabelToCode("$ra");
		code[ip++] = regLabelToCode("$ra");
		code[ip++] = 6;


		code[ip++] = SVMParser.JAL;
		code[ip++] = labelLookup(ctx.lab.getText());
		return null;
	}

	@Override
	public Void visitJr(SVMParser.JrContext ctx) {
		code[ip++] = SVMParser.JR;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		return null;
	}

	@Override
	public Void visitBeq(SVMParser.BeqContext ctx) {
		// Vedere funzionamento label spiegato all'inizio
		code[ip++] = SVMParser.BEQ;
		code[ip++] = regLabelToCode(ctx.reg1.getText());
		code[ip++] = regLabelToCode(ctx.reg2.getText());
		String label = ctx.lab.getText();
		if (label != null) code[ip++] = labelLookup(label);
		else System.out.println("[INTERNAL ERROR] Unable to get label name.");
		return null;
	}

	@Override
	public Void visitHalt(SVMParser.HaltContext ctx) {
		code[ip++] = SVMParser.HALT;
		labelAlign();
		return null;
	}

	private class Label {
		private static int nextID = 0;
		public int id;
		public int pos;
		public String name;

		public Label(String name, int pos) {
			this.name = name;
			this.pos = pos;
			this.id = nextID++;
		}

		public Label(String name) {
			this(name, -1);
		}
	}
}
