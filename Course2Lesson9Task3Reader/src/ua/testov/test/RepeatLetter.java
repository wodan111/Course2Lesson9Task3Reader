package ua.testov.test;

import java.util.concurrent.Callable;

public class RepeatLetter implements Comparable<RepeatLetter>, Callable<Integer> {
	private char x;
	private int y = 0;
	private static String str;

	public RepeatLetter() {
		super();
	}

	public RepeatLetter(char x) {
		super();
		this.x = x;
	}
	

	public static String getStr() {
		return str;
	}

	public static void setStr(String str) {
		RepeatLetter.str = str;
	}

	public int countSymbols() {
		char[] array = str.toLowerCase().toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x) {
				y = y + 1;
			}
		}
		return y;
	}

	@Override
	public int compareTo(RepeatLetter o) {
		if (this.y > o.y) {
			return -1;
		} else if (this.y < o.y) {
			return 1;
		} else
			return 0;
	}

	@Override
	public Integer call() throws Exception {
		int x=countSymbols();
		return x;
	}

	@Override
	public String toString() {
		return "RepeatLetter [x=" + x + ", y=" + y + "] \n";
	}

}
