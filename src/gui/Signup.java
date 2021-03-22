package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Signup extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel fnpanel;
	private JPanel lnpanel;
	private JPanel Emailpanel;
	private JPanel Pwordpanel;
	private JPanel RPwordpanel;
	private JPanel bpanel;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField Email;
	private JPasswordField Pword;
	private JPasswordField RPword;
	private JButton button;
	private JLabel lblFname;
	private JLabel lblLname;
	private JLabel lblPword;
	private JLabel lblRPword;
	private JLabel lblEmail;
	
	private String fname;
	private String lname;
	private String email;
	private char[] pword;
	private char[] rpword;

	public Signup() {
		fnpanel = new JPanel();
		lnpanel = new JPanel();
		Emailpanel = new JPanel();
		Pwordpanel = new JPanel();
		RPwordpanel = new JPanel();
		bpanel = new JPanel();
		Fname = new JTextField(20);
		Lname = new JTextField(20);
		Email = new JTextField(20);
		Pword = new JPasswordField(20);
		RPword = new JPasswordField(20);
		this.button = new JButton("Submit");
		this.lblFname = new JLabel("First Name: ");
		this.lblLname = new JLabel("Last Name: ");
		this.lblEmail = new JLabel("Email Address: ");
		this.lblPword = new JLabel("Password: ");
		this.lblRPword = new JLabel("Re-Type Password: ");
		
		Fname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		Lname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		Email.setFont(new Font("Times New Roman",Font.PLAIN,14));
		Pword.setFont(new Font("Times New Roman",Font.PLAIN,14));
		RPword.setFont(new Font("Times New Roman",Font.PLAIN,14));
		
		
		fnpanel.setSize(new Dimension(450,30));
		fnpanel.add(lblFname);
		fnpanel.add(Fname);
		add(fnpanel);
		
		lnpanel.setSize(new Dimension(450,30));
		lnpanel.add(lblLname);	
		lnpanel.add(Lname);
		add(lnpanel);
		
		Emailpanel.setSize(new Dimension (450,30));
		Emailpanel.add(lblEmail);
		Emailpanel.add(Email);
		add(Emailpanel);
		
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

			@Override
			public void actionPerformed(ActionEvent e) {
				fname = Fname.getText();
				lname = Lname.getText();
				email = Email.getText();
				pword = Pword.getPassword();
				rpword = RPword.getPassword();
				
				if(Fname.getText().length() == 0) {
					JOptionPane.showMessageDialog(lblFname, "Must enter a First Name");
				}else if(Lname.getText().length() == 0){
					JOptionPane.showMessageDialog(lblLname, "Must enter a Last Name");
				}else if(Email.getText().length() == 0){
					JOptionPane.showMessageDialog(lblEmail, "Must enter an Email Address");
				}else if(Pword.getPassword().length == 0) {
					JOptionPane.showMessageDialog(lblPword, "Must enter a password");
				}else if(Pword.getPassword().length < 5) {
					JOptionPane.showMessageDialog(lblPword, "Password must be greater than 5 characters long");
				}else if(Arrays.equals(pword, rpword) == false){
					JOptionPane.showMessageDialog(RPword, "Password mismatch, please try again");
				}else if(button.isSelected()){
				//insert database code
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

	public Signup(String fname, String lname, String email, char[] pword, char[] rpword) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pword = pword;
		this.rpword = rpword;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getEmail() {
		return email;
	}

	public char[] getPword() {
		return pword;
	}

	public char[] getRpword() {
		return rpword;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPword(char[] pword) {
		this.pword = pword;
	}

	public void setRpword(char[] rpword) {
		this.rpword = rpword;
	}
	
	

}

