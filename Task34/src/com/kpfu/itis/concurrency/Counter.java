package com.kpfu.itis.concurrency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Counter implements Runnable {

	private double avg;
	private String fileName;
	private int i;

	public Counter(int i, String fileName) {
		this.fileName = fileName;
		this.i = i;
	}

	@Override
	public void run() {
		BufferedReader in = null;

		int sum = 0;
		int counter = 0;

		try {
			in = new BufferedReader(new FileReader(fileName));

			String str = in.readLine();
			while (str != null) {
				int ball = Integer.parseInt(str.substring(str.indexOf("-")+1));
				sum += ball;
				counter++;
				str = in.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		avg = 1.0 * sum / counter;
		updateAvg();

	}

	private void updateAvg() {
		Main.updateAvg(i, avg);
	}

}
