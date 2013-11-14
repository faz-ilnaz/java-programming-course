
public class Car implements Runnable {

	private int carNum;
	private int lapNum = 1;
	private String mess;

	public Car(int carNum) {
		this.carNum = carNum;
	}

	@Override
	public void run() {
		do {
			try {
				Thread.sleep((long) (1000 * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String message = "Car #" + carNum + ". Lap " + lapNum;
			System.out.println(message);
//			setMess(message);
			lapNum++;

		} while (lapNum < 20);
		
		String message = "[ Car #" + carNum + ". Lap " + lapNum + " ]";
		System.out.println(message);
//		System.out.println("!!! Car #" + carNum + " has finished !!!");

	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}
}
