package com.itis.kpfu.collections;

public class Employee {

	int id;
	String name;
	String job_title;
	int manager;
	String date;
	int salary;
	int comission;
	int dept_no;

	public Employee(int id, String name, String job_title, int manager,
			String date, int salary, int comission, int dept_no) {
		this.id = id;
		this.name = name;
		this.job_title = job_title;
		this.manager = manager;
		this.date = date;
		this.salary = salary;
		this.comission = comission;
		this.dept_no = dept_no;
	}

}
