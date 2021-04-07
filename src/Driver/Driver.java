package Driver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.CreateDatabase;
import gui.Home;

public class Driver {

	public static void main(String[] args) throws IOException {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
			new Home();
			if(con == null) {
				JOptionPane.showMessageDialog(null, "Setting up Database and table",
						"Database Connection Status", JOptionPane.WARNING_MESSAGE);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root","");
				CreateDatabase db = new CreateDatabase(con);
				boolean IsCreated = db.createTable();
				if (IsCreated == true) { // If database created successfully
					JOptionPane.showMessageDialog(null, "Connected to Database", "DB Connection Status",
							JOptionPane.INFORMATION_MESSAGE);
				}	
				
				new Home();
			}
		}catch(SQLException sql) {
			sql.printStackTrace();
		}
	}


}
