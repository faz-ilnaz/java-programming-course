import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Task42 {

	public static void main(String[] args) throws InterruptedException {
		int n = 15;
		
		final CountDownLatch startGate = new CountDownLatch(10);
		
		
		Thread concert = new Thread() {
			public void run() {
				try {
					// ждем минимум 10 зрителей
					startGate.await();
					System.out.println("Concert has started!");
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		concert.start();
		
		
		for (int i = 0; i < n; i++) {
			TimeUnit.MILLISECONDS.sleep((long) (1000 * Math.random()));
			
			// зрители останавливаются, чтобы послушать уличных музыкантов
			System.out.println("Viewer " + (i+1) + " has come");
			
			startGate.countDown();
		}
		
	}

}
