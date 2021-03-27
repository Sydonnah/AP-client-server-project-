package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	

	public Home(){
		setVisible(true);
		setSize(new Dimension(725, 500));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Carlisha Nicholson\\Documents\\GitHub\\AP-client-server-project-\\cable.jpg"));
		setTitle("MICRO-STAR CABLE VISION");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				String button[] = {"Yes","No"};
				int Prompt = JOptionPane.showOptionDialog(null, "Are you sure you want to Exit?", "Micro-Star CableVision", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,button,button[1]);
				if(Prompt == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		getContentPane().setLayout(null);
		
		JPanel Cpanel = new JPanel();
		Cpanel.setBounds(150, 150, 350, 190);
		getContentPane().add(Cpanel);
		
		JButton custButton = new JButton("I AM A CUSTOMER");
		custButton.setForeground(Color.BLUE);
		custButton.setPreferredSize(new Dimension(150, 100));
		custButton.setHorizontalTextPosition(SwingConstants.LEADING);
		custButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		custButton.setBounds(new Rectangle(50, 0, 0, 300));
		custButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Cust_LogIn();		
			}
			
		});
		Cpanel.add(custButton);
		
		JButton empbutton = new JButton("I AM AN EMPLOYEE");
		empbutton.setForeground(Color.BLUE);
		empbutton.setPreferredSize(new Dimension(170, 100));
		empbutton.setHorizontalTextPosition(SwingConstants.RIGHT);
		empbutton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		empbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Emp_LogIn();
			}
			
		});
		Cpanel.add(empbutton);
		
		JPanel imgpane = new JPanel();
		imgpane.setBounds(10, 10, 680, 85);
		getContentPane().add(imgpane);
		
		JLabel img = new JLabel("");
		img.setPreferredSize(new Dimension(680, 85));
		img.setIcon(new ImageIcon("C:\\Users\\Carlisha Nicholson\\Documents\\GitHub\\AP-client-server-project-\\cable.jpg"));
		imgpane.add(img);
		
		JPanel instrucPanel = new JPanel();
		instrucPanel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		instrucPanel.setPreferredSize(new Dimension(10, 50));
		instrucPanel.setBounds(10, 100, 680, 25);
		getContentPane().add(instrucPanel);
		
		JLabel instrucLabel = new JLabel("WELCOME TO MICRO-STAR CABLE VISION, PLEASE SELECT A CATEGORY TO SIGN IN");
		instrucLabel.setPreferredSize(new Dimension(600, 24));
		instrucLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		instrucLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		instrucLabel.setHorizontalAlignment(SwingConstants.LEFT);
		instrucPanel.add(instrucLabel);
	}
}
