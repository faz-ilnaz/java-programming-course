package com.itis.kpfu.collections;

import java.util.LinkedList;

public class Task28 {

	public static void main(String[] args) {

		Query.empl = new LinkedList<>();
		Query.dept = new LinkedList<>();

		// заполнение коллекции данными
		Query.fill();

		System.out.println("Query #1");
		Query.one();
		System.out.println();

		System.out.println("Query #2");
		Query.two();
		System.out.println();

		System.out.println("Query #3");
		Query.three();
		System.out.println();

		System.out.println("Query #4");
		Query.four();
		System.out.println();

		System.out.println("Query #5");
		Query.five();
		System.out.println();

		System.out.println("Query #6");
		Query.six();
		System.out.println();

		System.out.println("Query #7");
		Query.seven();
		System.out.println();

		System.out.println("Query #8");
		Query.eight();
		System.out.println();

	}

}
