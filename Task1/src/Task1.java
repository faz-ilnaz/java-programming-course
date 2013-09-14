/*
        Author: Fazliakhmetov Ilnaz
        Task: 1
        Description: Search for a file
*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*TODO просто тестовый коммент*/
public class Task1 {
	private static String name;				// name of the file
	private static List<String> list;	// search result

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		try {
			
			System.out.println("Enter the full path to the folder where you want to search:");
			String PATH = sc.nextLine();
			if(PATH == null || PATH.isEmpty()) {
				throw new IllegalArgumentException("PATH can't be blank");
			}
			
			System.out.println("Enter the file name:");
			name = sc.nextLine();
			if(name == null || name.isEmpty()) {
				throw new IllegalArgumentException("File name can't be blank");
			}
			
			// initial directory
			File startF = new File(PATH);
			
			list = new ArrayList<String>();
			
			//starting search
			find(startF);
			
			if(!list.isEmpty()) {
				System.out.println("Found " + list.size() + " file(s):");
				for (String path : list) {
					System.out.println(path);
				}
			} else {
				System.out.println("Not found");
			}
		} catch (Exception e) {
			System.out.println(e);
			
		} finally {
			sc.close();
		}
		
	}

	private static void find(File file) {
//		System.out.println("Searching: " + file.getPath());
		File[] files = file.listFiles();
		
		if(files == null) {
			return;
		}
		
		for (File f : files) {
			if (f.isFile() && f.getName().contains(name)) {
				list.add(f.getAbsolutePath());
			};
			if (f.isDirectory()) {
				find(f);
			}
		}
	}
}
