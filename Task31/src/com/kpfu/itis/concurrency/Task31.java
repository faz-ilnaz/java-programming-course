package com.kpfu.itis.concurrency;

import java.util.Scanner;

public class Task31 {

	/*
	 * ПРИМЕЧАНИЕ
	 * на запрос консоли ввести имена файлов можно указать файлы input1.txt,
	 * input2.txt, <...>, находящиеся в корневой папке проекта
	 */

	public static void main(String[] args) {

		// количество потоков
		int n = 3;
		Thread[] t = new Thread[n];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < n; i++) {
			System.out.print("Введите имя файла №" + (i + 1) + ": ");
			String filename = sc.nextLine();

			// String filename = "input" + (i+1) +".txt";

			t[i] = new Thread(new FReader(filename));
		}

		sc.close();

		for (int i = 0; i < n; i++) {
			t[i].start();
		}
	}

}
