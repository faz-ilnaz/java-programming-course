import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SummFinder extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;

	private static final int SEQUENTIAL_THRESHOLD = 3;

	private final int[] data;
	private final int start;
	private final int end;

	public SummFinder(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	public SummFinder(int[] data) {
		this(data, 0, data.length);
	}

	@Override
	protected Integer compute() {
		final int length = end - start;
		if (length < SEQUENTIAL_THRESHOLD) {
			return computeDirectly();
		}
		final int split = length / 2;
		final SummFinder left = new SummFinder(data, start, start + split);
		final SummFinder right = new SummFinder(data, start + split, end);

		ForkJoinTask.invokeAll(left, right);
		return (right.join() + left.join());

	}

	private Integer computeDirectly() {
		System.out.println(Thread.currentThread() + " computing: " + start
				+ " to " + end);
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += data[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		// create a random data set
		final int[] data = new int[100];
		final Random random = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(100);
		}

		// submit the task to the pool
		final ForkJoinPool pool = new ForkJoinPool(4);
		final SummFinder finder = new SummFinder(data);

		// getting the result
		int result = pool.invoke(finder);
		
		System.out.println("Result: " + result);
		
		// comparing result
		System.out.println(check(data, result));
	}

	private static boolean check(int[] a, int sum) {

		int sum2 = 0;

		for (int i = 0; i < a.length; i++) {
			sum2 += a[i];
		}

		System.out.println("REAL = " + sum2);

		return sum == sum2;
	}
}
