import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class StudentOperation {
    StudentOperation(){
        
    }

    public  void printAllStudent(String[] students) {
		for (String student : students) {
			System.out.println(student.trim());
		}
	}

	public void randomStudent(String[] students) {
		Random random = new Random();
		int randomIndex = random.nextInt(students.length);
		System.out.println(students[randomIndex].trim());
	}

	public void addStudent(String data, String name,String fileName) throws IOException {
		BufferedWriter fileWriter = new BufferedWriter(
				new FileWriter(fileName, false));
		Date date = new Date();
		String dateFormate = "dd/mm/yyyy-hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(dateFormate);
		String formateddate = dateFormat.format(date);
		fileWriter.write(data + ", " + name + "\nList last updated on " + formateddate);
		fileWriter.close();
	}

	public  void searchStudent(String[] students, String name) {
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
	public  void countStudent(String data){
		String[] words=data.split("\\s+");
		int wordCount=words.length;
		System.out.println(wordCount + " word(s) found ");

	}
    
}
