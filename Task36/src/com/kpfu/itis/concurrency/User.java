package com.kpfu.itis.concurrency;

public class User implements Runnable {

	private int id;
	private int count;

	public User(int id, int count) {
		this.id = id;
		this.count = count;
	}

	@Override
	public void run() {
		System.out.println("I'm user " + id + " and I try to get " + count
				+ " from the bill. Result: " + Task36.bill.getSomeMoney(count));

	}

}
