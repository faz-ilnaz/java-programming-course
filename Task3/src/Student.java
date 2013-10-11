
public class Student {
	private String fullname;
	private String address;
	private String phoneNumber;
	
	public Student(String fullname, String address, String phoneNumber) {
		this.fullname = fullname;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public Student(String[] data) {
		this(	data[0].trim(), 
				data[1].trim(), 
				data[2].trim());
	}

	@Override
	public String toString() {
		return 	this.fullname + "; " +
				this.address + "; " + 
				this.phoneNumber;
	}

	
	@Override
	public boolean equals(Object obj) {
		Student other = (Student)obj; 
		if(		this.fullname.equalsIgnoreCase(other.fullname) &&
				this.address.equalsIgnoreCase(other.address) &&
				this.phoneNumber.equalsIgnoreCase(other.phoneNumber)) {
			return true;
		} else
		return false;
	}

	@Override
	public int hashCode() {
		return this.phoneNumber.toString().hashCode();
	}
//	
	
	
}
