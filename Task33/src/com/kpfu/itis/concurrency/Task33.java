package com.kpfu.itis.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Task33 {

	private static AtomicInteger totalCount = new AtomicInteger();
	private static int count;

	public static void main(String[] args) throws InterruptedException {

		// количество потоков
		int n = 3;

		// 1 : с помощью Runnable
		Thread[] t = new Thread[n];
		t[0] = new Thread(new Counter(0, 333333));
		t[1] = new Thread(new Counter(333333, 666666));
		t[2] = new Thread(new Counter(666666, 1000000));
		for (int i = 0; i < n; i++) {
			t[i].start();
		}

		for (int i = 0; i < n; i++) {
			t[i].join();
		}

		System.out.println("Runnable result: " + totalCount.get());

		// 2 : с помощью Callable, Future, ExecutorService

		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<Integer>> results = new ArrayList<>();

		CallableCounter[] cc = new CallableCounter[n];

		cc[0] = new CallableCounter(0, 333333);
		cc[1] = new CallableCounter(333333, 666666);
		cc[2] = new CallableCounter(666666, 1000000);

		for (int i = 0; i < n; i++)
			results.add(exec.submit(cc[i]));

		for (Future<Integer> fs : results)

			try {
				// Вызов get() блокируется до завершения;:
				count += fs.get();
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}

		System.out.println("Callable, Future, ExecutorService result: " + count);

	}

	public static void setTotalCount(int count) {
		totalCount.addAndGet(count);
	}

}
