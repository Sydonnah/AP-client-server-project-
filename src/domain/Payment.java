package domain;

public class Payment {
	private Customer customer;
	private double amount;
	private Date paymentDate;
	
	public Payment(Customer customer, double amount, Date paymentDate) {
		this.customer = customer;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	
	//accessors/getters
	public Customer getCustomer() {
		return customer;
	}
	public double getAmount() {
		return amount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	
	//mutators/setters
	public void setCustomer(Customer customer) {
		this.customer= customer ;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	//print function
		//toString print method
		public String toString() {
			String out;
			out=("\n********************\nCustomer: " + getCustomer() + "\n");
			out+=("Amount: " + getAmount() + "\n");
			out+=("Date of payment: " + getPaymentDate() + "\n********************\n");
			return out;
		}
}
