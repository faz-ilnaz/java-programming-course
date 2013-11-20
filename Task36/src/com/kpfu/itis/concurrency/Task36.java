package com.kpfu.itis.concurrency;

import java.util.Random;

public class Task36 {

	// bill
	static Bill bill = new Bill(3000);

	public static void main(String[] args) throws InterruptedException {

		// count of users
		int n = 2;

		// users
		Thread[] users = new Thread[n];

		Random r = new Random();

		for (int i = 0; i < n; i++) {
			users[i] = new Thread(new User(i + 1, (r.nextInt(3) + 1) * 1000));
			users[i].start();
		}

		for (int i = 0; i < n; i++) {
			users[i].join();
		}

		System.out.println("On the bill " + bill.getCashCount());
	}

}
