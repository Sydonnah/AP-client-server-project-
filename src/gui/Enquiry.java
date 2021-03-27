package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Enquiry extends JFrame {

	private static final long serialVersionUID = 1L;
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Enquiry() {
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
		instrucPanel.setBounds(10, 100, 680, 25);
		instrucPanel.setPreferredSize(new Dimension(10, 50));
		instrucPanel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		getContentPane().add(instrucPanel);
		
		JLabel instrucLabel = new JLabel("WELCOME "+ Cust_LogIn.Username+ ", "+ "PLEASE LODGE YOUR COMPLAINTS HERE");
		instrucLabel.setPreferredSize(new Dimension(600, 24));
		instrucLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		instrucLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		instrucPanel.add(instrucLabel);
		
		JLabel CompLabel = new JLabel("Complaint Type :");
		CompLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		CompLabel.setBounds(40, 151, 100, 30);
		getContentPane().add(CompLabel);
		
		JComboBox CompcomboBox = new JComboBox();
		CompcomboBox.setBorder(new LineBorder(Color.BLUE));
		CompcomboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		CompcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Internet Issues ", "Connectivity Issues ", "Payment Issues "}));
		CompcomboBox.setBackground(Color.WHITE);
		CompcomboBox.setBounds(150, 151, 165, 30);
		getContentPane().add(CompcomboBox);
		
		JLabel DesLabel = new JLabel("Description :");
		DesLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		DesLabel.setBounds(40, 225, 100, 20);
		getContentPane().add(DesLabel);
		
		JTextArea DestextArea = new JTextArea();
		DestextArea.setBorder(new LineBorder(Color.BLUE));
		DestextArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DestextArea.setBounds(150, 223, 366, 153);
		getContentPane().add(DestextArea);
		
		JPanel backpanel = new JPanel();
		backpanel.setBounds(40, 414, 100, 46);
		getContentPane().add(backpanel);
		
		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				dispose();
				Cust_Dashboard cd = new Cust_Dashboard();
			}
		});
		backButton.setPreferredSize(new Dimension(80, 30));
		backButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		backButton.setBorder(new LineBorder(Color.BLUE));
		backpanel.add(backButton);
		
		JPanel Submitpanel = new JPanel();
		Submitpanel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Submitpanel.setBounds(559, 414, 100, 46);
		getContentPane().add(Submitpanel);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//send inform to database
			}
		});
		SubmitButton.setBorder(new LineBorder(Color.BLUE));
		SubmitButton.setPreferredSize(new Dimension(80, 30));
		SubmitButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Submitpanel.add(SubmitButton);
	}
}
