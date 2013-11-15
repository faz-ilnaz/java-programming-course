package com.kpfu.itis.concurrency;

import java.util.concurrent.Callable;

public class CallableCounter implements Callable<Integer> {
	
	private int count = 0;
	private int left;
	private int right;

	public CallableCounter(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public Integer call() throws Exception {
		for (int i = left; i < right; i++) {
			if (isLucky(i)) {
				count++;
			}
		}
		return count;
	}
	
	private boolean isLucky(int n) {
		StringBuilder sb = new StringBuilder();
		int len = String.valueOf(n).length();

		for (int i = 0; i < 6 - len; i++) {
			sb.append("0");
		}
		sb.append(n);

		int sum1 = Integer.valueOf(sb.charAt(0))
				+ Integer.valueOf(sb.charAt(1)) + Integer.valueOf(sb.charAt(2));

		int sum2 = Integer.valueOf(sb.charAt(3))
				+ Integer.valueOf(sb.charAt(4)) + Integer.valueOf(sb.charAt(5));

		return sum1 == sum2;
	}

	

}
