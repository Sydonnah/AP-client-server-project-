package gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import database.CreateDatabase;
import domain.Customer;
import domain.Customer_Enquiry;

import javax.swing.JTextField;

public class Emp_Response extends JFrame {

	final Logger logger = Logger.getLogger(Emp_Response.class);
	private static final long serialVersionUID = 1L;
	private int res = 0;
	private int out = 0;
	private Customer_Enquiry ce;
	
	
	private JTable CompTable;
	

	
	private int searchEmpID;
	


	public Emp_Response() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Carlisha Nicholson\\Documents\\GitHub\\AP-client-server-project-\\cable.jpg"));
		setTitle("MICRO-STAR CABLE VISION");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(new Dimension(725, 500));
		getContentPane().setLayout(null);
		
		JPanel imgpanel = new JPanel();
		imgpanel.setBounds(10, 10, 680, 85);
		getContentPane().add(imgpanel);
		
		JLabel img = new JLabel("");
		img.setSize(new Dimension(680, 85));
		img.setIcon(new ImageIcon("C:\\Users\\Carlisha Nicholson\\Documents\\GitHub\\AP-client-server-project-\\cable.jpg"));
		imgpanel.add(img);
		
		JPanel instrucPanel = new JPanel();
		instrucPanel.setPreferredSize(new Dimension(10, 50));
		instrucPanel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		instrucPanel.setBounds(10, 100, 680, 25);
		getContentPane().add(instrucPanel);
		instrucPanel.setLayout(null);
		
		JLabel instrucLabel = new JLabel("WELCOME " + Emp_LogIn.Username);
		instrucLabel.setBounds(20, 0, 210, 25);
		instrucLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		instrucLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		instrucPanel.add(instrucLabel);
		
		JScrollPane CompScrollPane = new JScrollPane();
		CompScrollPane.setBounds(20, 148, 666, 231);
		getContentPane().add(CompScrollPane);
		
		DefaultTableModel tm = new DefaultTableModel();
		CompTable = new JTable(tm);
		CompTable.setFillsViewportHeight(true);
		CompTable.setPreferredSize(new Dimension(0, 50));
		CompTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tm.addColumn("Enquiry ID");
		tm.addColumn("Account Number");
		tm.addColumn("Complaint");
		tm.addColumn("Description");
		tm.addColumn("Date of Submission");
		tm.addColumn("Technician Assigned");
		tm.addColumn("Technican Response");
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
			if(con == null) {
				System.out.println("Can not connect to the database");
			}else {
				
				//Recovering Employee ID to facilitate narrowing of details according to Emp_ID
				String EmpIDQuery= "SELECT Emp_Id FROM employeeinformation WHERE Username ="+Emp_LogIn.Username;
				Statement stat = con.createStatement();
				ResultSet result= stat.executeQuery(EmpIDQuery);
				//result.next();
				searchEmpID= result.getInt(1);
				
				System.out.println(searchEmpID);
				//Recovers All resolved queries
				Statement stmt = con.createStatement();
				String query = "SELECT count(*) FROM enquiries WHERE Enq_status = 'Resolved' AND Emp_Id = searchEmpID";
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				res = rs.getInt(1);
				
				String query1 = "SELECT count(*) FROM enquiries WHERE Enq_status = 'Outstanding' AND Emp_Id = searchEmpID";
				ResultSet rs1 = stmt.executeQuery(query1);
				rs1.next();
				out = rs1.getInt(1);
				
				int Acc_num = 0;
				String Tech_assigned = "";
				//updated to specific criteria
				String get = "SELECT Enquiry_ID, Acc_num,Com_Type,Com_Description,Com_Date,Emp_Id FROM enquiries WHERE Enq_status = 'Outstanding'AND Emp_Id= searchEmpID AND Emp_Response IS NULL";
				PreparedStatement pstmt1 = con.prepareStatement(get);
				ResultSet results = pstmt1.executeQuery();
				
				while(results.next())
				{	
					ce.seteID(results.getInt(1));
					Acc_num = results.getInt(2);
					ce.setCom_type(results.getString(3));
					ce.setCom_Description(results.getString(4));
					ce.setCom_Date(results.getString(5));	
					Tech_assigned = results.getString(6);
					tm.addRow(new Object[] {ce.geteID(),Acc_num,ce.getCom_type(),ce.getCom_Description(),ce.getCom_Date(), Tech_assigned});	
				}
			}
		}
			catch(SQLException sql)
			{
				sql.printStackTrace();
			}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JLabel TaskLabel = new JLabel("Complaints - Resolved:" +res+ "  Outstanding: "+out);
		TaskLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		TaskLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TaskLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		TaskLabel.setBounds(400, 0, 270, 20);
		instrucPanel.add(TaskLabel);
	
		CompScrollPane.setViewportView(CompTable);
		
	//Addition of back button
	JPanel Backpanel = new JPanel();
	Backpanel.setBounds(20, 410, 120, 35);
	this.getContentPane().add(Backpanel);
	
	JButton BackButton = new JButton("Back");
	BackButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			try {
				logger.warn("Loading Employee Dashboard");
				new Emp_Dashboard();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				logger.error("Error loading Employee Dashboard");
				e1.printStackTrace();
			}
		}
	});
	BackButton.setPreferredSize(new Dimension(100, 30));
	BackButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	Backpanel.add(BackButton);
}
	
	//Function is to add response and change the status of that specific enquiry
	
	private void OutstandingEnquiryTableMouseClicked(java.awt.event.MouseEvent event1)
	{
		String response="";
		String enqID;
		String Acc_num,complaint,description,subdate,techAssigned;
		
		int index = CompTable.getSelectedRow();
		TableModel model = CompTable.getModel();
		
		enqID= (String)model.getValueAt(index,0);
		Acc_num= model.getValueAt(index, 1).toString();
		complaint= model.getValueAt(index,2).toString();
		description=model.getValueAt(index,3).toString();
		subdate=model.getValueAt(index,4).toString();
		techAssigned=model.getValueAt(index,5).toString();
		
		final String tableData= "Enquiry ID: "+enqID +"\nCustomer Account Number: "+Acc_num+
				"\nComplaint Type: "+complaint+"\nComplaint Description: "+description+
				"\n Date of Complaint Submission: "+subdate+"\nTechnician Assigned: "+techAssigned+"\nAdd Response below";
		
		
		
		response=JOptionPane.showInputDialog(null,tableData,"Enter Employee Response");
		
		String sql= "UPDATE enquiries SET Emp_Response ="+response+"WHERE Enquiry_ID ="+enqID;
		
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
			if(con == null) 
			{
				JOptionPane.showMessageDialog(null,"Can not connect to the database","Connection Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
			Statement st = con.createStatement();
			st.executeUpdate(sql); //executes record update
			res++;
			out--;
			JOptionPane.showMessageDialog(null, "Response Added to Enquiry Record", "Update Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}  
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
		

}

