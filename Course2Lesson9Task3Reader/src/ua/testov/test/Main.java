package ua.testov.test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File file = new File("test.txt");
		String text = readText(file);
	}

	public static String readText(File file) {
		String text = "";
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) {
				text += sc.nextLine();
				text += System.lineSeparator();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
}
