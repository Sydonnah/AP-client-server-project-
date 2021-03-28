package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Cust_LogIn extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel urnamepanel;
	private JPanel pwordpanel;
	private JPanel signupPanel;
	private JPanel loginpanel;
	private JPanel backpanel;
	private JLabel lblurname;
	private JLabel lblpword; 
	private JTextField urname;
	private JPasswordField pword;
	private JButton Signup;
	private JButton Login;
	private JButton Back;
	
	protected static String Username;
	protected String password;
	protected Home h;
	
	
	public Cust_LogIn() throws IOException {
		urnamepanel = new JPanel();
		pwordpanel = new JPanel();
		signupPanel = new JPanel();
		loginpanel = new JPanel();
		backpanel = new JPanel();
		this.lblurname = new JLabel("Username: ");
		this.lblpword = new JLabel("Password: ");
		urname = new JTextField("Username",20);
		pword = new JPasswordField(20);
		this.Signup = new JButton("SIGN UP");
		this.Login = new JButton("LOGIN");
		this.Back = new JButton("GO BACK");
		
		urname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		pword.setFont(new Font("Times New Roman",Font.PLAIN,14));
	
		
		backpanel.setSize(new Dimension(450,30));
		backpanel.add(Back);
		Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					h = new Home();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		add(backpanel);
		
		
		urnamepanel.setSize(new Dimension(450,30));
		urnamepanel.add(lblurname);
		urnamepanel.add(urname);
		urname.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent arg0)
            {
                if(urname.getText().equals("Username"))
                {
                    urname.setText("");
                }
                else {
                    urname.selectAll();
                }
            }@Override
            public void focusLost(FocusEvent arg0)
            {
                if(urname.getText().equals(""))
                {
                    urname.setText("Username");

                }
            }
        });
		add(urnamepanel);
		
		pwordpanel.setSize(new Dimension(450,30));
		pwordpanel.add(lblpword);
		pwordpanel.add(pword);
		pword.setText("Password");
		pword.addFocusListener(new FocusAdapter()
        {
            @SuppressWarnings("deprecation")
			@Override
            public void focusGained(FocusEvent arg0)
            {
                if(pword.getText().equals("Password"))
                {
                    ((JPasswordField) pword).setEchoChar('*');
                    pword.setText("");
                }
                else {
                    pword.selectAll();
                }

            }
            @SuppressWarnings("deprecation")
			@Override
            public void focusLost(FocusEvent arg0)
            {
                if(pword.getText().equals(""))
                {
                    pword.setText("Password");
                    ((JPasswordField) pword).setEchoChar((char)0);

                }
            }
        });
		
		add(pwordpanel);
		
		signupPanel.setSize(new Dimension(450,30));
		signupPanel.add(Signup);
		Signup.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new Signup();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		add(signupPanel);
		
		loginpanel.setSize(new Dimension(450,30));
		loginpanel.add(Login);
		Login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				Username = urname.getText();
				password = pword.getText();
				
				if (urname.getText().isEmpty() || pword.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(Login, "Field can not be empty");
				} else{
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
							if(con == null) {
								System.out.println("Can not connect to the database");
							}else {
								String read = "SELECT * FROM customerinformation WHERE Username = ? and Password = ?" ;
								PreparedStatement pstmt = con.prepareStatement(read);
								pstmt.setString(1, urname.getText());
								pstmt.setString(2, pword.getText());
								ResultSet rs = pstmt.executeQuery();
								if(rs.next()) {
									dispose();
									try {
										new Cust_Dashboard();
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}else {
									JOptionPane.showMessageDialog(Login, "Credentials do not match database");
									urname.setText("");
									urname.requestFocus();
									pword.setText("");
								}
							}
						} catch (SQLException sql) {
							sql.printStackTrace();
						}
				}			
			}
			
		});
		add(loginpanel);
		
		
		
		
		setTitle("Customer Log In Section");
		setSize(new Dimension(400,450));
		setResizable(false);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}


	public Cust_LogIn(String username, String password) {
		Username = username;
		this.password = password;
	}


	public String getUsername() {
		return Username;
	}


	public String getPassword() {
		return password;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	/*
	 * public static void main (String []args) { new Cust_LogIn(); }
	 */

}
