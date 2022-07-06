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
	 * La gestione delle label avviene in due passate.
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
				case    SVMParser.PUSH,
						SVMParser.POP,
						SVMParser.TOP,
						SVMParser.JR,
						SVMParser.PRINT -> i+=1;
				case    SVMParser.LI,
						SVMParser.MOV,
						SVMParser.LW,
						SVMParser.SW,
						SVMParser.NOT,
						SVMParser.NEG -> i+=2;
				case    SVMParser.ADD,
						SVMParser.SUB,
						SVMParser.MULT,
						SVMParser.DIV,
						SVMParser.LT,
						SVMParser.LTE,
						SVMParser.GT,
						SVMParser.GTE,
						SVMParser.EQ,
						SVMParser.AND,
						SVMParser.OR -> i+=3;
				case    SVMParser.JAL -> {
						i++;
						code[i] = labelLookup(code[i]);
				}
				case    SVMParser.BEQ -> {
						i+=3;
						code[i] = labelLookup(code[i]);
				}
				case    SVMParser.HALT -> {}
				default -> System.out.println("[ERROR] Not a valid instruction " + code[i] + " at position " + i + ".Terminating");
			}
		}
	}

	private int regLabelToCode(String label) {
		if (label.equals("$fp")) return -1;
		if (label.equals("$sp")) return -2;
		if (label.equals("$ra")) return -3;
		if (label.equals("$ip")) return -4;
		return Integer.parseInt(String.valueOf(label.charAt(2)));
	}

	@Override
	public Void visitAssembly(SVMParser.AssemblyContext ctx) {
		visitChildren(ctx);
		return null;
	}

	@Override
	public Void visitPush(SVMParser.PushContext ctx) {
		code[ip++] = SVMParser.PUSH;
		code[ip++] = regLabelToCode(ctx.src.getText());
		return null;
	}

	@Override
	public Void visitPop(SVMParser.PopContext ctx) {
		code[ip++] = SVMParser.POP;
		code[ip++] = regLabelToCode(ctx.dest.getText());
		return null;
	}

	@Override
	public Void visitTop(SVMParser.TopContext ctx) {
		code[ip++] = SVMParser.TOP;
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
		code[ip++] = SVMParser.SUB;
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
	public Void visitPrint(SVMParser.PrintContext ctx) {
		code[ip++] = SVMParser.PRINT;
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
	public Void visitLw(SVMParser.LwContext ctx) {
		code[ip++] = SVMParser.LW;
		code[ip++] = regLabelToCode(ctx.reg.getText());
		code[ip++] = regLabelToCode(ctx.mem.getText()); // FIXME: Dividere in offset e reg
		return null;
	}

	@Override
	public Void visitSw(SVMParser.SwContext ctx) {
		code[ip++] = SVMParser.LW;
		code[ip++] = regLabelToCode(ctx.reg.getText());
		code[ip++] = regLabelToCode(ctx.mem.getText()); // FIXME: Dividere in offset e reg
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
	public Void visitJal(SVMParser.JalContext ctx) {
		// Vedere funzionamento label spiegato all'inizio

		// Salvo l'indirizzo dell'istruzione attuale
		code[ip++] = SVMParser.MOV;
		code[ip++] = regLabelToCode("$ra");
		code[ip++] = regLabelToCode("$ip");
		/*
		// Incremento ra dell'offset necessario ad arrivare alla successiva istruzione
		// +4 per ADDI
		// +2 per JAL
		code[ip++] = SVMParser.ADDI;
		code[ip++] = regLabelToCode("$ra");
		code[ip++] = regLabelToCode("$ra");
		code[ip++] = 6;
		*/
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
}
