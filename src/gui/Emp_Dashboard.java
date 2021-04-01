package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;

public class Emp_Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected int res = 0; 
	protected int out = 0; 


	public Emp_Dashboard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Carlisha Nicholson\\Documents\\GitHub\\AP-client-server-project-\\cable.jpg"));
		setTitle("MICRO-STAR CABLE VISION");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(new Dimension(725, 500));
		getContentPane().setLayout(null);
		
		JPanel imgpanel = new JPanel();
		imgpanel.setBounds(10, 10, 680, 85);
		getContentPane().add(imgpanel);
		
		JLabel img = new JLabel("");
		img.setSize(new Dimension(680, 85));
		img.setIcon(new ImageIcon("C:\\Users\\Carlisha Nicholson\\Documents\\GitHub\\AP-client-server-project-\\cable.jpg"));
		imgpanel.add(img);
		
		JPanel instrucPanel = new JPanel();
		instrucPanel.setPreferredSize(new Dimension(10, 50));
		instrucPanel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		instrucPanel.setBounds(10, 100, 680, 25);
		getContentPane().add(instrucPanel);
		instrucPanel.setLayout(null);
		
		JLabel instrucLabel = new JLabel("WELCOME " + Emp_LogIn.Username);
		instrucLabel.setBounds(20, 0, 210, 25);
		instrucLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		instrucLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		instrucPanel.add(instrucLabel);
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
			if(con == null) {
				System.out.println("Can not connect to the database");
			}else {
				String count = ""; 
				}
			}catch(SQLException sql) {
				sql.printStackTrace();
			}
		
		JLabel TaskLabel = new JLabel("Complaints - Resolved:" +res+ "  Outstanding: "+out);
		TaskLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		TaskLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TaskLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		TaskLabel.setBounds(400, 0, 270, 20);
		instrucPanel.add(TaskLabel);
		
		JPanel ContPan = new JPanel();
		ContPan.setAlignmentX(Component.RIGHT_ALIGNMENT);
		ContPan.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ContPan.setBounds(75, 180, 540, 215);
		getContentPane().add(ContPan);
		ContPan.setLayout(new GridLayout(1, 2, 10, 10));
		
		JButton Service1Button = new JButton("COMPLAINTS");
		Service1Button.setBorder(new LineBorder(Color.BLUE));
		Service1Button.setForeground(Color.BLUE);
		Service1Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Service1Button.setPreferredSize(new Dimension(100, 50));
		ContPan.add(Service1Button);
		
		JButton Service2Button = new JButton("ASSIGNMENT");
		Service2Button.setBorder(new LineBorder(Color.BLUE));
		Service2Button.setForeground(Color.BLUE);
		Service2Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Service2Button.setPreferredSize(new Dimension(100, 50));
		ContPan.add(Service2Button);
		
		JButton Service3Button = new JButton("RESPONSE");
		Service3Button.setBorder(new LineBorder(Color.BLUE));
		Service3Button.setForeground(Color.BLUE);
		Service3Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Service3Button.setPreferredSize(new Dimension(100, 50));
		ContPan.add(Service3Button);
		
		JPanel LogOutpan = new JPanel();
		LogOutpan.setBounds(590, 415, 112, 50);
		getContentPane().add(LogOutpan);
		
		JButton LogOut = new JButton("Log Out");
		LogOut.setPreferredSize(new Dimension(75, 35));
		LogOut.setBorder(new LineBorder(Color.BLUE));
		LogOut.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
					dispose();
					try {
						Emp_LogIn el = new Emp_LogIn();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}
		});
		
		LogOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		LogOutpan.add(LogOut);
	}
}
