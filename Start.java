import java.io.*;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		System.out.println("welcome to student management app");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to add student !");
			System.out.println("Press 2 to delete student !");
			System.out.println("Press 3 to display student !");
			System.out.println("Press 4 to exit app !");
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1) {
				//add
				System.out.println("Enter the student username : ");
				String name = br.readLine();
				System.out.println("Enter the student phone no. : ");
				String phone = br.readLine();
				System.out.println("Enter the student city : ");
				String city = br.readLine();
				
				Student st = new Student(name, phone, city);
				boolean answers = StudentDao.insertStudentToDb(st);
				if(answers) {
					System.out.println("Student succesfully added");
				}else {
					System.out.println("something went wrong try again!");
				}
			}else if(c == 2) {
				//delete
				System.out.println("Enter the student id to delete : ");
				int userId = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("deleted....");
				}else {
					System.out.println("something went wrong!.. Try again");
				}
			}else if(c == 3) {
				//display
				StudentDao.showAllStudent();
			}else if(c == 4) {
				break;
			}else {
				
			}
		}
		System.out.println("Thank You for using my app");
		System.out.println("See you soon");
	}

}
