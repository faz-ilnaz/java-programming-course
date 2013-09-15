import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Task7 {

	public static void main(String[] args) throws IOException {
		BufferedReader b_in = null;
		BufferedWriter b_out= null;
		
		try {
			b_in = new BufferedReader(new FileReader("input.txt"));
			b_out = new BufferedWriter(new FileWriter("output.txt"));
			
			Set<Student> students = new TreeSet<Student>();
			String str = b_in.readLine();
			while(str != null) {
				Student student = new Student(str.split(";"));
				students.add(student);
				str = b_in.readLine();
			}
			
			Iterator<Student> i = students.iterator();
			int n = 0;
			for(Student s = i.next(); i.hasNext() && n < 10; s = i.next(), n++) {
				b_out.write(s + "\n");
			}
			
		}
		finally {
			b_in.close();
			b_out.close();
		}

	}

}
