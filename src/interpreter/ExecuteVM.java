package interpreter;

import SLP_ast.STentry;
import SVM_parser.SVMParser;

import java.util.ArrayDeque;
import java.util.HashMap;

public class ExecuteVM {

	public static final int CODESIZE = 10000;
	public static final int MEMSIZE = 10000;

	private final int[] code;

	/*DOMANDA: Ha senso lavorare l'offset in type check con +1 o +4 in base al tipo anche se poi salvo tutto
	 * su un array con celle di dimensione fissa?
	 */
	private final int[] memory = new int[MEMSIZE];

	private final int[] t = new int[10]; // Implemento solo i registri t0 - t9

	private int ip = 0;
	private int sp = MEMSIZE, fp = MEMSIZE, ra = MEMSIZE;

	private int hp = 0;

	public ExecuteVM(int[] code) {
		this.code = code;
	}

	private int readReg(int reg) {
		if (reg == -1) return fp;
		if (reg == -2) return sp;
		if (reg == -3) return ra;
		if (reg == -4) return ip;
		return t[reg];
	}

	private void writeReg(int reg, int val) {
		if (reg == -1) fp = val;
		if (reg == -2) sp = val;
		if (reg == -3) ra = val;
		if (reg == -4) ip = val;
		t[reg] = val;
	}

	private void pop() {
		writeReg(code[ip++], memory[sp++]);
	}

	private void top() {
		writeReg(code[ip++], memory[sp]);
	}

	private void push() {
		memory[--sp] = readReg(code[ip++]);
	}

	/*
	* Le seguenti operazioni non sono implementate poichè convertite in altre operazioni in SVMVisitorImpl
	* neq -> eq + not
	* */
	public boolean evaluate() {
		while ( true ) {
			if(hp+1>=sp) {
				System.out.println("\nError: Out of memory");
				return false;
			}
			else {
				int bytecode = code[ip++]; // fetch
				int rd,r1,r2, val;
				switch (bytecode) {
					case SVMParser.PUSH -> push();
					case SVMParser.POP -> pop();
					case SVMParser.TOP -> top();
					case SVMParser.LI -> {
						rd = code[ip++];
						val = code[ip++];
						writeReg(rd, val);
					}
					case SVMParser.MOV -> {
						rd = code[ip++];
						r1 = code[ip++];
						writeReg(rd, readReg(r1));
					}
					case SVMParser.LW -> {
						rd = code[ip++];
						val = code[ip++];
						if (memory[val] == -10000) {
							System.out.println("\nError: Null pointer exception");
							return false;
						}
						writeReg(rd, memory[val]); // FIXME: Rivedere logica save/load mem
					}
					case SVMParser.SW -> {
						r1 = code[ip++];
						val = code[ip++];
						memory[val] = readReg(r1);
					}
					case SVMParser.ADD -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, r1+r2);
					}
					case SVMParser.SUB -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, r1-r2); //FIXME: Come gestisco negativi?
					}
					case SVMParser.MULT -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, r1*r2);
					}
					case SVMParser.DIV -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, r1/r2); //FIXME: Come gestisco il resto della divisione? Non lo facciamo, easy.
					}
					case SVMParser.LT -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, (r1 < r2) ? 1 : 0);
					}
					case SVMParser.LTE -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, (r1 <= r2) ? 1 : 0);
					}
					case SVMParser.GT -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, (r1 > r2) ? 1 : 0);
					}
					case SVMParser.GTE -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, (r1 >= r2) ? 1 : 0);
					}
					case SVMParser.EQ -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, (r1 == r2) ? 1 : 0);
					} //Non abbiamo neq perchè viene convertita in una eq negata in SVMVisitorImpl
					case SVMParser.AND -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, (r1 + r2 == 2) ? 1 : 0);
					}
					case SVMParser.OR -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, (r1 + r2 != 0) ? 1 : 0);
					}
					case SVMParser.NOT -> {
						rd = code[ip++];
						r1 = code[ip++];
						r1 = readReg(r1);
						writeReg(rd, (r1 == 0) ? 1 : 0);
						t[rd] = (t[r1] == 1) ? 0 : 1;
					}
					case SVMParser.NEG -> {
						rd = code[ip++];
						r1 = code[ip++];
						r1 = readReg(r1);
						writeReg(rd, -1*r1);
					}
					case SVMParser.PRINT -> {
						rd = code[ip++];
						System.out.println(readReg(rd));
					}
					case SVMParser.JAL -> ip = code[ip];
					case SVMParser.JR -> ip = readReg(code[ip]);
					case SVMParser.BEQ -> {
						r1 = code[ip++];
						r2 = code[ip++];
						rd = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						if (r1 == r2) ip = rd;
					}
					case SVMParser.HALT -> {
						//to print the result
						System.out.println("\nEnd program");
						return true;
					}
					default -> {
						System.out.println("[ERROR] Not a valid instruction " + bytecode + " at position " + ip + ".Terminating");
						return false;
					}
				}
			}
		}
	}
}
