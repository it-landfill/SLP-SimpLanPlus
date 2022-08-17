package interpreter;

import SVM_parser.SVMParser;

import java.nio.ByteBuffer;

public class ExecuteVM {

	public static final int CODESIZE = 10000;
	public static final int MEMSIZE = 10000;

	private final int[] code;

	private final byte[] memory = new byte[MEMSIZE];

	private final int[] t = new int[10]; // Implemento solo i registri t0 - t9

	private int ip = 0;
	private int sp = MEMSIZE - 1, fp = MEMSIZE - 1, ra = MEMSIZE - 1;

	public ExecuteVM(int[] code) {
		this.code = code;
	}

	private static byte[] intToBytes(int i) {
		return ByteBuffer.allocate(4).putInt(i).array();
	}

	private static int bytesToInt(byte[] b) {
		return ByteBuffer.wrap(b).getInt();
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

	private boolean saveInt(int point, int off, int reg) {
		int pos = readReg(point) + off;
		return saveInt(pos, reg);
	}

	private boolean saveInt(int addr, int reg) {
		if (addr + 3 >= MEMSIZE || addr < 0) return false;
		int val = readReg(reg);
		byte[] bytes = intToBytes(val);
		System.arraycopy(bytes, 0, memory, addr, 4);
		return true;
	}

	private boolean saveBool(int point, int off, int reg) {
		int pos = readReg(point) + off;
		return saveBool(pos, reg);
	}

	private boolean saveBool(int addr, int reg) {
		int val = readReg(reg);
		if (addr >= MEMSIZE || addr < 0) return false;
		if (val != 0) memory[addr] = 1;
		else memory[addr] = 0;
		return true;
	}

	private boolean loadInt(int point, int off, int reg) {
		int pos = readReg(point) + off;
		return loadInt(pos, reg);
	}

	private boolean loadInt(int addr, int reg) {
		if (addr + 3 >= MEMSIZE || addr < 0) return false;
		byte[] bytes = new byte[4];
		System.arraycopy(memory, addr, bytes, 0, 4);
		writeReg(reg, bytesToInt(bytes));
		return true;
	}

	private boolean loadBool(int point, int off, int reg) {
		int pos = readReg(point) + off;
		return loadBool(pos, reg);
	}

	private boolean loadBool(int addr, int reg) {
		if (addr >= MEMSIZE || addr < 0) return false;
		int val = memory[addr];
		writeReg(reg, val);
		return true;
	}

	private boolean popInt() {
		boolean ret = loadInt(sp + 1, code[ip++]);
		sp += 4;
		return ret;
	}

	private boolean popBool() {
		sp += 1;
		return loadBool(sp, code[ip++]);
	}

	private boolean topInt() {
		return loadInt(sp + 1, code[ip++]);
	}

	private boolean topBool() {
		return loadBool(sp + 1, code[ip++]);
	}

	private boolean pushInt() {
		boolean ret = saveInt(sp - 3, code[ip++]);
		sp -= 4;
		return ret;
	}

	private boolean pushBool() {
		boolean ret = saveBool(sp, code[ip++]);
		sp -= 1;
		return ret;
	}

	private void outOfMemoryError(String msg) {
		System.out.println("\n[ERROR] Out of memory" + (msg.equals("") ? "." : " with instruction " + msg + "."));
	}

	private void outOfMemoryError() {
		outOfMemoryError("");
	}

	/*
	 * Le seguenti operazioni non sono implementate poiché convertite in altre operazioni in SVMVisitorImpl
	 * neq -> eq + not
	 * */
	public boolean evaluate() {
		int maxSP = MEMSIZE - 1;
		long startTime = System.currentTimeMillis();

		while (true) {
			if (sp == 0) {
				outOfMemoryError();
				return false;
			} else {
				maxSP = Math.min(maxSP, sp);
				int bytecode = code[ip++]; // fetch
				int rd, r1, r2, val;
				switch (bytecode) {
					case SVMParser.PUSHINT -> {
						if (!pushInt()) {
							outOfMemoryError("PushInt");
							return false;
						}

					}
					case SVMParser.POPINT -> {
						if (!popInt()) {
							outOfMemoryError("PopInt");
							return false;
						}
					}
					case SVMParser.TOPINT -> {
						if (!topInt()) {
							outOfMemoryError("TopInt");
							return false;
						}
					}
					case SVMParser.PUSHBOOL -> {
						if (!pushBool()) {
							outOfMemoryError("PushBool");
							return false;
						}
					}
					case SVMParser.POPBOOL -> {
						if (!popBool()) {
							outOfMemoryError("PopBool");
							return false;
						}
					}
					case SVMParser.TOPBOOL -> {
						if (!topBool()) {
							outOfMemoryError("TopBool");
							return false;
						}
					}
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
						if (val + readReg(r2) + 3 >= ExecuteVM.MEMSIZE || val + readReg(r2) < 0) {
							System.out.println("\n[ERROR] Trying to access memory address out of range. IP: " + ip + " Bytecode: " + bytecode);
							return false;
						}
						loadInt(r2, val, r1);
					}
					case SVMParser.SW -> {
						r1 = code[ip++];
						val = code[ip++];
						r2 = code[ip++];
						if (val + readReg(r2) + 3 >= ExecuteVM.MEMSIZE || val + readReg(r2) < 0) {
							System.out.println("\n[ERROR] Trying to access memory address out of range. IP: " + ip + " Bytecode: " + bytecode);
							return false;
						}
						saveInt(r2, val, r1);
					}
					case SVMParser.LB -> {
						r1 = code[ip++];
						val = code[ip++];
						r2 = code[ip++];
						if (val + readReg(r2) >= ExecuteVM.MEMSIZE || val + readReg(r2) < 0) {
							System.out.println("\n[ERROR] Trying to access memory address out of range. IP: " + ip + " Bytecode: " + bytecode);
							return false;
						}
						loadBool(r2, val, r1);
					}
					case SVMParser.SB -> {
						r1 = code[ip++];
						val = code[ip++];
						r2 = code[ip++];
						if (val + readReg(r2) >= ExecuteVM.MEMSIZE || val + readReg(r2) < 0) {
							System.out.println("\n[ERROR] Trying to access memory address out of range. IP: " + ip + " Bytecode: " + bytecode);
							return false;
						}
						saveBool(r2, val, r1);
					}
					case SVMParser.ADD -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, r1 + r2);
					}
					case SVMParser.ADDI -> {
						rd = code[ip++];
						r1 = code[ip++];
						val = code[ip++];
						r1 = readReg(r1);
						writeReg(rd, r1 + val);
					}
					case SVMParser.SUB -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, r1 - r2);
					}
					case SVMParser.SUBI -> {
						rd = code[ip++];
						r1 = code[ip++];
						val = code[ip++];
						r1 = readReg(r1);
						writeReg(rd, r1 - val);
					}
					case SVMParser.MULT -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						writeReg(rd, r1 * r2);
					}
					case SVMParser.MULTI -> {
						rd = code[ip++];
						r1 = code[ip++];
						val = code[ip++];
						r1 = readReg(r1);
						writeReg(rd, r1 * val);
					}
					case SVMParser.DIV -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						if (r2 == 0) {
							System.out.println("\n[ERROR] Trying to divide by zero. IP: " + ip + " Bytecode: " + bytecode);
							return false;
						}
						writeReg(rd, r1 / r2);
					}
					case SVMParser.DIVI -> {
						rd = code[ip++];
						r1 = code[ip++];
						val = code[ip++];
						r1 = readReg(r1);
						if (val == 0) {
							System.out.println("\n[ERROR] Trying to divide by zero. IP: " + ip + " Bytecode: " + bytecode);
							return false;
						}
						writeReg(rd, r1 / val);
					}
					case SVMParser.MOD -> {
						rd = code[ip++];
						r1 = code[ip++];
						r2 = code[ip++];
						r1 = readReg(r1);
						r2 = readReg(r2);
						if (r2 == 0) {
							System.out.println("\n[ERROR] Trying to divide by zero. IP: " + ip + " Bytecode: " + bytecode);
							return false;
						}
						writeReg(rd, r1 % r2);
					}
					case SVMParser.MODI -> {
						rd = code[ip++];
						r1 = code[ip++];
						val = code[ip++];
						r1 = readReg(r1);
						if (val == 0) {
							System.out.println("\n[ERROR] Trying to divide by zero. IP: " + ip + " Bytecode: " + bytecode);
							return false;
						}
						writeReg(rd, r1 % val);
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
					}
					case SVMParser.NEG -> {
						rd = code[ip++];
						r1 = code[ip++];
						r1 = readReg(r1);
						writeReg(rd, -1 * r1);
					}
					case SVMParser.PRINTW -> {
						rd = code[ip++];
						System.out.println(readReg(rd));
					}
					case SVMParser.PRINTB -> {
						rd = code[ip++];
						System.out.println(readReg(rd) != 0 ? "true" : "false");
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
						long endTime = System.currentTimeMillis();
						int usedMem = MEMSIZE-maxSP+1;
						double usedPercent = (usedMem / (double)MEMSIZE)*100;
						System.out.println("\n[INFO] Program terminated correctly.");
						System.out.println("[INFO] Your program used " + usedMem + "/" + MEMSIZE + " bytes of memory. (" + usedPercent + " %)");
						System.out.println("[INFO] Your program took ~" + (endTime - startTime) + " ms to complete.");
						return true;
					}
					default -> {
						System.out.println("[ERROR] Not a valid instruction " + bytecode + " at position " + ip + ".\nAborting execution...");
						return false;
					}
				}
			}
		}
	}
}
