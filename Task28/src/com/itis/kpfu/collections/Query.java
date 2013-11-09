package com.itis.kpfu.collections;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Query {

	static List<Employee> empl;
	static List<Dept> dept;

	public static void fill() {
		empl.add(new Employee(1, "John", "programmer", 1, "2008-12-21", 4000,
				2, 5));
		empl.add(new Employee(2, "Paul", "tester", 2, "2009-11-21", 3000, 3, 3));
		empl.add(new Employee(3, "Alex", "programmer", 1, "2006-12-12", 4000,
				2, 2));
		empl.add(new Employee(4, "Ryan", "admin", 2, "2009-08-31", 3000, 2, 2));
		empl.add(new Employee(5, "Michael", "designer", 1, "2007-08-05", 4500,
				1, 1));
		empl.add(new Employee(6, "Victor", "designer", 2, "2009-12-11", 6000,
				1, 1));
		empl.add(new Employee(7, "Kevin", "analyst", 3, "2010-06-06", 6100, 2,
				5));
		empl.add(new Employee(8, "Henry", "programmer", 2, "2008-01-02", 3000,
				2, 6));
		empl.add(new Employee(9, "Steve", "tester", 1, "2007-08-19", 4000, 1, 5));
		empl.add(new Employee(10, "Andrew", "designer", 2, "2009-10-02", 5000,
				2, 6));
		empl.add(new Employee(11, "Christopher", "analyst", 3, "2010-10-11",
				5000, 1, 1));

		dept.add(new Dept(1, "sales", "Tualatin"));
		dept.add(new Dept(2, "development", "Portland"));
		dept.add(new Dept(3, "testing", "San Francisco"));
		dept.add(new Dept(5, "testing", "Tualatin"));
		dept.add(new Dept(6, "development", "Tualatin"));
	}

	public static void one() {
		Employee e = Utils.findEmplByName(empl, "Victor");
		if (e != null) {
			List<Employee> list = Utils.findByJobTitle(empl, e.job_title);

			String colname1 = "name";
			String colname2 = "job title";

			Formatter fmt1 = new Formatter();
			fmt1.format("%-21s%s", colname1, colname2);
			System.out.println(fmt1);

			for (Employee k : list) {
				Formatter fmt2 = new Formatter();
				fmt2.format("%-21s", k.name);
				System.out.print(fmt2);
				System.out.println(k.job_title);
			}
		}

	}

	public static void two() {
		if (dept.isEmpty() || empl.isEmpty()) {
			return;
		}
		String city = Utils.findById(dept,
				Utils.findEmplByName(empl, "Victor").dept_no).city;
		List<Dept> citiesList = Utils.findByCity(dept, city);

		List<String> empl_names = new LinkedList<>();
		List<String> dept_names = new LinkedList<>();

		for (Employee e : empl) {
			if (citiesList.contains(Utils.findById(dept, e.dept_no))) {
				empl_names.add(e.name);
				dept_names.add(Utils.findById(dept, e.dept_no).name);
			}
		}

		String colname1 = "empl.name";
		String colname2 = "dept.name";

		Formatter fmt1 = new Formatter();
		fmt1.format("%-21s%s", colname1, colname2);
		System.out.println(fmt1);

		Iterator<String> it1 = empl_names.iterator();
		Iterator<String> it2 = dept_names.iterator();

		while (it1.hasNext() && it2.hasNext()) {
			Formatter fmt2 = new Formatter();
			fmt2.format("%-21s", it1.next());
			System.out.print(fmt2);
			System.out.println(it2.next());
		}
	}

	public static void three() {

		if (empl.isEmpty()) {
			return;
		}

		int min = Utils.findMinimalSalary(empl);
		List<String> em = new LinkedList<>();

		for (Employee e : empl) {
			if (e.salary == min) {
				em.add(e.name);
			}
		}

		String colname1 = "name";

		System.out.println(colname1);

		for (String str : em) {
			System.out.println(str);
		}
	}

	public static void four() {

		if (dept.isEmpty() || empl.isEmpty()) {
			return;
		}

		List<Integer> salesDeptId = Utils.findDeptIdByName(dept, "sales");

		List<String> jobes = new LinkedList<String>();
		for (Employee e : empl) {
			if (salesDeptId.contains(e.dept_no)) {
				jobes.add(e.job_title);
			}
		}

		List<String> names = new LinkedList<String>();

		for (Employee e : empl) {
			if (jobes.contains(e.job_title)) {
				names.add(e.name);
			}
		}

		String colname1 = "name";

		System.out.println(colname1);

		for (String str : names) {
			System.out.println(str);
		}

	}

	public static void five() {

		if (empl.isEmpty()) {
			return;
		}

		List<Employee> analystEmp = Utils.findByJobTitle(empl, "analyst");

		List<Integer> analystEmpDeptId = new LinkedList<Integer>();

		for (Employee e : analystEmp) {
			analystEmpDeptId.add(e.dept_no);
		}

		List<Employee> emp = new LinkedList<Employee>();
		for (Employee e : empl) {
			if (analystEmpDeptId.contains(e.dept_no)) {
				emp.add(e);
			}
		}

		String colname1 = "id";
		String colname2 = "name";
		String colname3 = "job_title";
		String colname4 = "dept_no";

		Formatter fmt1 = new Formatter();
		fmt1.format("%-5s%-15s%-15s%s", colname1, colname2, colname3, colname4);
		System.out.println(fmt1);

		for (Employee e : emp) {
			Formatter fmt2 = new Formatter();
			fmt2.format("%-5s%-15s%-15s%s", e.id, e.name, e.job_title,
					e.dept_no);
			System.out.println(fmt2);
		}
	}

	public static void six() {

		if (empl.isEmpty()) {
			return;
		}

		double avg = Utils.findAverageSalary(empl);
		List<Employee> em = new LinkedList<>();

		for (Employee e : empl) {
			if (e.salary > avg) {
				em.add(e);
			}
		}

		String colname1 = "id";
		String colname2 = "name";
		String colname3 = "job_title";
		String colname4 = "salary";
		String colname5 = "dept_no";

		Formatter fmt1 = new Formatter();
		fmt1.format("%-5s%-15s%-15s%-15s%s", colname1, colname2, colname3,
				colname4, colname5);
		System.out.println(fmt1);

		for (Employee e : em) {
			Formatter fmt2 = new Formatter();
			fmt2.format("%-5s%-15s%-15s%-15s%s", e.id, e.name, e.job_title,
					e.salary, e.dept_no);
			System.out.println(fmt2);
		}
	}

	public static void seven() {

		if (dept.isEmpty() || empl.isEmpty()) {
			return;
		}

		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>(
				dept.size());

		for (Dept d : dept) {
			countMap.put(d.id, 0);
		}

		for (Employee e : empl) {
			if (e.job_title.equals("analyst")) {
				Integer val = countMap.get(e.dept_no) + 1;
				countMap.put(e.dept_no, val);
			}
		}

		String colname1 = "id";
		String colname2 = "name";
		String colname3 = "count";

		Formatter fmt1 = new Formatter();
		fmt1.format("%-7s%-20s%s", colname1, colname2, colname3);
		System.out.println(fmt1);

		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			Formatter fmt2 = new Formatter();
			fmt2.format("%-7d%-20s%d", entry.getKey(),
					Utils.findById(dept, entry.getKey()).name, entry.getValue());
			System.out.println(fmt2);
		}

	}

	public static void eight() {

		if (empl.isEmpty()) {
			return;
		}

		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

		for (Employee e : empl) {
			Integer val = countMap.get(e.dept_no);
			countMap.put(e.dept_no, val == null ? 1 : val + 1);
		}

		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

		for (Employee e : empl) {
			if (countMap.get(e.dept_no) > 2) {
				Integer val = sumMap.get(e.dept_no);
				sumMap.put(e.dept_no, val == null ? e.salary : val + e.salary);
			}
		}

		String colname1 = "id";
		String colname2 = "name";
		String colname3 = "count";

		Formatter fmt1 = new Formatter();
		fmt1.format("%-7s%-20s%s", colname1, colname2, colname3);
		System.out.println(fmt1);

		for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
			Formatter fmt2 = new Formatter();
			fmt2.format("%-7d%-20s%d", entry.getKey(),
					Utils.findById(dept, entry.getKey()).name, entry.getValue());
			System.out.println(fmt2);
		}
	}
}
