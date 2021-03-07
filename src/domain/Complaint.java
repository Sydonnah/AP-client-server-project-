package domain;

public class Complaint {
	private int complaintID;
	private String complaintType;
	private Customer customer;
	private Technician technicianAssigned;
	private String whoProvidedResponse;
	private boolean status;
	private String response;
	private Date dateCreated;
	private Date lastResponseDate;
	private Date proposeDateOfVisit;
	
	public Complaint(int complaintID, String complaintType, Customer customer, Technician technicianAssigned, String whoProvidedResponse,
			boolean status, String response, Date dateCreated, Date lastResponseDate, Date proposeDateOfVisit) {
		this.complaintID = complaintID;
		this.complaintType = complaintType;
		this.customer = customer;
		this.technicianAssigned = technicianAssigned;
		this.whoProvidedResponse = whoProvidedResponse;
		this.status = status;
		this.response = response;
		this.dateCreated = dateCreated;
		this.lastResponseDate = lastResponseDate;
		this.proposeDateOfVisit = proposeDateOfVisit;
	}
	
	//accessors/getters
	public int getComplaintID() {
		return complaintID;
	}
	public String getComplaintType() {
		return complaintType;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Technician getTechnicianAssigned() {
		return technicianAssigned;
	}
	public String getWhoProvidedResponse() {
		return whoProvidedResponse;
	}
	public boolean getStatus() {
		return status;
	}
	public String getResponse() {
		return response;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public Date getLastResponseDate() {
		return lastResponseDate;
	}
	public Date getProposeDateOfVisit() {
		return proposeDateOfVisit;
	}
	
	//mutators/setters
	public void setComplaintID(int complaintID) {
		this.complaintID= complaintID;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void TechnicianAssigned(Technician technicianAssigned) {
		this.technicianAssigned = technicianAssigned ;
	}
	public void setWhoProvidedResponse(String whoProvidedResponse) {
		this.whoProvidedResponse = whoProvidedResponse;
	}
	public void setStatus(boolean status) {
		this.status = status ;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setLastResponseDate(Date lastResponseDate) {
		this.lastResponseDate = lastResponseDate;
	}
	public void setProposeDateOfVisit(Date proposeDateOfVisit) {
		this.proposeDateOfVisit = proposeDateOfVisit;
	}
	
	//TODO: let logic determine who provided last response
	//should be coming from who edited response field I think
	
	//print function
	//toString print method
	public String toString() {
		String out;
		out=("\n********************\nComplaint ID: " + getComplaintID() + "\n");
		out+=("Complaint Type: " + getComplaintType() + "\n");
		out+=("Customer: " + getCustomer().getFirstName() + " " + getCustomer().getLastName() + "\n");
		out+=("Technician Assigned: " + getTechnicianAssigned().getFirstName() + " " + getTechnicianAssigned().getLastName() + "\n");
		out+=("Who provided response: " + getWhoProvidedResponse() + "\n");
		out+=("Status: " +  getStatus() + "\n");
		out+=("Response: " +  getResponse() + "\n");
		out+=("Date created: " +  getDateCreated() + "\n");
		out+=("Date of last response: " +  getDateCreated() + "\n");
		out+=("Date of proposed visit: " + getDateCreated() + "\n********************\n");
		return out;
	}
}
