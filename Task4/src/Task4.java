import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// TODO не понял задание. этот код не верен

public class Task4 {

	static Set<Integer> numbers;
	static Random random = new Random();
	
	public static void main(String[] args) throws IOException {
		BufferedReader b_in = null;
		BufferedWriter b_out= null;
		int n = 1000000;
		int max = 10000;
		
		try {
			b_out = new BufferedWriter(new FileWriter("test.txt"));
			
			for(int i = 0; i < n; i++) {
				b_out.write(random.nextInt(max) + "\n");
			}
			
		}
		finally {
			b_out.close();
		}
		
		
		
		try {
			b_in = new BufferedReader(new FileReader("test.txt"));
			b_in.mark(0);
			int num = random.nextInt(10000);
			
			System.out.println(searchTree(b_in, num));
			
			
			b_in.mark(0);
			System.out.println(searchHash(b_in, num));
			
			
			
		}
		finally {
			b_in.close();
			b_out.close();
		}

	}
	
	public static long searchTree(BufferedReader b_in, int some_number) throws IOException {
		b_in.reset();
		numbers = new TreeSet<>();
		String str = b_in.readLine();
		while(str != null) {
			numbers.add(Integer.valueOf(str));
			str = b_in.readLine();
		}
		long time = System.currentTimeMillis();
		numbers.contains(some_number);
		long a_time = System.currentTimeMillis() - time;
		return a_time;
	}
	
	public static long searchHash(BufferedReader b_in, int some_number) throws IOException {
		b_in.reset();
		numbers = new HashSet<>();
		String str = b_in.readLine();
		while(str != null) {
			numbers.add(Integer.valueOf(str));
			str = b_in.readLine();
		}
		long time = System.currentTimeMillis();
		numbers.contains(some_number);
		long a_time = System.currentTimeMillis() - time;
		return a_time;
	}

}
