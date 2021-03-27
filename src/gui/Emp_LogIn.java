package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

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
	private JPanel backpanel;
	private JLabel lblurname;
	private JLabel lblpword; 
	private JTextField urname;
	private JPasswordField pword;
	private JButton Login;
	private JButton back;
	
	private String Username;
	private String password;
	protected Home h;
	
	public Emp_LogIn() {
		urnamepanel = new JPanel();
		pwordpanel = new JPanel();
		backpanel = new JPanel();
		loginpanel = new JPanel();
		this.lblurname = new JLabel("ID: ");
		this.lblpword = new JLabel("Password: ");
		urname = new JTextField("ID",20);
		pword = new JPasswordField("Password",20);
		this.Login = new JButton("LOGIN");
		this.back = new JButton("Go Back");
		
		urname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		pword.setFont(new Font("Times New Roman",Font.PLAIN,14));
	
		backpanel.setSize(new Dimension(450,30));
		back.setPreferredSize(new Dimension(150,30));
		backpanel.add(back);
		back.addActionListener(new ActionListener() {

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
                if(urname.getText().equals("ID"))
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
                    urname.setText("ID");

                }
            }
        });
		add(urnamepanel);
		
		pwordpanel.setSize(new Dimension(450,30));
		pwordpanel.add(lblpword);
		pwordpanel.add(pword);
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
		
		loginpanel.setSize(new Dimension(450,30));
		loginpanel.add(Login);
		Login.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				Username = urname.getText();
				password = pword.getText();
				
				if (urname.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(lblurname, "Field can not be empty");
				} else if (pword.getText().isEmpty()) {
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

	public Emp_LogIn(String username, String password) {
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
	 * public static void main(String args[]) { new Emp_LogIn(); }
	 */

	
}
