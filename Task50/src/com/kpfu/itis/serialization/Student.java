package com.kpfu.itis.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	private String firstName;
	private String lastName;
	private String group;
	private transient byte[] photo;
	private transient Date modificationDate;

	public Student(String firstName, String lastName, String group,
			byte[] photo, Date modificationDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.group = group;
		this.photo = photo;
		this.modificationDate = modificationDate;
	}

	private void readObject(ObjectInputStream aInputStream)
			throws ClassNotFoundException, IOException {
		// always perform the default de-serialization first
		aInputStream.defaultReadObject();
		modificationDate = new Date();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	@Override
	public String toString() {
		return "Student [" + firstName + " " + lastName
				+ ", group=" + group + ", modificationDate=" + modificationDate + "]";
	}

}
