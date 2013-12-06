package com.kpfu.itis.CyclicBarrierExample;

public class Task47 {

	public static void main(String[] args) {
		
		// создаем курьера
		PostMan pm = new PostMan(10);
		
		// запускаем посылки
		for(int i = 0; i < 40; i++) {
			new Thread(new Parcel("USPS" + i, pm)).start();
		}
		
		
	}

}
