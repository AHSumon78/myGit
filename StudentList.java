

public class StudentList {
	public static void main(String[] args) {
		// Better termination
		if (args.length == 0) {
			System.out.println("please provide an argument!");
			return;
		}
		//file name
		String fileName="students.txt";
		//StudentOperatin class containnig different method
		StudentOperation studentOperation=new StudentOperation();
		//fileReadder class for reading file named "fileName"
		FileReaderS filereader= new FileReaderS(fileName);
		System.out.println("Loading data ...");
		// Check arguments
		String option = args[0];
		try {
			String data = filereader.fileReader();
			String[] students = data.split(",");
			switch (option) {
				case "a":
				studentOperation.printAllStudent(students);
					break;
				case "r":
				studentOperation.randomStudent(students);
					break;
				case "+":
					if (args.length < 2) {
						System.out.println("please provide a student name!");
						System.out.println("Data Loaded.");
						return;
					}
					studentOperation.addStudent(data, args[1],fileName);
					break;
				case "?":
					if (args.length < 2) {
						System.out.println("please provide a student name!");
						System.out.println("Data Loaded.");
						return;
					}
					studentOperation.searchStudent(students, args[1]);
					break;
				case "c":
				studentOperation.countStudent(data);
					break;
				default:
					System.out.println("Sorry invalid argument!");
					break;
			}
		} catch (Exception e) {
			System.out.println("An error occour");
		}
		System.out.println("Data Loaded.");
	}
}