package com.kpfu.itis.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task35 {

	/*
	 * ПРИМЕЧАНИЕ на запрос консоли ввести имена файлов можно указать файлы
	 * input1.txt, input2.txt, <...>, находящиеся в корневой папке проекта
	 */

	public static void main(String[] args) {

		// количество потоков
		int n = 3;

		ExecutorService exec = Executors.newFixedThreadPool(n);
		List<Future<Integer>> results = new ArrayList<>();

		String[] names = new String[n];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < n; i++) {
			System.out.print("Введите имя файла №" + (i + 1) + ": ");
			String filename = sc.nextLine();

			// String filename = "input" + (i + 1) + ".txt";

			names[i] = filename;

			results.add(exec.submit(new Call_FReader(filename)));
		}

		sc.close();
		
		System.out.println();
		System.out.println("Callable, Future, ExecutorService result:");
		for (int i = 0; i < n; i++) {
			try {
				System.out.println("Количество строк в файле " + names[i]
						+ ": " + results.get(i).get());
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
		}

	}

}
