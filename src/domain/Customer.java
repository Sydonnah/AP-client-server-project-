package domain;

public class Customer {
	protected int Acc_num;
	protected String fname;
	protected String lname;
	protected String email;
	protected String user;
	protected String pword;
	protected String rpword;
	
	public Customer(int acc_num, String fname, String lname, String email, String user, String pword, String rpword) {
		Acc_num = acc_num;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.user = user;
		this.pword = pword;
		this.rpword = rpword;
	}

	
	public Customer() {
		Acc_num = 0;
		fname = " ";
		lname = " ";
		email = " ";
		user = " ";
		pword = " ";
		rpword = " ";
	}


	public int getAcc_num() {
		return Acc_num;
	}


	public String getFname() {
		return fname;
	}


	public String getLname() {
		return lname;
	}


	public String getEmail() {
		return email;
	}


	public String getUser() {
		return user;
	}


	public String getPword() {
		return pword;
	}


	public String getRpword() {
		return rpword;
	}


	public void setAcc_num(int acc_num) {
		Acc_num = acc_num;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public void setPword(String pword) {
		this.pword = pword;
	}


	public void setRpword(String rpword) {
		this.rpword = rpword;
	}


	@Override
	public String toString() {
		return "Customer [Acc_num=" + Acc_num + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", user="
				+ user + ", pword=" + pword + ", rpword=" + rpword + "]";
	}
	
	

}
