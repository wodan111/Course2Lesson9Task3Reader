package ua.testov.test;

import java.util.Comparator;

public class RepeatLetter implements Comparable<RepeatLetter>{
private char x;
private int y;
public RepeatLetter() {
	super();
}
public RepeatLetter(char x) {
	super();
	this.x = x;
}

@Override
public int compareTo(RepeatLetter o) {
	if(this.y>o.y) {
		return -1;
	}else if(this.y<o.y) {
		return 1;
	}else return 0;
}

}
