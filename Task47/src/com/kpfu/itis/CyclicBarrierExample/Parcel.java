package com.kpfu.itis.CyclicBarrierExample;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Parcel implements Runnable {

	String treckingNum;
	PostMan postMan;

	public Parcel(String treckingNum, PostMan pm) {
		this.treckingNum = treckingNum;
		this.postMan = pm;
	}

	@Override
	public void run() {
		Random r = new Random();
		try {
			TimeUnit.MILLISECONDS.sleep((long) (r.nextInt(20000)));
			System.out.println(treckingNum + " has come!");
			postMan.toDeliveryList(treckingNum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
