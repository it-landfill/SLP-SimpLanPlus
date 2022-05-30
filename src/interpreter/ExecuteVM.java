package interpreter;

import SVM_parser.SVMParser;

public class ExecuteVM {

	public static final int CODESIZE = 10000;
	public static final int MEMSIZE = 10000;

	private final int[] code;
	private final int[] memory = new int[MEMSIZE];

	private final int[] t = new int[10]; // Implemento solo i registri t0 - t9

	private int ip = 0;
	private int sp = MEMSIZE;
	private int hp = 0;

	public ExecuteVM(int[] code) {
		this.code = code;
	}

	private void pop() {
		int reg = code[ip++];
		t[reg] = memory[sp++];
	}

	private void top() {
		int reg = code[ip++];
		t[reg] = memory[sp];
	}

	private void push() {
		int reg = code[ip++];
		memory[--sp] = t[reg];
	}

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
					case SVMParser.ADD -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = t[r1] + t[r2];
					}
					case SVMParser.SUB -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = t[r1] - t[r2]; //FIXME: Come gestisco negativi?
					}
					case SVMParser.MULT -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = t[r1] * t[r2];
					}
					case SVMParser.DIV -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = t[r1] / t[r2]; //FIXME: Come gestisco il resto della divisione?
					}
					case SVMParser.LT -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] < t[r2])?1:0;
					}
					case SVMParser.LTE -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] <= t[r2])?1:0;
					}
					case SVMParser.GT -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] > t[r2])?1:0;
					}
					case SVMParser.GTE -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] >= t[r2])?1:0;
					}
					case SVMParser.EQ -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] == t[r2])?1:0;
					} //Non abbiamo neq perchè viene convertita in una eq negata in SVMVisitorImpl
					case SVMParser.AND -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] + t[r2] == 2)?1:0;
					}
					case SVMParser.OR -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] + t[r2] != 0)?1:0;
					}
					case SVMParser.NOT -> {
						rd = code[ip++];
						r1 = code[ip++];
						t[rd] = (t[r1] == 1)?0:1;
					}
					case SVMParser.PRINT -> {
						rd = code[ip++];
						System.out.println(t[rd]);
					}
					case SVMParser.LI -> {
						rd = code[ip++];
						val = code[ip++];
						t[rd] = val;
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
