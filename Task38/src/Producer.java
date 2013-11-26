import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Message> queue;
	private int num;

	public Producer(BlockingQueue<Message> q, int num) {
		this.queue = q;
		this.num = num;
	}

	@Override
	public void run() {
		// produce messages
		for (int i = 0; i < 3; i++) {
			Message msg = new Message("" + (i + num * 3));
			try {
				Thread.sleep(i * 10);
				queue.put(msg);
				System.out.println("Produced " + msg.getMsg());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// adding exit message
		Message msg = new Message("exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}