package domain;

public class Payment {
	private Customer customer;
	private String paymentStatus;
	private double amountDue;
	private Date paymentDueDate;
	
	public Payment(Customer customer, String paymentStatus, double amountDue, Date paymentDueDate) {
		this.customer = customer;
		this.paymentStatus = paymentStatus;
		this.amountDue = amountDue;
		this.paymentDueDate = paymentDueDate;
	}
	
	//accessors/getters
	public Customer getCustomer() {
		return customer;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public double getAmountDue() {
		return amountDue;
	}
	public Date getPaymentDueDate() {
		return paymentDueDate;
	}
	
	//mutators/setters
	public void setCustomer(Customer customer) {
		this.customer= customer ;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus= paymentStatus;
	}
	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}
	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	
	//print function
		//toString print method
		public String toString() {
			String out;
			out=("\n********************\nCustomer: " + getCustomer() + "\n");
			out+=("Amount: " + getPaymentStatus() + "\n");
			out+=("Amount: " + getAmountDue() + "\n");
			out+=("Date of payment: " + getPaymentDueDate() + "\n********************\n");
			return out;
		}
}
