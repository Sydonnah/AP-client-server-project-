package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Payment_History extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	public Payment_History() throws IOException{
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
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
		
		JLabel headLabel = new JLabel("WELCOME " + Cust_LogIn.Username+ ", "+ "HERE IS YOUR PAYMENT HISTORY");
		headLabel.setPreferredSize(new Dimension(600, 24));
		headLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		headLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		headPanel.add(headLabel);
		
		JPanel Backpanel = new JPanel();
		Backpanel.setBounds(20, 415, 105, 40);
		getContentPane().add(Backpanel);
		
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
		Backpanel.add(BackButton);
		
		JScrollPane PayscrollPane = new JScrollPane();
		PayscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		PayscrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		PayscrollPane.setBounds(20, 160, 675, 250);
		getContentPane().add(PayscrollPane);
		
		String column[] = {"Account ID", "Amount Paid", "Payment Date"};
		String data[][] = {{"212","$400","yesterday"},
				};
	
		 JTable Pay_his_table = new JTable(data,column) {
			private static final long serialVersionUID = 1L;
			public boolean editCellAt(int row, int column , java.util.EventObject e) {
				return false;
			}
		};
		
		Pay_his_table.setPreferredSize(new Dimension(20, 220));
		PayscrollPane.setViewportView(Pay_his_table);
		
	}

}
