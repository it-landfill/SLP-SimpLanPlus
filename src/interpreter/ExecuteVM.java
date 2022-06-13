package interpreter;

import SLP_ast.STentry;
import SVM_parser.SVMParser;

import java.util.ArrayDeque;
import java.util.HashMap;

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
					case SVMParser.PUSH:
						push();
						break;
					case SVMParser.POP:
						pop();
						break;
					case SVMParser.TOP:
						top();
						break;
					case SVMParser.LI:
						rd = code[ip++];
						val = code[ip++];
						t[rd] = val;
						break;
					case SVMParser.MOV:
						rd = code[ip++];
						r1 = code[ip++];
						t[rd] = t[r1];
						break;
					case SVMParser.LW:
						rd = code[ip++];
						val = code[ip++];
						if (memory[val] == -10000) {
							System.out.println("\nError: Null pointer exception");
							return false;
						}
						t[rd] = memory[val];
						break;
					case SVMParser.SW:
						r1 = code[ip++];
						val = code[ip++];
						memory[val] = t[r1];
						break;
					case SVMParser.ADD:
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = t[r1] + t[r2];
						break;
					case SVMParser.SUB:
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = t[r1] - t[r2]; //FIXME: Come gestisco negativi?
						break;
					case SVMParser.MULT:
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = t[r1] * t[r2];
						break;
					case SVMParser.DIV:
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = t[r1] / t[r2]; //FIXME: Come gestisco il resto della divisione?
						break;
					case SVMParser.LT:
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] < t[r2]) ? 1 : 0;
						break;
					case SVMParser.LTE:
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] <= t[r2]) ? 1 : 0;
						break;
					case SVMParser.GT:
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] > t[r2]) ? 1 : 0;
						break;
					case SVMParser.GTE:
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] >= t[r2]) ? 1 : 0;
						break;
					case SVMParser.EQ:
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] == t[r2]) ? 1 : 0;
						break; //Non abbiamo neq perchè viene convertita in una eq negata in SVMVisitorImpl
					case SVMParser.AND:
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] + t[r2] == 2) ? 1 : 0;
						break;
					case SVMParser.OR:
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						t[rd] = (t[r1] + t[r2] != 0) ? 1 : 0;
						break;
					case SVMParser.NOT:
						rd = code[ip++];
						r1 = code[ip++];
						t[rd] = (t[r1] == 1) ? 0 : 1;
						break;
					case SVMParser.NEG:
						rd = code[ip++];
						r1 = code[ip++];
						t[rd] = t[r1] * -1;
						break;
					case SVMParser.PRINT:
						rd = code[ip++];
						System.out.println(t[rd]);
						break;
					case SVMParser.JAL:
						ip = code[ip];
						break;
					case SVMParser.JR:
						ip = t[code[ip]];
						break;
					case SVMParser.BEQ:
						r1 = code[ip++];
						r2 = code[ip++];
						rd = code[ip++];
						if (t[r1] == t[r2]) ip = rd;
						break;
					case SVMParser.HALT:
						//to print the result
						System.out.println("\nEnd program");
						return true;
					default:
						System.out.println("[ERROR] Not a valid instruction " + bytecode + " at position " + ip + ".Terminating");
						return false;
				}
			}
		}
	}
}
