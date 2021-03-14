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

	
}