
public class Student implements Comparable<Student> {
	private String last_name;
	private int gpa;
	
	public Student(String last_name, int gpa) {
		this.last_name = last_name.trim();
		this.gpa = gpa;
	}

	public Student(String[] str) {
		this(str[0].trim(), Integer.valueOf(str[1].trim()));
	}
	
	public void changeGpa(int gpa) {
		this.gpa = gpa;
	}

	public String getLast_name() {
		return last_name;
	}

	public int getGpa() {
		return gpa;
	}

	@Override
	public String toString() {
		return (last_name + " " + gpa);
	}

	@Override
	public int compareTo(Student arg0) {
		return this.last_name.compareTo(arg0.last_name);
	}

	
	
	
	
}
