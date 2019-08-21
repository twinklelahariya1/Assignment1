package student.details;

public class Student {
	
	private String name;
	private int rollNo;
	private long contactNumber;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "student [name=" + name + ", rollNo=" + rollNo + ", contactNumber=" + contactNumber + ", address="
				+ address + "]";
	}

	
}
