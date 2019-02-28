package ua.testov.test;

import java.util.Comparator;

public class RepeatLetter implements Comparable<RepeatLetter> {
	private char x;
	private int y = 0;

	public RepeatLetter() {
		super();
	}

	public RepeatLetter(char x) {
		super();
		this.x = x;
	}

	public int countSymbols(String text) {
		char[] array = text.toCharArray();
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

}
