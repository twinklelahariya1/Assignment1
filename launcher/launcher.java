package launcher;

import java.sql.SQLException;

import student.details.Data;
import student.details.Student;
import student.details.studentDataManipulation;

public class launcher {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Student student=Data.studentDataFromConsole();
		studentDataManipulation.AddStudent(student);

	}

}
