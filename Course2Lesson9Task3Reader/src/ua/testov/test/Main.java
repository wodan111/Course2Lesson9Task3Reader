package ua.testov.test;

import java.io.File;
import java.io.IOException;
import java.security.Provider.Service;
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
		for (int i = 0; i < 1; i++) {
			list.add(new RepeatLetter('a'));
			list.add(new RepeatLetter('b'));
			list.add(new RepeatLetter('c'));
			list.add(new RepeatLetter('d'));
			list.add(new RepeatLetter('e'));
			list.add(new RepeatLetter('f'));
			list.add(new RepeatLetter('g'));
			list.add(new RepeatLetter('h'));
			list.add(new RepeatLetter('i'));
			list.add(new RepeatLetter('j'));
			list.add(new RepeatLetter('k'));
			list.add(new RepeatLetter('l'));
			list.add(new RepeatLetter('m'));
			list.add(new RepeatLetter('n'));
			list.add(new RepeatLetter('o'));
			list.add(new RepeatLetter('p'));
			list.add(new RepeatLetter('q'));
			list.add(new RepeatLetter('r'));
			list.add(new RepeatLetter('s'));
			list.add(new RepeatLetter('t'));
			list.add(new RepeatLetter('u'));
			list.add(new RepeatLetter('v'));
			list.add(new RepeatLetter('w'));
			list.add(new RepeatLetter('x'));
			list.add(new RepeatLetter('y'));
			list.add(new RepeatLetter('z'));
		}
		
		ExecutorService exec=Executors.newFixedThreadPool(3);
		List<Future<Integer>> res=new ArrayList<>();
		
		try {
			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
				Future<Integer> future=exec.submit(list.get(i));
				res.add(future);
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
