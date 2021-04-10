 package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import org.apache.log4j.Logger;

import domain.Customer_Enquiry;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class Enquiry extends JFrame {
	
	final Logger logger = Logger.getLogger(Enquiry.class);

	private static final long serialVersionUID = 1L;
	private Customer_Enquiry ce;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Enquiry() throws IOException {
		logger.info("Enquiry loaded successfully");
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
		instrucPanel.setBounds(10, 100, 680, 25);
		instrucPanel.setPreferredSize(new Dimension(10, 50));
		instrucPanel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		getContentPane().add(instrucPanel);
		
		JLabel instrucLabel = new JLabel("WELCOME "+ Cust_LogIn.urname.getText()+ ", "+ "PLEASE LODGE YOUR COMPLAINTS HERE");
		instrucLabel.setPreferredSize(new Dimension(600, 24));
		instrucLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		instrucLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		instrucPanel.add(instrucLabel);
		
		JLabel CompLabel = new JLabel("Complaint Type :");
		CompLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		CompLabel.setBounds(40, 151, 100, 30);
		getContentPane().add(CompLabel);
		
		JComboBox CompcomboBox = new JComboBox();
		CompcomboBox.setBorder(new LineBorder(Color.BLUE));
		CompcomboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		CompcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Internet Issues ", "Connectivity Issues ", "Payment Issues "}));
		CompcomboBox.setBackground(Color.WHITE);
		CompcomboBox.setBounds(150, 151, 165, 30);
		getContentPane().add(CompcomboBox);
		
		JLabel DesLabel = new JLabel("Description :");
		DesLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		DesLabel.setBounds(40, 225, 100, 20);
		getContentPane().add(DesLabel);
		
		JTextArea DestextArea = new JTextArea();
		DestextArea.setBorder(new LineBorder(Color.BLUE));
		DestextArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DestextArea.setBounds(150, 223, 366, 153);
		getContentPane().add(DestextArea);
		
		JPanel backpanel = new JPanel();
		backpanel.setBounds(40, 414, 100, 46);
		getContentPane().add(backpanel);
		
		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(new ActionListener() {
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
		backButton.setPreferredSize(new Dimension(80, 30));
		backButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		backButton.setBorder(new LineBorder(Color.BLUE));
		backpanel.add(backButton);
		
		JPanel Submitpanel = new JPanel();
		Submitpanel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Submitpanel.setBounds(559, 414, 100, 46);
		getContentPane().add(Submitpanel);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					logger.warn("COnnecting to database");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
					if(con == null) {
						//Can not connect to the database
						logger.warn("Database connection null");
						JOptionPane.showMessageDialog(SubmitButton, "Can not make an Enquiry at this Time....please try again later");
					}else {
						logger.info("Database connection successful");
						int Acc_num = 0;
						String read = "SELECT Acc_num FROM customerinformation WHERE Username = '" +Cust_LogIn.urname.getText()+"'" ;
						PreparedStatement pstmt = con.prepareStatement(read);
						ResultSet rs = pstmt.executeQuery();
						while(rs.next()) {
							Acc_num = rs.getInt(1);
						}
						
						int Enquiry_ID = 0;
						ce.setCom_type(CompcomboBox.getSelectedItem().toString());
						ce.setCom_Date(LocalDate.now().toString());
						ce.setCom_Description(DestextArea.getText());
						String add = "INSERT INTO enquiries (Enquiry_ID, Acc_num,com_Type,Com_Description,Com_Date) VALUES ('"
						+Enquiry_ID+"','"+Acc_num+"','"+ce.getCom_type()+"','"+ce.getCom_Description()+"','"+ce.getCom_Date()+"')";
						Statement stmt = con.createStatement();
						stmt.executeUpdate(add);
						logger.info("Enquire lodged successfully");
						JOptionPane.showMessageDialog(SubmitButton, "Enquiry Successfully Lodged");
						dispose();
						logger.warn("Loading Customer Dashboard");
						new Cust_Dashboard();
					}
				}catch(SQLException sql) {
					logger.error("Failed to connect to database");
					sql.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		SubmitButton.setBorder(new LineBorder(Color.BLUE));
		SubmitButton.setPreferredSize(new Dimension(80, 30));
		SubmitButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Submitpanel.add(SubmitButton);
	}
}
