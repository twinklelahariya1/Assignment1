package student.details;

import java.util.Scanner;

public class Data {
	
	
	static Scanner takeDataFromConsole = new Scanner(System.in);
	public static Student studentDataFromConsole() {
		System.out.println("Enter student data\n");
		System.out.println("\n1:Name-");
		String name= takeDataFromConsole.nextLine();
		Student student= new Student();
		student.setName(name);
		System.out.println("\n2:Address-");
		String address= takeDataFromConsole.nextLine();
		student.setAddress(address);
		
		System.out.println("\n3:Roll Number-");
		int rollNumber = takeDataFromConsole.nextInt();
		student.setRollNo(rollNumber);
		
		System.out.println("\n4:Contact number-");
		long contactNumber= takeDataFromConsole.nextLong();
		student.setContactNumber(contactNumber);
			
		return student;
	}
	
	

}
