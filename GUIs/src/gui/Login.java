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

public class LogIn extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel urnamepanel;
	private JPanel pwordpanel;
	private JPanel signupPanel;
	private JPanel loginpanel;
	private JLabel lblurname;
	private JLabel lblpword; 
	private JTextField urname;
	private JPasswordField pword;
	private JButton Signup;
	private JButton Login;
	
	public LogIn() {
		urnamepanel = new JPanel();
		pwordpanel = new JPanel();
		signupPanel = new JPanel();
		loginpanel = new JPanel();
		this.lblurname = new JLabel("Username: ");
		this.lblpword = new JLabel("Password: ");
		urname = new JTextField(20);
		pword = new JPasswordField(20);
		this.Signup = new JButton("SIGN UP");
		this.Login = new JButton("LOGIN");
		
		urname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		
		
		pword.setFont(new Font("Times New Roman",Font.PLAIN,14));
	
		
		urnamepanel.setSize(new Dimension(450,30));
		urnamepanel.add(lblurname);
		urnamepanel.add(urname);
		add(urnamepanel);
		
		pwordpanel.setSize(new Dimension(450,30));
		pwordpanel.add(lblpword);
		pwordpanel.add(pword);
		add(pwordpanel);
		
		signupPanel.setSize(new Dimension(450,30));
		signupPanel.add(Signup);
		add(signupPanel);
		
		loginpanel.setSize(new Dimension(450,30));
		loginpanel.add(Login);
		add(loginpanel);
		
		
		
		setTitle("Log In Section");
		setSize(new Dimension(400,450));
		setResizable(false);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String []args) {
		new LogIn();
	}

}
