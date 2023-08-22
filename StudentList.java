import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {
		// Better termination
		if (args.length == 0) {
			System.out.println("please provide an argument!");
			return;
		}
		System.out.println("Loading data ...");
		// Check arguments
		String option = args[0];
		try {
			String data = fileReader();
			String[] students = data.split(",");
			switch (option) {
				case "a":
					printAllStudent(students);
					break;
				case "r":
					randomStudent(students);
					break;
				case "+":
					if (args.length < 2) {
						System.out.println("please provide a student name!");
						System.out.println("Data Loaded.");
						return;
					}
					addStudent(data, args[1]);
					break;
				case "?":
					if (args.length < 2) {
						System.out.println("please provide a student name!");
						System.out.println("Data Loaded.");
						return;
					}
					searchStudent(students, args[1]);
					break;
				case "c":
					System.out.println("Loading data ...");
					try {
						BufferedReader s = new BufferedReader(
								new InputStreamReader(
										new FileInputStream("students.txt")));
						String D = s.readLine();
						char a[] = D.toCharArray();
						boolean in_word = false;
						int count = 0;
						for (char c : a) {
							if (c == ' ') {
								if (!in_word) {
									count++;
									in_word = true;
								} else {
									in_word = false;
								}
							}
						}
						System.out.println(count + " word(s) found " + a.length);
					} catch (Exception e) {
					}
					System.out.println("Data Loaded.");
					break;
				default:
					System.out.println("Sorry invalid argument!");
					break;
			}
		} catch (Exception e) {
		}
		System.out.println("Data Loaded.");
	}

	public static String fileReader() throws IOException {
		BufferedReader fileReader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("students.txt")));
		String data = fileReader.readLine();
		fileReader.close();
		return data;
	}

	public static void printAllStudent(String[] students) {
		for (String student : students) {
			System.out.println(student.trim());
		}
	}

	public static void randomStudent(String[] students) {
		Random random = new Random();
		int randomIndex = random.nextInt(students.length);
		System.out.println(students[randomIndex].trim());
	}

	public static void addStudent(String data, String name) throws IOException {
		BufferedWriter fileWriter = new BufferedWriter(
				new FileWriter("students.txt", false));
		Date date = new Date();
		String dateFormate = "dd/mm/yyyy-hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(dateFormate);
		String formateddate = dateFormat.format(date);
		fileWriter.write(data + ", " + name + "\nList last updated on " + formateddate);
		fileWriter.close();
	}

	public static void searchStudent(String[] students, String name) {
		boolean find = false;
		for (String student : students) {
			if (student.trim().equals(name)) {
				find = true;
				break;
			}
		}
		if (find == true) {
			System.out.println("Found it!");
		} else {
			System.out.println("Can't found!");
		}

	}
}