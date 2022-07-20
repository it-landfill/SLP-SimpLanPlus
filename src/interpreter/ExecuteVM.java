package interpreter;

import SLP_ast.STentry;
import SVM_parser.SVMParser;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.HashMap;

public class ExecuteVM {

	public static final int CODESIZE = 10000;
	public static final int MEMSIZE = 10000;

	private final int[] code;

	private final byte[] memory = new byte[MEMSIZE];

	private final int[] t = new int[10]; // Implemento solo i registri t0 - t9

	private int ip = 0;
	private int sp = MEMSIZE-1, fp = MEMSIZE-1, ra = MEMSIZE-1;

	private int hp = 0;

	private static byte[] intToBytes(int i) {
		return ByteBuffer.allocate(4).putInt(i).array();
	}

	private static int bytesToInt(byte[] b) {
		return ByteBuffer.wrap(b).getInt();
	}

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
		switch (reg) {
			case -1 -> fp = val;
			case -2 -> sp = val;
			case -3 -> ra = val;
			case -4 -> ip = val;
			default -> t[reg] = val;
		}
	}

	private void saveInt(int point, int off, int reg) {
		int val = readReg(reg);
		byte[] bytes = intToBytes(val);
		int pos = readReg(point) + off;
		System.arraycopy(bytes, 0, memory, pos, 4);
	}

	private void saveInt(int addr, int reg) {
		int val = readReg(reg);
		byte[] bytes = intToBytes(val);
		System.arraycopy(bytes, 0, memory, addr, 4);
	}

	private void saveBool(int point, int off, int reg) {
		int val = readReg(reg);
		int pos = readReg(point) + off;
		if (val != 0) memory[pos] = 1;
		else memory[pos] = 0;
	}

	private void saveBool(int addr, int reg) {
		int val = readReg(reg);
		if (val != 0) memory[addr] = 1;
		else memory[addr] = 0;
	}

	private void loadInt(int point, int off, int reg) {
		byte[] bytes = new byte[4];
		int pos = readReg(point) + off;
		System.arraycopy(memory, pos, bytes, 0, 4);
		writeReg(reg, bytesToInt(bytes));
	}

	private void loadInt(int addr, int reg) {
		byte[] bytes = new byte[4];
		System.arraycopy(memory, addr, bytes, 0, 4);
		writeReg(reg, bytesToInt(bytes));
	}

	private void loadBool(int point, int off, int reg) { // TODO: Posso unificare la logica delle funzioni facendo chiamare ad una l'altra??
		int pos = readReg(point) + off;
		int val = memory[pos];
		writeReg(reg, val);
	}

	private void loadBool(int addr, int reg) {
		int val = memory[addr];
		writeReg(reg, val);
	}

	private void popInt() {
		loadInt(sp+1,code[ip++]);
		sp+=4;
	}

	private void popBool() {
		sp+=1;
		loadBool(sp, code[ip++]);
	}

	private void topInt() {
		loadInt(sp+1, code[ip++]);
	}

	private void topBool() {
		loadBool(sp+1, code[ip++]);
	}

	private void pushInt() {
		saveInt(sp-3, code[ip++]);
		sp-=4;
	}

	private void pushBool() {
		saveBool(sp, code[ip++]);
		sp-=1;
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
					case SVMParser.PUSHINT -> pushInt();
					case SVMParser.POPINT -> popInt();
					case SVMParser.TOPINT -> topInt();
					case SVMParser.PUSHBOOL -> pushBool();
					case SVMParser.POPBOOL -> popBool();
					case SVMParser.TOPBOOL -> topBool();
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
						r1 = code[ip++];
						val = code[ip++];
						r2 = code[ip++];

						if (memory[val+readReg(r2)] == -10000) { // FIXME: Questa condizione ha senso?
							System.out.println("\nError: Null pointer exception");
							return false;
						}
						loadInt(r2, val, r1);
					}
					case SVMParser.SW -> {
						r1 = code[ip++];
						val = code[ip++];
						r2 = code[ip++];
						saveInt(r2, val, r1);
					}
					case SVMParser.LB -> {
						r1 = code[ip++];
						val = code[ip++];
						r2 = code[ip++];

						if (memory[val+readReg(r2)] == -10000) { // FIXME: Questa condizione ha senso?
							System.out.println("\nError: Null pointer exception");
							return false;
						}
						loadBool(r2, val, r1);
					}
					case SVMParser.SB -> {
						r1 = code[ip++];
						val = code[ip++];
						r2 = code[ip++];
						saveBool(r2, val, r1);
					}
					case SVMParser.ADD -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, r1+r2);
					}
					case SVMParser.ADDI -> {
						rd = code[ip++];
						r1 = code[ip++];
						val = code[ip++];
						r1 = readReg(r1);
						writeReg(rd, r1+val);
					}
					case SVMParser.SUB -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, r1-r2); //FIXME: Come gestisco negativi?
					}
					case SVMParser.SUBI -> {
						rd = code[ip++];
						r1 = code[ip++];
						val = code[ip++];
						r1 = readReg(r1);
						writeReg(rd, r1-val);
					}
					case SVMParser.MULT -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, r1*r2);
					}
					case SVMParser.MULTI -> {
						rd = code[ip++];
						r1 = code[ip++];
						val = code[ip++];
						r1 = readReg(r1);
						writeReg(rd, r1*val);
					}
					case SVMParser.DIV -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, r1/r2);
					}
					case SVMParser.DIVI -> {
						rd = code[ip++];
						r1 = code[ip++];
						val = code[ip++];
						r1 = readReg(r1);
						writeReg(rd, r1/val);
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
					case SVMParser.PRINTW -> {
						rd = code[ip++];
						System.out.println(readReg(rd));
					}
					case SVMParser.PRINTB -> {
						rd = code[ip++];
						System.out.println(readReg(rd) == 1 ? "true" : "false");
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
