package com.kpfu.itis.CyclicBarrierExample;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class PostMan {

	CyclicBarrier barrierTest;
	List<String> list = new CopyOnWriteArrayList<>();

	public PostMan(int n) {
		barrierTest = new CyclicBarrier(n, new Runnable() {
			public void run() {
				System.out.println("Delivering " + list);
				list.clear();
			}
		});
	}

	public void toDeliveryList(String treckingNum) {
		list.add(treckingNum);
		try {
			barrierTest.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
