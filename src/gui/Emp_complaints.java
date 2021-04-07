package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import domain.Customer_Enquiry;
import domain.Customer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Emp_complaints extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private int res = 0;
	private int out = 0;
	private JTable CompTable;
	private Customer_Enquiry ce;
	private Customer c;
	
	
	public Emp_complaints() {
		c = new Customer();
		ce = new Customer_Enquiry();
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
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
			if(con == null) {
				System.out.println("Can not connect to the database");
			}else {
				Statement stmt = con.createStatement();
				String query = "SELECT count(*) FROM enquiries WHERE Enq_status = 'Resolved'";
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				res = rs.getInt(1);
				
				String query1 = "SELECT count(*) FROM enquiries WHERE Enq_status = 'Outstanding'";
				ResultSet rs1 = stmt.executeQuery(query1);
				rs1.next();
				out = rs1.getInt(1);
				}
			}catch(SQLException sql) {
				sql.printStackTrace();
			}
		
		JLabel TaskLabel = new JLabel("Complaints - Resolved:  " +res+ "  Outstanding: "+out);
		TaskLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		TaskLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TaskLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		TaskLabel.setBounds(400, 0, 270, 20);
		instrucPanel.add(TaskLabel);
		
		JScrollPane CompScrollPane = new JScrollPane();
		CompScrollPane.setBounds(20, 148, 666, 231);
		getContentPane().add(CompScrollPane);
		
		DefaultTableModel tm = new DefaultTableModel();
		CompTable = new JTable(tm);
		CompTable.setFillsViewportHeight(true);
		CompTable.setPreferredSize(new Dimension(0, 50));
		CompTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tm.addColumn("Account Number");
		tm.addColumn("First Name");
		tm.addColumn("Last Name");
		tm.addColumn("Contact");
		tm.addColumn("Enquiry ID");
		tm.addColumn("Enquiry Type");
		tm.addColumn("Description");
		tm.addColumn("Date of Submission");
		tm.addColumn("Technician Assigned");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
			if(con == null) {
				System.out.println("Can not connect to the database");
			}else {
				String Tech_assigned = "";
				String get = "SELECT c.Acc_num , c.First_Name , c.Last_Name , c.Contact_Num, e.Enquiry_ID,"
						+ "e.Com_Type,e.Com_Description,e.Com_Date,e.Emp_Id FROM customerinformation AS c LEFT JOIN enquiries AS e on c.Acc_num = e.Acc_num";
				PreparedStatement pstmt1 = con.prepareStatement(get);
				ResultSet rs = pstmt1.executeQuery();
				
				while(rs.next()){	
					c.setAcc_num(rs.getInt(1));
					c.setFname(rs.getString(2));
					c.setLname(rs.getString(3));
					c.setNumber(rs.getString(4));
					ce.seteID(rs.getInt(5));
					ce.setCom_type(rs.getString(6));
					ce.setCom_Description(rs.getString(7));
					ce.setCom_Date(rs.getString(8));	
					Tech_assigned = rs.getString(9);
					tm.addRow(new Object[] {c.getAcc_num(),c.getFname(),c.getLname(),c.getNumber(),ce.geteID(),ce.getCom_type(),ce.getCom_Description(),ce.getCom_Date(), Tech_assigned});	
			}
			}
			}catch(SQLException sql) {
				sql.printStackTrace();
			}
		CompScrollPane.setViewportView(CompTable);
		
		JPanel Backpanel = new JPanel();
		Backpanel.setBounds(20, 410, 120, 35);
		getContentPane().add(Backpanel);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new Emp_Dashboard();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		BackButton.setPreferredSize(new Dimension(100, 30));
		BackButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Backpanel.add(BackButton);
	}


	public int getRes() {
		return res;
	}


	public int getOut() {
		return out;
	}
	
	
}
