package interpreter;

import SVM_parser.SVMParser;

public class ExecuteVM {

	public static final int CODESIZE = 10000;
	public static final int MEMSIZE = 10000;

	private final int[] code;
	private final int[] memory = new int[MEMSIZE];

	private int ip = 0;
	private int sp = MEMSIZE;
	private int hp = 0;

	public ExecuteVM(int[] code) {
		this.code = code;
	}

	private int pop() {
		return memory[sp++];
	}

	private void push(int v) {
		memory[--sp] = v;
	}

	public void evaluate() {
		while ( true ) {
			if(hp+1>=sp) {
				System.out.println("\nError: Out of memory");
				return;
			}
			else {
				int bytecode = code[ip++]; // fetch
				int v1,v2;
				switch (bytecode) {
					case SVMParser.PUSH -> push(code[ip++]);
					case SVMParser.POP -> pop();
					case SVMParser.ADD -> {
						v1 = pop();
						v2 = pop();
						push(v2 + v1);
					}
					case SVMParser.MULT -> {
						v1 = pop();
						v2 = pop();
						push(v2 * v1);
					}
					case SVMParser.DIV -> {
						v1 = pop();
						v2 = pop();
						push(v2 / v1);
					}
					case SVMParser.SUB -> {
						v1 = pop();
						v2 = pop();
						push(v2 - v1);
					}
					case SVMParser.LT -> {
						v1 = pop();
						v2 = pop();
						push((v2 < v1)?1:0);
					}
					case SVMParser.LTE -> {
						v1 = pop();
						v2 = pop();
						push((v2 <= v1)?1:0);
					}
					case SVMParser.GT -> {
						v1 = pop();
						v2 = pop();
						push((v2 > v1)?1:0);
					}
					case SVMParser.GTE -> {
						v1 = pop();
						v2 = pop();
						push((v2 >= v1)?1:0);
					}
					case SVMParser.EQ -> {
						v1 = pop();
						v2 = pop();
						push((v2 == v1)?1:0);
					}
					case SVMParser.NEQ -> {
						v1 = pop();
						v2 = pop();
						push((v2 != v1)?1:0);
					}
					case SVMParser.OR -> {
						v1 = pop();
						v2 = pop();
						push((v2 + v1 != 0)?1:0);
					}
					case SVMParser.NOT -> {
						v1 = pop();
						push((v1 == 1)?0:1);
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
