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
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;

public class Enquiry_History extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable Enq_his_table;
	
	public Enquiry_History() throws IOException{
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
		
		JPanel headPanel = new JPanel();
		headPanel.setPreferredSize(new Dimension(10, 50));
		headPanel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		headPanel.setBounds(10, 100, 680, 25);
		getContentPane().add(headPanel);
		
		JLabel headLabel = new JLabel("WELCOME " + Cust_LogIn.Username+ ", "+ "HERE IS YOUR ENQUIRY HISTORY?: ");
		headLabel.setPreferredSize(new Dimension(600, 24));
		headLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		headLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		headPanel.add(headLabel);
		
		JPanel GBpanel = new JPanel();
		GBpanel.setBounds(20, 420, 105, 40);
		getContentPane().add(GBpanel);
		
		JButton BackButton = new JButton("Go Back");
		BackButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					Cust_Dashboard cd = new Cust_Dashboard();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		BackButton.setBorder(new LineBorder(Color.BLUE));
		BackButton.setPreferredSize(new Dimension(75, 30));
		BackButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GBpanel.add(BackButton);
		
		JScrollPane EnqscrollPane = new JScrollPane();
		EnqscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		EnqscrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		EnqscrollPane.setBounds(20, 160, 675, 250);
		getContentPane().add(EnqscrollPane);
		
		String column[] = {"Enquiry ID", "Complaint", "Date of Submission"};
		String data[][] = {{"212","internet","yesterday"},
				};
	
		Enq_his_table = new JTable(data,column) {
			private static final long serialVersionUID = 1L;
			public boolean editCellAt(int row, int column , java.util.EventObject e) {
				return false;
			}
		};
		
		Enq_his_table.setPreferredSize(new Dimension(20, 220));
		EnqscrollPane.setViewportView(Enq_his_table);
		
		JPanel instrucpanel = new JPanel();
		instrucpanel.setBounds(10, 130, 680, 25);
		getContentPane().add(instrucpanel);
		
		JLabel instrucLabel = new JLabel("Select an ID to view the description.");
		instrucLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		instrucLabel.setPreferredSize(new Dimension(600, 24));
		instrucpanel.add(instrucLabel);
		
		JPanel Viewpanel = new JPanel();
		Viewpanel.setBounds(580, 420, 105, 40);
		getContentPane().add(Viewpanel);
		
		JButton ViewButton = new JButton("View");
		ViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//search database for description matching id
			}
		});
		ViewButton.setAlignmentX(0.5f);
		ViewButton.setBorder(new LineBorder(Color.BLUE));
		ViewButton.setPreferredSize(new Dimension(75, 30));
		ViewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Viewpanel.add(ViewButton);
	}
}
