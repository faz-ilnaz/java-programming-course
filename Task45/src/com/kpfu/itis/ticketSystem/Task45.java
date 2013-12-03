package com.kpfu.itis.ticketSystem;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Task45 {

	public static void main(String[] args) {

		// количество покупателей
		int n = 20;

		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(20);

		final TicketWindow tw = new TicketWindow();

		final Random r = new Random();

		for (int i = 0; i < n; i++) {
			Thread t = new Thread("Consumer #" + i) {
				public void run() {
					try {
						// ждем стартовой команды
						startGate.await();

						int row;
						int place;

						// покупатель пытается купить билет на рандомном месте
						do {
							row = r.nextInt(tw.getN());
							place = r.nextInt(tw.getN());

						} while (!tw.buyTicket(row, place));

						System.out.println(getName() + " has bought a ticket["
								+ row + ", " + place + "]");

						endGate.countDown();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
		}

		// одновременный старт
		startGate.countDown();
		

		try {
			// ждем пока все покупатели приобретут билеты
			endGate.await();

			// выводим заполненность кинозала
			tw.printOccupancy();

			// выводим прибыль кинотеатра
			tw.printTotalCash();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
