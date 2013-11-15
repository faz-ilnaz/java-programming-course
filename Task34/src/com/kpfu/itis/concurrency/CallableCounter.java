package com.kpfu.itis.concurrency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class CallableCounter implements Callable<Double> {

	private double avg;
	private String fileName;

	public CallableCounter(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public Double call() throws Exception {
		BufferedReader in = null;

		int sum = 0;
		int counter = 0;

		try {
			in = new BufferedReader(new FileReader(fileName));

			String str = in.readLine();
			while (str != null) {
				int ball = Integer
						.parseInt(str.substring(str.indexOf("-") + 1));
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
		return avg;
	}

}
