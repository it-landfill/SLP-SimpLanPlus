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

	private void pop(int reg) {
		t[reg] = memory[sp++];
	}

	private void top(int reg) {
		t[reg] = memory[sp];
	}

	private void push(int reg) {
		memory[--sp] = t[reg];
	}

	public void evaluate() {
		while ( true ) {
			if(hp+1>=sp) {
				System.out.println("\nError: Out of memory");
				return;
			}
			else {
				int bytecode = code[ip++]; // fetch
				int rd,r1,r2;
				switch (bytecode) {
					case SVMParser.PUSH -> {
						rd = code[ip++];
						push(rd);
					}
					case SVMParser.POP -> pop();
					case SVMParser.ADD -> {
						r1 = pop();
						r2 = pop();
						push(r2 + r1);
					}
					case SVMParser.MULT -> {
						r1 = pop();
						r2 = pop();
						push(r2 * r1);
					}
					case SVMParser.DIV -> {
						r1 = pop();
						r2 = pop();
						push(r2 / r1);
					}
					case SVMParser.SUB -> {
						r1 = pop();
						r2 = pop();
						push(r2 - r1);
					}
					case SVMParser.LT -> {
						r1 = pop();
						r2 = pop();
						push((r2 < r1)?1:0);
					}
					case SVMParser.LTE -> {
						r1 = pop();
						r2 = pop();
						push((r2 <= r1)?1:0);
					}
					case SVMParser.GT -> {
						r1 = pop();
						r2 = pop();
						push((r2 > r1)?1:0);
					}
					case SVMParser.GTE -> {
						r1 = pop();
						r2 = pop();
						push((r2 >= r1)?1:0);
					}
					case SVMParser.EQ -> {
						r1 = pop();
						r2 = pop();
						push((r2 == r1)?1:0);
					}
					case SVMParser.OR -> {
						r1 = pop();
						r2 = pop();
						push((r2 + r1 != 0)?1:0);
					}
					case SVMParser.NOT -> {
						r1 = pop();
						push((r1 == 1)?0:1);
					}
					case SVMParser.PRINT -> System.out.println((sp < MEMSIZE) ? memory[sp] : "Empty stack!");
					case SVMParser.HALT -> {
						//to print the result
						System.out.println("\nResult: " + memory[sp] + "\n");
						return;
					}
				}
			}
		}
	}
}
