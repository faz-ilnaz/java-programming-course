package com.kpfu.itis.concurrency;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FReader implements Runnable {

	private String filename;

	public FReader(String filename) {
		this.filename = filename;
	}

	@Override
	public void run() {
		File file = null;
		LineNumberReader lnr = null;
		
		// хранит номер строки
		int linesCount = 0;

		try {
			file = new File(filename);
			lnr = new LineNumberReader(new FileReader(file));

			while (lnr.readLine() != null) {
				linesCount = lnr.getLineNumber();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (lnr != null) {
				try {
					lnr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Количество строк в файле " + filename + ": "
				+ linesCount);

	}

}
