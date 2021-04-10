package Driver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import database.CreateDatabase;
import gui.Cust_LogIn;
import gui.Emp_LogIn;
import gui.Home;

public class Driver_Employee {

	/**
	 * @param args
	 * @throws IOException
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws IOException, SQLException {
		
		final Logger logger = Logger.getLogger(Driver.class);
		
		try {
			logger.warn("Attempting to connect to database");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
			
			logger.info("Database connection successful");
			logger.info("Loading Employee Menu");
				new Emp_LogIn();
				
		}catch(Exception e) {
			logger.error("Database connection failed");
			logger.warn("Attempting to create database instead");
			
			Connection con = null;
			JOptionPane.showMessageDialog(null, "Setting up Database and table",
						"Database Connection Status", JOptionPane.WARNING_MESSAGE);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root","");
				CreateDatabase db = new CreateDatabase(con);
				boolean IsCreated = db.createTable();
				if (IsCreated == true) { // If database created successfully
					logger.info("Database created successful");
					JOptionPane.showMessageDialog(null, "Connected to Database", "DB Connection Status",
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					logger.info("Failed to create database");
				}
				
				logger.info("Loading Employee Menu");
				new Emp_LogIn();
	}
	}


}
