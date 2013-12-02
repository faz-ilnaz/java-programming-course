package com.kpfu.itis.CyclicBarrier;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierCounter {
	final CyclicBarrier barrierTest;

	static List<Integer> list = new CopyOnWriteArrayList<>();

	CyclicBarrierCounter() {
		barrierTest = new CyclicBarrier(3, new Runnable() {
			public void run() {
				addListvalue();
			}
		});
		new Thread(new Counter(0, 333333, barrierTest)).start();
		new Thread(new Counter(333333, 666666, barrierTest)).start();
		new Thread(new Counter(666666, 1000000, barrierTest)).start();
	}

	void addListvalue() {
		int total = 0;
		for (Integer aList : list) {
			total += aList;
		}
		System.out.println("Total addtion:" + total);
	}

	static void add(int count) {
		list.add(count);
		System.out.println("Per Thread Addition:" + count);
	}

}
