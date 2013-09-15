
public class Student implements Comparable<Student> {
	private String last_name;
	private int gpa;
	
	public Student(String last_name, int gpa) {
		this.last_name = last_name;
		this.gpa = gpa;
	}

	public Student(String[] str) {
		this(str[0].trim(), Integer.valueOf(str[1].trim()));
	}

	@Override
	public String toString() {
		return (last_name + " " + gpa);
	}

	@Override
	public int compareTo(Student o) {
		
		if(this.gpa < o.gpa) {
			return 1; 
		} else if(this.gpa > o.gpa) {
			return -1;
		} else
			return 0;
	}
	
	
	
	
}
