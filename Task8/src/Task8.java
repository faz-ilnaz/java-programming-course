import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;


public class Task8 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		
		Set<Student> students = new TreeSet<Student>();
		
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new BufferedWriter(new FileWriter("output.txt"));
			
			String str = in.readLine();
			while(str != null) {
				Student student = new Student(str.split(";"));
				students.add(student);
				str = in.readLine();
			}
			
			for(Student s : students) {
				out.write(s + "\n");
			}
		} finally {
			in.close();
			out.close();
		}

	}

}
