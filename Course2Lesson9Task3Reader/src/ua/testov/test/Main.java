package ua.testov.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		File file = new File("test.txt");
		String text = readText(file);
		List<RepeatLetter> list = new ArrayList<>();
		RepeatLetter.setStr(text);
		for (char i = 'a'; i <= 'z'; i++) {
         	list.add(new RepeatLetter(i));
    }
		
		ExecutorService exec=Executors.newFixedThreadPool(3);
		List<Integer> res=new ArrayList<>();
		
		try {
			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
				Future<Integer> future=exec.submit(list.get(i));
				try {
					res.add(future.get());
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		
//		for (Future<Integer> future : res) {
//			try {
//				System.out.println(future.get());
//			} catch (InterruptedException | ExecutionException e) {
//				e.printStackTrace();
//			}
//		}
		}finally {
			exec.shutdown();
		}
		Collections.sort(list);
		System.out.println(list);
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
