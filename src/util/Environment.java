package util;

public class Environment {

	// Current nesting level.
	private static int nestingLevel = -1;
	private int offset;

	public Environment() {
		this.offset = 1;
	}

	public static int getNestingLevel() {
		return nestingLevel;
	}

	public static void incrementNestingLevel() {
		nestingLevel++;
	}

	public static void decrementNestingLevel() {
		nestingLevel--;
	}

	public int getOffset() {
		return offset;
	}

	public void offsetAddInt() {
		this.offset += 4;
	}

	public void offsetAddBool() {
		this.offset += 1;
	}
}