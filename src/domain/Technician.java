//Representative base class
//Defines the properties of a representative

package domain;

public class Technician {
	private int technicianID;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNumber;
	private String password;
	private boolean availability;

	//primary constructor
	public Technician(int technicianID, String firstName, String lastName, String email, String contactNumber, String password, boolean availability){
		this.technicianID = technicianID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.password = password;
		this.availability = availability;
	}
	
	//getter/accessors
	public int getTechnicianID() {
		return technicianID;
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
	public Boolean getAvailability() {
		return availability;
	}
	
	//setters/mutators
	public void setTechnicianID(int technicianID) {
		this.technicianID = technicianID;
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
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	
	//print function
	//toString print method
	public String toString() {
		String out;
		out=("\n++++++++++++++++++++\nRepresentative ID: " + getTechnicianID() + "\n");
		out+=("Name: " + getFirstName() + " " + getLastName() + "\n");
		out+=("Email: " +  getEmail() + "\n");
		out+=("Contact Number: " + getContactNumber() + "\n");
		out+=("Password: " + getPassword() + "\n");
		out+=("Availability: " + getAvailability() + "\n++++++++++++++++++++\n");
		return out;
	}
}
