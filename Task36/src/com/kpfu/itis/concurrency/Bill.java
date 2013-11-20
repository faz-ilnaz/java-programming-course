package com.kpfu.itis.concurrency;

public class Bill {
	private volatile int cash;

	public Bill(int cash) {
		this.cash = cash;
	}

	public int getCashCount() {
		return cash;
	}

	public synchronized boolean getSomeMoney(int delta) {
		if (cash - delta >= 0) {
			this.cash = cash - delta;
			return true;
		} else {
			return false;
		}
	}

}
