import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Task3 {
    public static void main(String[] args) throws IOException {
    	BufferedReader in = null;
    	FileWriter out = null;    
    	Set<Student> students = new HashSet<Student>();
    	
    	try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new FileWriter("output.txt");
            String str = in.readLine();
            
            while(str != null) {
            	Student student =  new Student(str.split(";"));
            	students.add(student);
            	str = in.readLine();
            }
            
            for(Student s : students) {
            	out.write(s + "\n");
            }
            
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    	
    	
    	
    }
}
