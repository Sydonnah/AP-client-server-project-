package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
	private Connection con = null;
	
	public CreateDatabase (Connection con){
		this.con = con;
	}
	
	public boolean createTable() {
		String createdb = "Create Database ms_cablevision";
		String dbchoice = "Use ms_cablevision";
		
		String Customer =  
				"Create TABLE customerinformation ("
				+ "Acc_num INT(50) AUTO_INCREMENT,\n"
				+ "First_Name VARCHAR(50),\n"
				+ "Last_Name VARCHAR(50,\n"
				+ "Email VARCHAR(50),\n"
				+ "Username VARCHAR(50),\n"
				+ "Password VARCHAR(50),\n"
				+ "PRIMARY KEY (Acc_num));";
		
		String CustomerEnquiry = 
				"Create TABLE enquiries("
				+ "Enquiry_ID INT(50),\n"
				+ "Acc_num INT(50),\n"
				+ " Com_Type VARCHAR(50), \n"
				+ "Com_Description VARCHAR(255),\n"
				+ "Com_Date DATE DEFAULT CURRENT_TIMESTAMP, \n"
				+ "Enq_status VARCHAR(50) DEFAULT 'Ouststanding', \n"
				+ "Tech_assigned INT(50) DEFAULT NULL, \n"
				+ "FOREIGN KEY(Acc_num), \n"
				+ "REFERENCES customerinformation (Acc_num),\n"
				+ "PRIMARY KEY(Enquiry_ID));";
		
		String CustomerAcc_Stat = 
				"Create TABLE account_status("
				+ "Invoice_ID INT(50) AUTO_INCREMENT,"
				+ "Acc_num INT(50),\n"
				+ "Account_Stat VARCHAR(50) DEFAULT 'Pending',\n"
				+ "Amount_Owe VARCHAR(50),\n"
				+ "Amount_Paid VARCHAR(50), \n"
				+ "Due_Date VARCHAR(50),\n"
				+ "FOREIGN KEY(Acc_num), \n"
				+ "REFERENCES customerinformation (Acc_num), \n"
				+ "PRIMARY KEY (Invoice_ID));";
		
		String Employee =
				"Create TABLE employeeinformation("
				+ "Emp_Id INT(50) AUTO_INCREMENT,"
				+ "First_Name VARCHAR(50),\n"
				+ "Last_Name VARCHAR(50),\n"
				+ "Emp_Status VARCHAR(50) DEFAULT 'Technician', \n"
				+ "Username VARCHAR(50), \n"
				+ "Password VARCHAR(50), \n"
				+ "FOREIGN KEY (Tech_assigned),\n"
				+ "REFERENCES enquiries (Tech_assigned), \n"
				+ "PRIMARY KEY(Emp_Id));";
		
		Statement stmt; 
		try {
			stmt = (Statement) con.createStatement();
			stmt.execute(createdb);
			stmt.execute(dbchoice);
			stmt.execute(Customer);
			stmt.execute(CustomerEnquiry);
			stmt.execute(CustomerAcc_Stat);
			stmt.execute(Employee);
			
			System.out.println("Database Created.....");
			return true;
		}catch(SQLException sql) {
			System.err.println("Failed to create database....");
		
		return false;
		}
		
	}

}
