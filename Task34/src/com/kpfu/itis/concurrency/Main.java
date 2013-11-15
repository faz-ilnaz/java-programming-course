package com.kpfu.itis.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Main {

	private static AtomicReferenceArray<Double> avg = new AtomicReferenceArray<>(
			3);

	public static void main(String[] args) throws InterruptedException {

		// количество потоков
		int n = 3;

		// 1 : с помощью Runnable
		Thread[] t = new Thread[n];
		for (int i = 0; i < n; i++) {
			t[i] = new Thread(new Counter(i, "input/group" + (i + 1) + ".txt"));
			t[i].start();
		}

		for (int i = 0; i < n; i++) {
			t[i].join();
		}

		System.out.println("Runnable result:");
		for (int i = 0; i < n; i++) {
			System.out.println("Group " + (i + 1) + ": " + avg.get(i));
		}

		System.out.println();

		// 2 : с помощью Callable, Future, ExecutorService

		ExecutorService exec = Executors.newFixedThreadPool(n);
		List<Future<Double>> results = new ArrayList<>();

		for (int i = 0; i < n; i++)
			results.add(exec.submit(new CallableCounter("input/group" + (i + 1)
					+ ".txt")));

		System.out.println("Callable, Future, ExecutorService result:");
		for (int i = 0; i < n; i++) {
			try {
				System.out.println("Group " + (i + 1) + ": "
						+ results.get(i).get());
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

	}

	public static void updateAvg(int i, double num) {
		avg.getAndSet(i, num);
	}

}
