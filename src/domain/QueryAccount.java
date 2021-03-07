package domain;

import java.util.Date;

public class QueryAccount 
{
		//declaration of variables
			private Date dueDate;
			private float amountDue;
			private String paymentStatus;
			private float amountPaid;
			private float total;
		//Default Constructor	
		public QueryAccount() 
		{
			
		}
		
		//Primary Constructor 
		public QueryAccount(Date dueDate,float amountDue,String paymentStatus)
		{
			this.dueDate= dueDate;
			this.amountDue= amountDue;
			this.paymentStatus= paymentStatus;
			this.amountPaid= amountPaid;
			this.total= total;
		}
		
		//Copy Constructor
		public QueryAccount(QueryAccount query)
		{
			this.dueDate= query.dueDate;
			this.amountDue= query.amountDue;
			this.paymentStatus=query.paymentStatus;
			this.amountPaid= query.amountPaid;
			this.total= query.total;
		}
		
		//Getters and Setters

		private Date getDueDate() {
			return dueDate;
		}

		private void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}

		private float getAmountDue() {
			return amountDue;
		}

		private void setAmountDue(float amountDue) {
			this.amountDue = amountDue;
		}

		private String getPaymentStatus() {
			return paymentStatus;
		}

		private void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}

		private float getAmountPaid() {
			return amountPaid;
		}

		private void setAmountPaid(float amountPaid) {
			this.amountPaid = amountPaid;
		}

		private float getTotal() {
			return total;
		}

		private void setTotal(float total) {
			this.total = total;
		}

		//calculation of Amount due, class is to private as this is an internal process
		private float CalculateBalance(float amountPaid,float total)
		{
			amountDue= total - amountPaid;
			
			return amountDue;
		}
		
		//function to assign payment status
		private String Assign_Payment_Status(float amountDue)
		{
			CalculateBalance(amountPaid,total);
			if(amountDue==0.00)
			{
				paymentStatus= "PAID IN FULL";
			}
			else if (amountDue>0)
			{
				paymentStatus= "PAYMENT OUTSTANDING";
			}
			return paymentStatus;
				
		}

		
		
		
		//to String Display Method
		@Override
		public String toString() 
		{
			Assign_Payment_Status(amountDue);
			return "Payment Due Date:" + dueDate   + " \t Amount Due:" + amountDue + "\t Payment Status:" + paymentStatus;
		}
		
		

	}

