import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) throws IOException {
		BufferedWriter out = null;
		Scanner sc = null;
		int n = read();
		try {
			out = new BufferedWriter(new FileWriter("output.txt"));
			for (int i = 1; i < n; i++) {
				try {
					sc = new Scanner(new FileInputStream("tempDZGsvBYFc" + i + ".txt"));
					String name = sc.nextLine();
					int total = 0;
					for(int j = 0; j < 10; j++) {
						total += sc.nextInt();
					}
					out.append(name + " " + total + "\n");
				} finally {
					sc.close();
				}
			}			
		} finally {
			out.close();
		}
		
		clearTempFiles();

	}
	
	static int read() throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		int n = 1;
		for (int i = 0; i < 10; i++) {
			try {
				in = new BufferedReader(new FileReader("input" + i + ".txt"));
				String str = in.readLine();
				n = 1;
				while (str != null) {
					try {
						out = new BufferedWriter(new FileWriter("tempDZGsvBYFc" + n + ".txt", true));
						if (i == 0) {
							out.write(str.split(" ")[0] + "\n");
						}
						out.write(str.split(" ")[1] + "\n");
					} finally {
						out.close();
					}
					str = in.readLine();
					n++;
				}
			} finally {
				in.close();
			}
		}
		return n;
	}
	
	static void clearTempFiles() {
		File file = new File(".");
		File[] files = file.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.contains("tempDZGsvBYFc")) {
					return true;
				}
				return false;
			}
		});
		for(File file1: files) {
			file1.delete();
		}
	}

}
