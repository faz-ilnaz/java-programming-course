import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task38 {

	static String gmail = "<your_gmail>";
	static String pass = "<your_pass>";
	static String smtpHost = "smtp.gmail.com";
	static String smtpPort = "465";

	static String toAddress = gmail;
	static String subject = "Task38";

	public static void main(String[] args) {
		// Creating BlockingQueue of size 10
		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);

		Consumer consumer = new Consumer(queue);

		// count of producers
		int n = 2;

		Producer[] producer = new Producer[n];
		for (int i = 0; i < n; i++) {
			producer[i] = new Producer(queue, i);
		}

		ExecutorService executor = Executors.newFixedThreadPool(n);

		// starting producer to produce messages in queue
		for (int i = 0; i < n; i++) {
			executor.submit(producer[i]);
		}

		executor.shutdown();

		System.out.println("Producer has been started");

		// starting consumer to consume messages from queue
		new Thread(consumer).start();

		System.out.println("Consumer has been started");
	}

}