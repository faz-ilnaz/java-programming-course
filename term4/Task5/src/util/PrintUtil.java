package util;

import java.util.List;

import logic.Student;

public class PrintUtil {
	
	public static void printAndClean(String name, List<Student> studs) {
		System.out.println("========" + name + " query=========");
		for (int i = 0; i < studs.size(); ++i) {
			System.out.println("Student : " +  studs.get(i).getName()
					+ ", age : " + studs.get(i).getAge() + ",  id : "
					+ studs.get(i).getId());
		}
		studs.clear();
		System.out.println("=============================");
		System.out.println();
	}

}
