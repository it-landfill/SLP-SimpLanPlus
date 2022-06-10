package SVM_ast;

import SVM_parser.SVMBaseVisitor;
import SVM_parser.SVMParser;
import interpreter.ExecuteVM;

import java.util.HashMap;

public class SVMVisitorImpl extends SVMBaseVisitor<Void> {

	private class Label {
		public int id;
		public int pos;
		private static int nextID = 0;

		public Label(int pos) {
			this.pos = pos;
			this.id = nextID++;
		}

		public Label() {
			this.pos = -1;
			this.id = nextID++;
		}
	}

	public int[] code = new int[ExecuteVM.CODESIZE];
	private final HashMap<String, Label> labelHM = new HashMap<>();
	private int ip = 0;

	/*
	 * La gestione delle label avviene in 2 passate.
	 * L'idea è che in visit non abbiamo ancora le posizioni di tutte le label, di conseguenza mettiamo al posto della
	 * posizione un id univoco per la label.
	 * A fine programma, in teoria, le label dovrebbero tutte avere il campo pos aggiornato al valore corretto,
	 * di conseguenza, si possono sostituire gli id con la posizione effettiva.
	 *
	 * In fase di visit avviene la prima passata:
	 * 1. Si cerca la label in labelHM
	 * 1a. Se la label non esiste se ne crea una nuova con pos = -1
	 * 2. Si salva in code l'id della label
	 *
	 * La seconda passata, data dalla funzione labelAlign, avviene a seguito dell'istruzione HALT:
	 * 1. Si scorre il codice fino a trovare una JMP o una BEQ
	 * 2. Si sostituisce il valore label id salvato in code con la pos corrispondente alla label con id code[i]
	 */
	private int labelLookup(String labelName) {
		Label label = labelHM.get(labelName);
		if (label == null) {
			System.out.println("[WARNING] Label " + labelName + " not found, generating placeholder");
			label = new Label();
			labelHM.put(labelName,label);
		}
		return label.id;
	}

	private int labelLookup(int labelID) {
		for(Label l : labelHM.values()) {
			if (l.id == labelID) return l.pos;
		}

		return -1;
	}

	/*
	 * La funzione sostituisce gli id delle label con la loro posizione corretta
	 */
	private void labelAlign() {
		int i = -1;
		while (++i<ip){
			switch (code[i]) {
				case SVMParser.PUSH:
				case SVMParser.POP:
				case SVMParser.TOP:
				case SVMParser.PRINT:
					i+=1;
					break;
				case SVMParser.LI:
				case SVMParser.MOV:
				case SVMParser.LW:
				case SVMParser.SW:
				case SVMParser.NOT:
				case SVMParser.NEG:
					i+=2;
					break;
				case SVMParser.ADD:
				case SVMParser.SUB:
				case SVMParser.MULT:
				case SVMParser.DIV:
				case SVMParser.LT:
				case SVMParser.LTE:
				case SVMParser.GT:
				case SVMParser.GTE:
				case SVMParser.EQ:
				case SVMParser.AND:
				case SVMParser.OR:
					i+=3;
					break;
				case SVMParser.JMP:
					i++;
					code[i] = labelLookup(code[i]);
					break;
				case SVMParser.BEQ:
					i+=3;
					code[i] = labelLookup(code[i]);
					break;
				case SVMParser.HALT:
					break;
				default:
					System.out.println("[ERROR] Not a valid instruction " + code[i] + " at position " + i + ".Terminating");
					break;
			}
		}
	}

	@Override
	public Void visitAssembly(SVMParser.AssemblyContext ctx) {
		visitChildren(ctx);
		return null;
	}

	@Override
	public Void visitPush(SVMParser.PushContext ctx) {
		code[ip++] = SVMParser.PUSH;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.src.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitPop(SVMParser.PopContext ctx) {
		code[ip++] = SVMParser.POP;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitTop(SVMParser.TopContext ctx) {
		code[ip++] = SVMParser.TOP;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitAdd(SVMParser.AddContext ctx) {
		code[ip++] = SVMParser.ADD;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitSub(SVMParser.SubContext ctx) {
		code[ip++] = SVMParser.SUB;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitMult(SVMParser.MultContext ctx) {
		code[ip++] = SVMParser.MULT;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitDiv(SVMParser.DivContext ctx) {
		code[ip++] = SVMParser.DIV;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitLt(SVMParser.LtContext ctx) {
		code[ip++] = SVMParser.LT;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitLte(SVMParser.LteContext ctx) {
		code[ip++] = SVMParser.LTE;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitGt(SVMParser.GtContext ctx) {
		code[ip++] = SVMParser.GT;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitGte(SVMParser.GteContext ctx) {
		code[ip++] = SVMParser.GTE;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitEq(SVMParser.EqContext ctx) {
		code[ip++] = SVMParser.EQ;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitNeq(SVMParser.NeqContext ctx) {
		// Calcolo una EQ e la nego
		code[ip++] = SVMParser.EQ;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		code[ip++] = SVMParser.NOT;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitAnd(SVMParser.AndContext ctx) {
		code[ip++] = SVMParser.AND;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitOr(SVMParser.OrContext ctx) {
		code[ip++] = SVMParser.OR;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitNot(SVMParser.NotContext ctx) {
		code[ip++] = SVMParser.NOT;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.src.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitPrint(SVMParser.PrintContext ctx) {
		code[ip++] = SVMParser.PRINT;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.src.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitLi(SVMParser.LiContext ctx) {
		code[ip++] = SVMParser.LI;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(ctx.n.getText());
		return null;
	}

	@Override
	public Void visitMov(SVMParser.MovContext ctx) {
		code[ip++] = SVMParser.MOV;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.src.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitNeg(SVMParser.NegContext ctx) {
		code[ip++] = SVMParser.NEG;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.dest.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.src.getText().charAt(2)));
		return null;
	}

	@Override
	public Void visitLw(SVMParser.LwContext ctx) {
		code[ip++] = SVMParser.LW;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.mem.getText().charAt(2))); // FIXME: Calcolare offset mem e passare quello, da fare in base decisioni prese in type check
		return null;
	}

	@Override
	public Void visitSw(SVMParser.SwContext ctx) {
		code[ip++] = SVMParser.LW;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.mem.getText().charAt(2))); // FIXME: Calcolare offset mem e passare quello, da fare in base decisioni prese in type check
		return null;
	}

	@Override
	public Void visitLabel(SVMParser.LabelContext ctx) {
		// Vedere funzionamento label spiegato all'inizio
		String labName = ctx.lab.getText();
		Label label = labelHM.get(labName);
		if (label == null) {
			label = new Label(ip);
			labelHM.put(labName, label);
		} else {
			label.pos = ip;
		}

		return null;
	}

	@Override
	public Void visitJmp(SVMParser.JmpContext ctx) {
		// Vedere funzionamento label spiegato all'inizio
		code[ip++] = SVMParser.JMP;
		code[ip++] = labelLookup(ctx.lab.getText());
		return null;
	}

	@Override
	public Void visitBeq(SVMParser.BeqContext ctx) {
		// Vedere funzionamento label spiegato all'inizio
		code[ip++] = SVMParser.BEQ;
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg1.getText().charAt(2)));
		code[ip++] = Integer.parseInt(String.valueOf(ctx.reg2.getText().charAt(2)));
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
}
