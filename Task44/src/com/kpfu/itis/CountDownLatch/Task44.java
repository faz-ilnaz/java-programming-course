package com.kpfu.itis.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Task44 {

	public static void main(String[] args) {
		int n = 5;
		final CountDownLatch startGate = new CountDownLatch(1);

		final CountDownLatch endTimer = new CountDownLatch(n);

		for (int i = 0; i < n; i++) {
			Thread t = new Thread("Car #" + i) {
				public void run() {
					try {
						// ждем стартовой команды
						startGate.await();
						for (int i = 0; i < 20; i++) {
							TimeUnit.MILLISECONDS.sleep((long) (500 * Math
									.random()));
							System.out.printf("%s Lap %d%n", getName(), i);
						}
						endTimer.countDown();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
		}
		// одновременный старт
		long startTime = System.nanoTime();
		startGate.countDown();

		try {
			endTimer.await();
			long elapsedTime = System.nanoTime() - startTime;
			double seconds = (double) elapsedTime / 1000000000.0;
			System.out.println("The worst time: " + seconds + "s");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
