package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JPanel backpanel;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField Email;
	private JPasswordField Pword;
	private JPasswordField RPword;
	private JButton button;
	private JButton backbutton;
	private JLabel lblFname;
	private JLabel lblLname;
	private JLabel lblPword;
	private JLabel lblRPword;
	private JLabel lblEmail;
	
	private String fname;
	private String lname;
	private String email;
	private String pword;
	private String rpword;
	protected Cust_LogIn cl;

	public Signup() {
		fnpanel = new JPanel();
		lnpanel = new JPanel();
		Emailpanel = new JPanel();
		Pwordpanel = new JPanel();
		RPwordpanel = new JPanel();
		bpanel = new JPanel();
		backpanel = new JPanel();
		Fname = new JTextField(20);
		Lname = new JTextField(20);
		Email = new JTextField(20);
		Pword = new JPasswordField(20);
		RPword = new JPasswordField(20);
		this.button = new JButton("Submit");
		this.backbutton = new JButton("Go Back");
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
		
		
		backpanel.setSize(new Dimension(450,30));
		backbutton.setPreferredSize(new Dimension(150,30));
		backpanel.add(backbutton);
		backbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				cl = new Cust_LogIn();
				
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

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				fname = Fname.getText();
				lname = Lname.getText();
				email = Email.getText();
				pword = Pword.getText();
				rpword = RPword.getText();
				
				if(Fname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(lblFname, "Must enter a First Name");
				}else if(Lname.getText().isEmpty()){
					JOptionPane.showMessageDialog(lblLname, "Must enter a Last Name");
				}else if(Email.getText().isEmpty()){
					JOptionPane.showMessageDialog(lblEmail, "Must enter an Email Address");
				}else if(Pword.getText().isEmpty()) {
					JOptionPane.showMessageDialog(lblPword, "Must enter a password");
				}else if(Pword.getText().length() < 5) {
					JOptionPane.showMessageDialog(lblPword, "Password must be greater than 5 characters long");
				}else if((Pword.getText().equals(RPword.getText())) == false){
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

	public Signup(String fname, String lname, String email, String pword, String rpword) {
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

	public String getPword() {
		return pword;
	}

	public String getRpword() {
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

	public void setPword(String pword) {
		this.pword = pword;
	}

	public void setRpword(String rpword) {
		this.rpword = rpword;
	}
	
	
	  //public static void main (String args[]) { new Signup(); }
	 
}

