package domain;

public class Customer_Account {
	private int invoice;
	private int Acc_num;
	private String acc_stat;
	private String Am_paid;
	private String Am_owe;
	private String d_day;
	
	public Customer_Account(int invoice, int acc_num, String acc_stat, String Am_paid,String am_owe, String d_day) {
		this.invoice = invoice;
		Acc_num = acc_num;
		this.acc_stat = acc_stat;
		this.Am_paid = Am_paid;
		Am_owe = am_owe;
		this.d_day = d_day;
	}

	public Customer_Account() {
		invoice = 0;
		Acc_num = 0;
		acc_stat = " ";
		Am_paid = " ";
		Am_owe =  " ";
		d_day = " ";
	}

	public int getInvoice() {
		return invoice;
	}

	public int getAcc_num() {
		return Acc_num;
	}

	public String getAcc_stat() {
		return acc_stat;
	}
	
	public String getAm_paid() {
		return Am_paid;
	}

	public String getAm_owe() {
		return Am_owe;
	}

	public String getD_day() {
		return d_day;
	}

	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}

	public void setAcc_num(int acc_num) {
		Acc_num = acc_num;
	}

	public void setAcc_stat(String acc_stat) {
		this.acc_stat = acc_stat;
	}
	
	public void setAm_paid(String Am_paid) {
		this.Am_paid = Am_paid;
	}

	public void setAm_owe(String am_owe) {
		Am_owe = am_owe;
	}

	public void setD_day(String d_day) {
		this.d_day = d_day;
	}

	@Override
	public String toString() {
		return "Customer_Account [invoice=" + invoice + ", Acc_num=" + Acc_num + ", acc_stat=" + acc_stat + ", Am_owe="
				+ Am_owe + ", d_day=" + d_day + "]";
	}
	
}
