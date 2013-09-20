import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FReader {

	private BufferedReader in = null;
	private Student student;
	private int threadNum;
	boolean next;
	
	public FReader(int num) throws FileNotFoundException {
		this.in = new BufferedReader(new FileReader("o" + num + ".txt"));
		this.threadNum = num;
		this.next = true;
	}
	
	
	public Student read() {
		String str;
		if(next) {
			try {
				str = in.readLine();
				if(str != null) {
					this.student = new Student(str.split(" "), threadNum);
					this.next = false;					
				} else {
					student = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return this.student;
	}

	

}
