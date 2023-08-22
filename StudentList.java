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

					System.out.println("Loading data ...");
					try {
						BufferedReader s = new BufferedReader(
								new InputStreamReader(
										new FileInputStream("students.txt")));
						String r = s.readLine();
						System.out.println(r);
						String i[] = r.split(",");
						Random x = new Random();
						int y = x.nextInt();
						System.out.println(i[y]);
					} catch (Exception e) {
					}
					System.out.println("Data Loaded.");
					break;
				case "+":

					System.out.println("Loading data ...");
					try {
						BufferedWriter s = new BufferedWriter(
								new FileWriter("students.txt", true));
						String t = args[0].substring(1);
						Date d = new Date();
						String df = "dd/mm/yyyy-hh:mm:ss a";
						DateFormat dateFormat = new SimpleDateFormat(df);
						String fd = dateFormat.format(d);
						s.write(", " + t + "\nList last updated on " + fd);
						s.close();
					} catch (Exception e) {
					}

					System.out.println("Data Loaded.");
					break;
				case "?":

					System.out.println("Loading data ...");
					try {
						BufferedReader s = new BufferedReader(
								new InputStreamReader(
										new FileInputStream("students.txt")));
						String r = s.readLine();
						String i[] = r.split(",");
						boolean done = false;
						String t = args[0].substring(1);
						for (int idx = 0; idx < i.length && !done; idx++) {
							if (i[idx].equals(t)) {
								System.out.println("We found it!");
								done = true;
							}
						}
					} catch (Exception e) {
					}
					System.out.println("Data Loaded.");
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
}