package domain;

public class Customer_Enquiry {
	protected int eID;
	protected String Com_type;
	protected String Com_Description;
	protected String Com_Date;
	
	public Customer_Enquiry(int eID, String com_type, String com_Description, String com_Date) {
		this.eID = eID;
		Com_type = com_type;
		Com_Description = com_Description;
		Com_Date = com_Date;
	}
	
	public Customer_Enquiry(){
		eID = 0;
		Com_type = " ";
		Com_Description = " ";
		Com_Date = " ";
	}

	public int geteID() {
		return eID;
	}

	public String getCom_type() {
		return Com_type;
	}

	public String getCom_Description() {
		return Com_Description;
	}

	public String getCom_Date() {
		return Com_Date;
	}

	public void seteID(int eID) {
		this.eID = eID;
	}

	public void setCom_type(String com_type) {
		Com_type = com_type;
	}

	public void setCom_Description(String com_Description) {
		Com_Description = com_Description;
	}

	public void setCom_Date(String com_Date) {
		Com_Date = com_Date;
	}

	@Override
	public String toString() {
		return "Customer_Enquiry [eID=" + eID + ", Com_type=" + Com_type + ", Com_Description=" + Com_Description
				+ ", Com_Date=" + Com_Date + "]";
	}
	
}
