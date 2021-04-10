package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import domain.Customer_Enquiry;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Enquiry_History extends JFrame {
	
	final Logger logger = Logger.getLogger(Enquiry_History.class);

	private static final long serialVersionUID = 1L;
	private JTable Enq_his_table;
	private Customer_Enquiry ce;
	
	public Enquiry_History() throws IOException{
		logger.info("Enquiry History loaded succesfully");
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
		
		JPanel headPanel = new JPanel();
		headPanel.setPreferredSize(new Dimension(10, 50));
		headPanel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		headPanel.setBounds(10, 100, 680, 25);
		getContentPane().add(headPanel);
		
		JLabel headLabel = new JLabel("WELCOME " + Cust_LogIn.urname.getText()+ ", "+ "HERE IS YOUR ENQUIRY HISTORY?: ");
		headLabel.setPreferredSize(new Dimension(600, 24));
		headLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		headLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		headPanel.add(headLabel);
		
		JPanel GBpanel = new JPanel();
		GBpanel.setBounds(20, 420, 105, 40);
		getContentPane().add(GBpanel);
		
		JButton BackButton = new JButton("Go Back");
		BackButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					logger.warn("Loading Customer Dashboard");
					 new Cust_Dashboard();
				} catch (IOException e1) {
					logger.error("Error loading Customer Dashboard");
					e1.printStackTrace();
				}
			}
		});
		BackButton.setBorder(new LineBorder(Color.BLUE));
		BackButton.setPreferredSize(new Dimension(75, 30));
		BackButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GBpanel.add(BackButton);
		
		JScrollPane EnqscrollPane = new JScrollPane();
		EnqscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		EnqscrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		EnqscrollPane.setBounds(20, 150, 675, 250);
		getContentPane().add(EnqscrollPane);
		
		DefaultTableModel tm = new DefaultTableModel();
		Enq_his_table = new JTable(tm) {
			private static final long serialVersionUID = 1L;
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};	
		
		tm.addColumn("Enquiry ID");
		tm.addColumn("Complaint");
		tm.addColumn("Description");
		tm.addColumn("Date of Submission");
		try {
			logger.warn("Connecting to database");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
			if(con == null) {
				//Can not connect to the database
				logger.warn("Database connection null");
			}else {
				logger.info("Database connection successful");
				logger.info("Displaying history details");
				int Acc_num = 0;
				String read = "SELECT Acc_num FROM customerinformation WHERE Username = '" +Cust_LogIn.urname.getText()+"'" ;
				PreparedStatement pstmt = con.prepareStatement(read);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Acc_num = rs.getInt(1);
				}
				String get = "SELECT Enquiry_ID, Com_Type,Com_Description,Com_Date FROM enquiries WHERE Acc_num = '" +Acc_num+ "'";
				PreparedStatement pstmt1 = con.prepareStatement(get);
				ResultSet rs1 = pstmt1.executeQuery();
				
				while(rs1.next()){	
					ce.seteID(rs1.getInt(1));
					ce.setCom_type(rs1.getString(2));
					ce.setCom_Description(rs1.getString(3));
					ce.setCom_Date(rs1.getString(4));		
					tm.addRow(new Object[] {ce.geteID(),ce.getCom_type(),ce.getCom_Description(),ce.getCom_Date()});
				}
			}
		}catch(SQLException sql) {
			logger.error("Failed to connect to database");
			sql.printStackTrace();
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		Enq_his_table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Enq_his_table.setPreferredSize(new Dimension(20, 220));
		EnqscrollPane.setViewportView(Enq_his_table);
	}

}
