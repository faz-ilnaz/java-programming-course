
public class Student implements Comparable<Student> {
	private String last_name;
	private int gpa;
	public int threadNum; 
	
	public Student(String last_name, int gpa) {
		this.last_name = last_name;
		this.gpa = gpa;
	}
	
	public Student(String last_name, int gpa, int threadNum) {
		this.last_name = last_name;
		this.gpa = gpa;
		this.threadNum = threadNum;
	}

	public Student(String[] str) {
		this(str[0].trim(), Integer.valueOf(str[1].trim()));
	}
	
	public Student(String[] str, int threadNum) {
		this(str[0].trim(), Integer.valueOf(str[1].trim()), threadNum);
	}

	@Override
	public String toString() {
		return (last_name + " " + gpa);
	}

	@Override
	public int compareTo(Student o) {
		
		if(this.gpa < o.gpa) {
			return 1; 
		} else  {
			return -1;
		}
	}
	
	
	
	
}
