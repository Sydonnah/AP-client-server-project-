package domain;

public class Customer {
	private int customerID;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNumber;
	private String password;

	//primary constructor
	public Customer(int customerID, String firstName, String lastName, String email, String contactNumber, String password){
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.password = password;
	}
	
	//getter/accessors
	public int getCustomerID() {
		return customerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getPassword() {
		return password;
	}
	
	//setters/mutators
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//print function
	//toString print method
	public String toString() {
		String out;
		out=("\n********************\nCustomer ID: " + getCustomerID() + "\n");
		out+=("Name: " + getFirstName() + " " + getLastName() + "\n");
		out+=("Email: " +  getEmail() + "\n");
		out+=("Contact Number: " + getContactNumber() + "\n");
		out+=("password: " + getPassword() + "\n********************\n");
		return out;
	}
}
