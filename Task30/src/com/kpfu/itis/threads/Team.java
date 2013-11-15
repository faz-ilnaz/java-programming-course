package com.kpfu.itis.threads;

import java.util.concurrent.TimeUnit;

public class Team implements Runnable {

	private String name;

	public Team(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < 60; j += 10) {
				try {
					TimeUnit.MILLISECONDS.sleep((long) (1000 * Math.random()));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("#" + i + "," + name + "," + j);
			}
		}
		System.out.println(name + " has finished!");
	}

}
