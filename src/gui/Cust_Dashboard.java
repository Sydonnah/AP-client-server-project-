package gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

public class Cust_Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;

	
	public Cust_Dashboard() throws IOException {
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
		
		JLabel instrucLabel = new JLabel("WELCOME " + Cust_LogIn.urname.getText()+ ", "+ "WHAT SERVICE WOULD YOU LIKE TO ACCESS TODAY?");
		instrucLabel.setPreferredSize(new Dimension(600, 24));
		instrucLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		instrucLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		instrucPanel.add(instrucLabel);
		
		JPanel ContPan = new JPanel();
		ContPan.setAlignmentX(Component.RIGHT_ALIGNMENT);
		ContPan.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ContPan.setBounds(75, 180, 540, 215);
		getContentPane().add(ContPan);
		ContPan.setLayout(new GridLayout(2, 2, 10, 10));
		
		JButton Service1Button = new JButton("ENQUIRY");
		Service1Button.setBorder(new LineBorder(Color.BLUE));
		Service1Button.setForeground(Color.BLUE);
		Service1Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Service1Button.setPreferredSize(new Dimension(100, 50));
		Service1Button.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					Enquiry en = new Enquiry();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		ContPan.add(Service1Button);
		
		JButton Service2Button = new JButton("STATUS");
		Service2Button.setBorder(new LineBorder(Color.BLUE));
		Service2Button.setForeground(Color.BLUE);
		Service2Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Service2Button.setPreferredSize(new Dimension(100, 50));
		Service2Button.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					Status stat = new Status();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		ContPan.add(Service2Button);
		
		JButton Service3Button = new JButton("ENQUIRY HISTORY");
		Service3Button.setBorder(new LineBorder(Color.BLUE));
		Service3Button.setForeground(Color.BLUE);
		Service3Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Service3Button.setPreferredSize(new Dimension(100, 50));
		Service3Button.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					Enquiry_History eh = new Enquiry_History();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		ContPan.add(Service3Button);
		
		JButton Service4Button = new JButton("PAYMENT HISTORY");
		Service4Button.setBorder(new LineBorder(Color.BLUE));
		Service4Button.setForeground(Color.BLUE);
		Service4Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Service4Button.setPreferredSize(new Dimension(100, 50));
		Service4Button.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					Payment_History ph = new Payment_History();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		ContPan.add(Service4Button);
		
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
						Cust_LogIn cl = new Cust_LogIn();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}
		});
		
		LogOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		LogOutpan.add(LogOut);
	}
}
