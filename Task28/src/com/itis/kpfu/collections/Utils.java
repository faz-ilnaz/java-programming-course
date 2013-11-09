package com.itis.kpfu.collections;

import java.util.LinkedList;
import java.util.List;

public class Utils {

	public static Employee findEmplByName(List<Employee> empl, String name) {

		Employee e = null;

		for (Employee i : empl) {
			if (i.name.equals(name)) {
				e = i;
			}
		}

		return e;
	}

	public static List<Integer> findDeptIdByName(List<Dept> dept, String name) {

		List<Integer> d = new LinkedList<>();

		for (Dept i : dept) {
			if (i.name.equals(name)) {
				d.add(i.id);
			}
		}

		return d;
	}

	public static List<Employee> findByDeptId(List<Employee> empl, int deptId) {
		List<Employee> e = new LinkedList<>();

		for (Employee i : empl) {
			if (i.dept_no == deptId) {
				e.add(i);
			}
		}

		return e;
	}

	public static Dept findById(List<Dept> dept, int id) {
		Dept d = null;

		for (Dept i : dept) {
			if (i.id == id) {
				d = i;
			}
		}

		return d;
	}

	public static List<Employee> findByJobTitle(List<Employee> empl,
			String jobTitle) {
		List<Employee> list = new LinkedList<Employee>();

		if (empl.isEmpty()) {
			return null;
		}
		for (Employee i : empl) {
			if (i.job_title == jobTitle) {
				list.add(i);
				;
			}
		}

		return list;
	}

	public static List<Dept> findByCity(List<Dept> dept, String city) {
		List<Dept> list = new LinkedList<Dept>();

		for (Dept i : dept) {
			if (i.city == city) {
				list.add(i);
			}
		}

		return list;
	};

	public static double findAverageSalary(List<Employee> empl) {
		int sum = 0;

		for (Employee e : empl) {
			sum += e.salary;
		}

		return sum * 1.0 / empl.size();
	};

	public static int findMinimalSalary(List<Employee> empl) {
		int min = -1;

		for (Employee e : empl) {
			if (min == -1 || e.salary < min) {
				min = e.salary;
			}
		}

		return min;
	}

}
