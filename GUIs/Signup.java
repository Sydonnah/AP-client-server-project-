package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener {

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

	public Signup() {
		fnpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lnpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Emailpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Pwordpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		RPwordpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Fname = new JTextField(20);
		Lname = new JTextField(20);
		Email = new JTextField(20);
		Pword = new JPasswordField(10);
		RPword = new JPasswordField(10);
		this.button = new JButton("Submit");
		this.lblFname = new JLabel("First Name: ");
		this.lblLname = new JLabel("Last Name: ");
		this.lblEmail = new JLabel("Email Address: ");
		this.lblPword = new JLabel("Password: ");
		this.lblRPword = new JLabel("Re-Type Password: ");
		
		Fname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		Fname.setBounds(120,50,150,30);
		
		Lname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		Lname.setBounds(120, 100, 150, 30);
		
		Email.setFont(new Font("Times New Roman",Font.PLAIN,14));
		Email.setBounds(150,150,250,30);
		
		Pword.setFont(new Font("Times New Roman",Font.PLAIN,14));
		Pword.setBounds(120,200,150,30);
		
		RPword.setFont(new Font("Times New Roman",Font.PLAIN,14));
		RPword.setBounds(170, 250,150, 30);
		
		lblFname.setBounds(50, 50, 150, 30);
		lblLname.setBounds(100, 100, 150, 30);
		lblEmail.setBounds(50, 150, 150, 30);
		lblPword.setBounds(50, 200, 150, 30);
		lblRPword.setBounds(50, 250, 150, 30);
		
		
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
		bpanel.add(button);
		add(bpanel);
		
		
		setTitle("Sign Up Section");
		setSize(new Dimension(500,650));
		setResizable(false);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}

