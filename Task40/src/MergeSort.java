import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class MergeSort extends RecursiveAction {

	private static final long serialVersionUID = 1L;

	private static final int SEQUENTIAL_THRESHOLD = 3;

	private final int[] data;
	private final int start;
	private final int end;

	public MergeSort(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	public MergeSort(int[] data) {
		this(data, 0, data.length);
	}

	@Override
	protected void compute() {
		final int length = end - start;
		if (length < SEQUENTIAL_THRESHOLD) {
			computeDirectly();
		} else {
			final int split = length / 2;
			final MergeSort left = new MergeSort(data, start, start + split);
			final MergeSort right = new MergeSort(data, start + split, end);
			
			// left.fork();
			// right.fork();
			
			ForkJoinTask.invokeAll(left, right);
			toMerge(left, right);
			
		}

	}

	private void computeDirectly() {
		System.out.println(Thread.currentThread() + " computing: " + start
				+ " to " + end);
		for (int i = start; i < end-1; i++) {
			for (int j = i + 1; j < end; j++) {
				if (data[i] > data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}

		}
	}
	
	private void toMerge(MergeSort l, MergeSort r) {
		
		int i = l.start;
		int j = r.start;
		
		int k = 0;
		int[] c = new int[end - start];
		
		while(i < l.end && j < r.end) {
			if( data[i] > data[j] ) {
				c[k++] = data[j++];
			} else {
				c[k++] = data[i++];
			}
			
		}
		while(i < l.end) {
			c[k++]=data[i++];
		}
		while(j < r.end) {
			c[k++] = data[j++];
		}
		
		k=0;
		for(i = start; i < end;i++) {     // "перезапись" в dаta[]
			data[i]=c[k++];
		};
		
	}

	public static void main(String[] args) {
		
		// create a random data set
		final int[] data = new int[100];
		final Random random = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(100);
		}
		
		System.out.println("Input: ");
		print(data);

//		// submit the task to the pool
		final ForkJoinPool pool = new ForkJoinPool(4);
		final MergeSort finder = new MergeSort(data);
		pool.invoke(finder);
//		
		System.out.println("Output: ");
		print(data);
		System.out.println("Check: " + check(data));
	}
	
	public static void print(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	private static boolean check(int[] a) {
		boolean f = true;
		for(int i = 0; i < a.length - 1 && f; i++) {
			if(a[i] > a[i+1]) {
				f = false;
			}
		}
		return f;
	}
}