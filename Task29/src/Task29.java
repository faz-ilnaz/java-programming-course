public class Task29 {

	public static void main(String[] args) {
		int n = 5;

		Car[] car = new Car[n];
		Thread[] myCar = new Thread[n];
		for (int i = 0; i < n; i++) {
			car[i] = new Car(i+1);
			myCar[i] = new Thread(car[i]);
			myCar[i].start();
		}

	}

}
