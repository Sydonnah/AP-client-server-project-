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

public class Emp_LogIn extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel urnamepanel;
	private JPanel pwordpanel;
	private JPanel loginpanel;
	private JLabel lblurname;
	private JLabel lblpword; 
	private JTextField urname;
	private JPasswordField pword;
	private JButton Login;
	
	private String Username;
	private char[] password;
	
	public Emp_LogIn() {
		urnamepanel = new JPanel();
		pwordpanel = new JPanel();
		new JPanel();
		loginpanel = new JPanel();
		this.lblurname = new JLabel("ID: ");
		this.lblpword = new JLabel("Password: ");
		urname = new JTextField(20);
		pword = new JPasswordField(20);
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
		
		loginpanel.setSize(new Dimension(450,30));
		loginpanel.add(Login);
		Login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Username = urname.getText();
				password = pword.getPassword();
				
				if (urname.getText().length() == 0 ) {
					JOptionPane.showMessageDialog(lblurname, "Field can not be empty");
				} else if (pword.getPassword().length == 0) {
					JOptionPane.showMessageDialog(lblpword, "Field can not be empty");
				}
				// read info from file and validate
				
			}
			
		});
		add(loginpanel);
		
		
		
		
		setTitle("Employee Log In Section");
		setSize(new Dimension(400,450));
		setResizable(false);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}

	public Emp_LogIn(String username, char[] password) {
		Username = username;
		this.password = password;
	}

	public String getUsername() {
		return Username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}
	
	

	
}
