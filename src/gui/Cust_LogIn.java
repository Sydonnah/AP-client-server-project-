package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
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

import org.apache.log4j.Logger;

import domain.Customer;


public class Cust_LogIn extends JFrame {
	
	final Logger logger = Logger.getLogger(Cust_LogIn.class);
	
	private static final long serialVersionUID = 1L;
	private JPanel urnamepanel;
	private JPanel pwordpanel;
	private JPanel signupPanel;
	private JPanel loginpanel;
	private JPanel backpanel;
	private JLabel lblurname;
	private JLabel lblpword; 
	protected static JTextField urname;
	private JPasswordField pword;
	private JButton Signup;
	private JButton Login;
	private JButton Back;
	private Customer cust;	
	protected Home h;
	
	
	public Cust_LogIn() throws IOException {
		logger.info("Customer login loaded successfully");
		
		cust = new Customer();
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
		Back.setMnemonic(KeyEvent.VK_ESCAPE);
		Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				dispose();
				try {
					logger.warn("Loading Home menu");
					h = new Home();
				} catch (IOException e1) {
					logger.error("Error loading Home menu");
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
					logger.warn("Loading signup screen");
					new Signup();
				} catch (Exception e1) {
					logger.error("Error loading signup screen");
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
				cust.setUser(urname.getText());
				cust.setPword(pword.getText());
				
				if (cust.getUser().isEmpty() || cust.getPword().isEmpty() ) {
					JOptionPane.showMessageDialog(Login, "Field can not be empty");
				} else{
						try {
							logger.warn("Attempting to connect to database");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
							if(con == null) {
								// Cannot connect to database
							}else {
								logger.info("Connection to database successful");
								String read = "SELECT * FROM customerinformation WHERE Username = ? and Password = ?" ;
								PreparedStatement pstmt = con.prepareStatement(read);
								pstmt.setString(1, cust.getUser());
								pstmt.setString(2, cust.getPword());
								ResultSet rs = pstmt.executeQuery();
								if(rs.next()) {
									dispose();
									try {
										logger.warn("Loading Customer Dashboard");
										new Cust_Dashboard();
									} catch (Exception e1) {
										logger.error("Error loading Customer Dashboard");
										e1.printStackTrace();
									}
								}else {
									logger.info("Login failed, credential mismatch");
									JOptionPane.showMessageDialog(Login, "Credentials do not match database");
									urname.setText("");
									urname.requestFocus();
									pword.setText("");
								}
							}
						} catch (SQLException sql) {
							logger.error("Failed to connect to database");
							sql.printStackTrace();
						}
				}			
			}
			
		});
		add(loginpanel);
		
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Carlisha Nicholson\\Documents\\GitHub\\AP-client-server-project-\\cable.jpg"));
		setTitle("Customer Log In Section");
		setSize(new Dimension(400,450));
		setResizable(false);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}

	
	
	/*
	 * public static void main (String []args) { new Cust_LogIn(); }
	 */

}
