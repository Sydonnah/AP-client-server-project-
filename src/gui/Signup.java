package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import domain.Customer;

public class Signup extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel fnpanel;
	private JPanel lnpanel;
	private JPanel conpanel;
	private JPanel Emailpanel;
	private JPanel U_namepanel;
	private JPanel Pwordpanel;
	private JPanel RPwordpanel;
	private JPanel bpanel;
	private JPanel backpanel;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField contact;
	private JTextField Email;
	private JTextField Username;
	private JPasswordField Pword;
	private JPasswordField RPword;
	private JButton button;
	private JButton backbutton;
	private JLabel lblFname;
	private JLabel lblLname;
	private JLabel lblcontact;
	private JLabel lblPword;
	private JLabel lblRPword;
	private JLabel lblEmail;
	private JLabel lblUname;
	private Customer cust;
	

	public Signup() {
		
		Logger logger = Logger.getLogger(Signup.class);
		
		cust = new Customer();
		fnpanel = new JPanel();
		lnpanel = new JPanel();
		conpanel = new JPanel();
		Emailpanel = new JPanel();
		U_namepanel = new JPanel();
		Pwordpanel = new JPanel();
		RPwordpanel = new JPanel();
		bpanel = new JPanel();
		backpanel = new JPanel();
		Fname = new JTextField(20);
		Lname = new JTextField(20);
		contact = new JTextField(10);
		Email = new JTextField(20);
		Username = new JTextField(20);
		Pword = new JPasswordField(20);
		RPword = new JPasswordField(20);
		this.button = new JButton("Submit");
		this.backbutton = new JButton("Go Back");
		this.lblFname = new JLabel("First Name: ");
		this.lblLname = new JLabel("Last Name: ");
		this.lblcontact = new JLabel("Telephone: ");
		this.lblEmail = new JLabel("Email Address: ");
		this.lblUname = new JLabel("Username: ");
		this.lblPword = new JLabel("Password: ");
		this.lblRPword = new JLabel("Re-Type Password: ");
		
		Fname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		Lname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		contact.setFont(new Font("Times New Roman",Font.PLAIN,14));
		Email.setFont(new Font("Times New Roman",Font.PLAIN,14));
		Username.setFont(new Font("Times New Roman",Font.PLAIN,14));
		Pword.setFont(new Font("Times New Roman",Font.PLAIN,14));
		RPword.setFont(new Font("Times New Roman",Font.PLAIN,14));
		
		
		backpanel.setSize(new Dimension(450,30));
		backbutton.setPreferredSize(new Dimension(150,30));
		backpanel.add(backbutton);
		backbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					logger.warn("Loading Customer Login screen");
					new Cust_LogIn();
				} catch (IOException e1) {
					logger.error("Error loading Customer Login");
					e1.printStackTrace();
				}
				
			}
		});
		add(backpanel);
			
		fnpanel.setSize(new Dimension(450,30));
		fnpanel.add(lblFname);
		fnpanel.add(Fname);	
		add(fnpanel);
		
		lnpanel.setSize(new Dimension(450,30));
		lnpanel.add(lblLname);	
		lnpanel.add(Lname);
		add(lnpanel);
		
		conpanel.setSize(new Dimension(450,30));
		conpanel.add(lblcontact);
		conpanel.add(contact);
		add(conpanel);
		
		Emailpanel.setSize(new Dimension (450,30));
		Emailpanel.add(lblEmail);
		Emailpanel.add(Email);
		add(Emailpanel);
		
		U_namepanel.setSize(new Dimension (450,30));
		U_namepanel.add(lblUname);
		U_namepanel.add(Username);
		add(U_namepanel);
		
		Pwordpanel.setSize(new Dimension(450,30));
		Pwordpanel.add(lblPword);
		Pwordpanel.add(Pword);
		add(Pwordpanel);
		
		RPwordpanel.setSize(new Dimension(450,30));
		RPwordpanel.add(lblRPword);
		RPwordpanel.add(RPword);
		add(RPwordpanel);
		
		bpanel.setSize(new Dimension(450,30));
		button.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				cust.setFname(Fname.getText());
				cust.setLname(Lname.getText());
				cust.setNumber(contact.getText());
				cust.setEmail(Email.getText());
				cust.setUser(Username.getText());
				cust.setPword(Pword.getText());
				cust.setRpword(RPword.getText());
				
				if(Fname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(lblFname, "Must enter a First Name");
				}else if(Lname.getText().isEmpty()){
					JOptionPane.showMessageDialog(lblLname, "Must enter a Last Name");
				}else if(contact.getText().isEmpty()) {
					JOptionPane.showMessageDialog(lblcontact, "Must enter a Telephone Number");
				}else if(Email.getText().isEmpty()){
					JOptionPane.showMessageDialog(lblEmail, "Must enter an Email Address");
				}else if(Username.getText().isEmpty()) {
					JOptionPane.showMessageDialog(lblUname, "Must enter an Username");
				}else if(Pword.getText().isEmpty()) {
					JOptionPane.showMessageDialog(lblPword, "Must enter a password");
				}else if(Pword.getText().length() < 5) {
					JOptionPane.showMessageDialog(lblPword, "Password must be greater than 5 characters long");
				}else if((Pword.getText().equals(RPword.getText())) == false){
					JOptionPane.showMessageDialog(RPword, "Password mismatch, please try again");
				}else {
					try {
						logger.warn("Connecting to database");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
						if(con == null) {
							// Cannot connect to the database
						}else {
							String add = "INSERT INTO customerinformation (Acc_num, First_Name,Last_Name,Contact_Num,Email,Username,Password) VALUES ("
							+cust.getAcc_num()+",'"+Fname.getText()+"','"+Lname.getText()+"','"+contact.getText()+"','"+Email.getText()+"','"+Username.getText()+"','"+Pword.getText()+"')";    
								Statement stmt = con.createStatement();
								stmt.executeUpdate(add);
								logger.info("Sign up successful");
									JOptionPane.showMessageDialog(button, "Sign up Sucessful");
									dispose();
									logger.warn("Loading Customer Login");
									new Cust_LogIn();
						}
					}catch (SQLException sql) {
						logger.error("Error interacting with database");
						sql.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		bpanel.add(button);
		add(bpanel);
		
		
		setTitle("Customer Sign Up Section");
		setSize(new Dimension(450,500));
		setResizable(false);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	
	  //public static void main (String args[]) { new Signup(); }
	 
}

