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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.Rectangle;


public class Emp_complaints extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private int res = 0;
	private int out = 0;
	private JTable CompTable;
	protected int eID;
	protected String Com_type;
	protected String Com_Description;
	protected String Com_Date;
	
	
	public Emp_complaints() {
		eID = 0;
		Com_type = "";
		Com_Description = "";
		Com_Date = "";
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
		
		JLabel TaskLabel = new JLabel("Complaints - Resolved:" +res+ "  Outstanding: "+out);
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
		tm.addColumn("Enquiry ID");
		tm.addColumn("Account Number");
		tm.addColumn("Complaint");
		tm.addColumn("Description");
		tm.addColumn("Date of Submission");
		tm.addColumn("Technician Assigned");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
			if(con == null) {
				System.out.println("Can not connect to the database");
			}else {
				int Acc_num = 0;
				String Tech_assigned = "";
				String get = "SELECT Enquiry_ID, Acc_num,Com_Type,Com_Description,Com_Date,Tech_assigned FROM enquiries WHERE Enq_status = 'Outstanding'";
				PreparedStatement pstmt1 = con.prepareStatement(get);
				ResultSet rs = pstmt1.executeQuery();
				
				while(rs.next()){	
					eID = rs.getInt(1);
					Acc_num = rs.getInt(2);
					Com_type =rs.getString(3);
					Com_Description =rs.getString(4);
					Com_Date =rs.getString(5);	
					Tech_assigned = rs.getString(6);
					tm.addRow(new Object[] {eID,Acc_num,Com_type,Com_Description,Com_Date, Tech_assigned});	
			}
			}
			}catch(SQLException sql) {
				sql.printStackTrace();
			}
		CompScrollPane.setViewportView(CompTable);
	}


	public int getRes() {
		return res;
	}


	public int getOut() {
		return out;
	}


	public int geteID() {
		return eID;
	}


	public String getCom_type() {
		return Com_type;
	}


	public String getCom_Description() {
		return Com_Description;
	}


	public String getCom_Date() {
		return Com_Date;
	}


	public void setRes(int res) {
		this.res = res;
	}


	public void setOut(int out) {
		this.out = out;
	}


	public void seteID(int eID) {
		this.eID = eID;
	}


	public void setCom_type(String com_type) {
		Com_type = com_type;
	}


	public void setCom_Description(String com_Description) {
		Com_Description = com_Description;
	}


	public void setCom_Date(String com_Date) {
		Com_Date = com_Date;
	}
	
	
}
