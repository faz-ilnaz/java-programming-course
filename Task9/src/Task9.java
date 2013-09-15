import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task9 {

	public static void main(String[] args) throws IOException {

		BufferedWriter out = null;
		Scanner sc = null;

		try {
			out = new BufferedWriter(new FileWriter("output.txt"));
			sc = new Scanner(new FileInputStream("input.txt"));
			int n = sc.nextInt();
			int[][] a = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
				};
			}
			
			Magic square = new Magic(a);
			if(square.isMagic()) {
				out.write("YES");
			} else {
				out.write("NO");				
			}

		} finally {
			sc.close();
			out.close();
		}
	}

}
