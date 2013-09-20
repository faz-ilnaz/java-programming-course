import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Task10 {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		BufferedReader in = null;
		BufferedWriter o = null;

		try {
			in = new BufferedReader(new FileReader("input.txt"));

			map(in, o);
			reduce();

		} finally {
			in.close();

		}

	}

	public static void map(BufferedReader in, BufferedWriter o)
			throws IOException {

		int num = 0;
		String str = in.readLine();

		while (str != null) {
			Set<Student> students = new TreeSet<>();

			for (int i = 0; i < 20 && str != null; i++) {
				Student student = new Student(str.split(";"));
				students.add(student);
				str = in.readLine();
			}
			o = new BufferedWriter(new FileWriter("o" + num + ".txt"));

			for (Student s : students) {
				o.write(s + "\n");
			}

			o.close();
			num++;
		}
	}

	public static void reduce() throws IOException, InterruptedException {
		SortedSet<Student> students = null;
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("output.txt"));
			FReader[] t = new FReader[8];
			for (int i = 0; i < 8; i++) {
				t[i] = new FReader(i);
			}
			for (int i = 0; i < 10; i++) {
				students = new TreeSet<>();
				for (int j = 0; j < 8; j++) {
					Student s = t[j].read();
					if (s != null) {
						students.add(s);
					}
				}
				t[students.first().threadNum].next = true;
				out.write(students.first() + "\n");
			}

		} finally {
			out.close();
		}

	}

}
