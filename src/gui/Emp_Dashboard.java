package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import org.apache.log4j.Logger;

public class Emp_Dashboard extends JFrame {
	
	final Logger logger = Logger.getLogger(Emp_Dashboard.class);

	private static final long serialVersionUID = 1L;
	protected int res = 0; 
	protected int out = 0; 



	public Emp_Dashboard() {
		logger.info("Employee Dashboard loaded successfully");
		
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
			logger.warn("Connecting to database");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
			if(con == null) {
				//Can not connect to the database
				logger.warn("Databse connection null");
			}else {
				logger.info("Database connection successful");
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
			logger.error("Failed to connect to database");
			sql.printStackTrace();
		}

		JLabel TaskLabel = new JLabel("Complaints - Resolved:" +res+ "  Outstanding: "+out);
		TaskLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		TaskLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TaskLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		TaskLabel.setBounds(400, 0, 270, 20);
		instrucPanel.add(TaskLabel);

		JPanel ContPan = new JPanel();
		ContPan.setAlignmentX(Component.RIGHT_ALIGNMENT);
		ContPan.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ContPan.setBounds(75, 180, 540, 215);
		getContentPane().add(ContPan);
		ContPan.setLayout(new GridLayout(1, 2, 10, 10));

		JButton Service1Button = new JButton("COMPLAINTS");
		Service1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					logger.warn("Loading Employee Complaints screen");
					new Emp_complaints();
				} catch (Exception e1) {
					logger.error("Error loading Employee Complaints screen");
					e1.printStackTrace();
				}
			}
		});
		Service1Button.setBorder(new LineBorder(Color.BLUE));
		Service1Button.setForeground(Color.BLUE);
		Service1Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Service1Button.setPreferredSize(new Dimension(100, 50));
		ContPan.add(Service1Button);

		JButton Service2Button = new JButton("ASSIGNMENT");	
		Service2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					logger.warn("Connecting to database");
					String status = "";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
					if(con == null) {
						//Can not connect to the database
						logger.warn("Database connection null");
					}else{
						logger.info("Database connection successful");
						String read = "SELECT Emp_Status FROM employeeinformation WHERE Username = '" +Emp_LogIn.Username+"'" ;
						PreparedStatement pstmt = con.prepareStatement(read);
						ResultSet rs = pstmt.executeQuery();
						while(rs.next()) {
							status = rs.getString(1);
						}
					} 
					String compstatus = "Representative"; 
					if (status.equals(compstatus)) {
						dispose();
						logger.warn("Loading Assignment Screen");
						new Emp_assign();
						}else {
							logger.warn("Blocked Technician from loading Assignment screen");
							JOptionPane.showMessageDialog(Service2Button, "Access Denied.....You are not a Representative ");
						}

				} catch (SQLException e1) {
					logger.error("Failed to connect to database");
					e1.printStackTrace();
				}
			}
		});



		Service2Button.setBorder(new LineBorder(Color.BLUE));
		Service2Button.setForeground(Color.BLUE);
		Service2Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Service2Button.setPreferredSize(new Dimension(100, 50));
		ContPan.add(Service2Button);

		JButton Service3Button = new JButton("RESPONSE");
		Service3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				logger.warn("Loading Response screen");
				
				new Emp_Response();
			}
		});
		Service3Button.setBorder(new LineBorder(Color.BLUE));
		Service3Button.setForeground(Color.BLUE);
		Service3Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Service3Button.setPreferredSize(new Dimension(100, 50));
		ContPan.add(Service3Button);

		JPanel LogOutpan = new JPanel();
		LogOutpan.setBounds(590, 415, 112, 50);
		getContentPane().add(LogOutpan);

		JButton LogOut = new JButton("Log Out");
		LogOut.setPreferredSize(new Dimension(75, 35));
		LogOut.setBorder(new LineBorder(Color.BLUE));
		LogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					logger.warn("Loading Employee Login screen");
					new Emp_LogIn();
				} catch (Exception e1) {
					logger.error("Error loading Employee Login screen");
					e1.printStackTrace();
				}

			}
		});

		LogOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		LogOutpan.add(LogOut);
		
		JButton LIveButton = new JButton("Live Chat");
		LIveButton.setBorder(new LineBorder(new Color(0, 0, 205)));
		LIveButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		LIveButton.setBounds(61, 415, 87, 34);
		LIveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					dispose();
					
					logger.warn("Loading Employee Live chat");
					
					Client c1 = new Client();
					c1.setTitle("Employee Live Chat");
					c1.setVisible(true);
					
			}

		});
		
		
		getContentPane().add(LIveButton);
	}
	
	
}
