package com.kpfu.itis.threads;

public class Task30 {

	public static void main(String[] args) {
		// количество команд(потоков)
		int n = 3;

		// имена команд
		String[] names = { "Russia", "Sweden", "Japan" };

		Thread[] t = new Thread[n];

		for (int i = 0; i < n; i++) {
			t[i] = new Thread(new Team(names[i]));
			t[i].start();
		}

	}

}
