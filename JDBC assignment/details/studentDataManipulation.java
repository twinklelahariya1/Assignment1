package student.details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class studentDataManipulation {

	final static java.util.logging.Logger LOGGER = LogManager.getLogger(studentDataManipulation.class.getName());

	static Connection connection;

	public static void AddStudent(Student student) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "password");
		} catch (Exception errorWhileMakingDBConnetion) {
			LOGGER.info("Error Connecting" + errorWhileMakingDBConnetion);
		}

		int rollno = student.getRollNo();
		String name = student.getName();
		long contactNumber = student.getContactNumber();
		String address = student.getAddress();

		String query = " insert into studentdetails (rollno, name,contactnumber, address)" + " values (?, ?, ?, ?)";

		PreparedStatement dataInsertion;
		try {

			dataInsertion = connection.prepareStatement(query);

			dataInsertion.executeUpdate();

			dataInsertion.setInt(1, rollno);
			dataInsertion.setString(2, name);
			dataInsertion.setLong(3, contactNumber);
			dataInsertion.setString(4, address);

		} catch (SQLException exception) {

			LOGGER.error(exception);
		}

	}

	public static void deleteRow(int rollNumber) {
		try{
       			PreparedStatement statement = returnConnection().prepareStatement("DELETE FROM student WHERE rollNo= ?");
        		statement.setInt(1, rollNumber);
        		statement.executeUpdate();}

		catch (SQLException exception) {

			LOGGER.error(exception);
		}
   	}

    	public static void updateRow(Student student, int rollNumber) {
      		 try{
       			PreparedStatement statement = returnConnection().prepareStatement("update student set rollNo=?,name=?,contactnumber=?,address=? where rollno=?");
        
			statement.setInt(1, student.getRollNo());
       			statement.setString(2, student.getName());
        		statement.setInt(3, student.getContactNumber());
        		statement.setString(4, student.getAddress());
        		statement.setInt(5, rollNumber);
        		statement.executeUpdate();}
		catch (SQLException exception) {

			LOGGER.error(exception);
		}
 	
	}
}
