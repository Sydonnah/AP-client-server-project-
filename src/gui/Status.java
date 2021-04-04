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

import domain.Customer_Account;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Status extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField acctextField;
	private JTextField acc_statTextField;
	private JTextField acc_owetextField;
	private JTextField pay_duetextField;
	private JTextField InvoicetextField;
	private Customer_Account ca;

	public Status() throws IOException {
		ca = new Customer_Account();
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
		
		JLabel instrucLabel = new JLabel("WELCOME " + Cust_LogIn.urname.getText()+ ", "+ "HERE IS YOUR CURRENT ACCOUNT STATUS: ");
		instrucLabel.setPreferredSize(new Dimension(600, 24));
		instrucLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		instrucLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		instrucPanel.add(instrucLabel);
		
		JPanel GBpanel = new JPanel();
		GBpanel.setBounds(20, 405, 105, 40);
		getContentPane().add(GBpanel);
		
		JButton GoBackButton = new JButton("Go Back");
		GoBackButton.addActionListener(new ActionListener() {
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
		GoBackButton.setBorder(new LineBorder(Color.BLUE));
		GoBackButton.setPreferredSize(new Dimension(75, 30));
		GoBackButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GBpanel.add(GoBackButton);
		
		JPanel conpanel = new JPanel();
		conpanel.setBounds(20, 136, 689, 259);
		getContentPane().add(conpanel);
		conpanel.setLayout(null);
		
		JLabel accLabel = new JLabel("Account ID:");
		accLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		accLabel.setBounds(10, 20, 80, 25);
		conpanel.add(accLabel);
		
		JLabel pay_dueLabel = new JLabel("Payment Due Date:");
		pay_dueLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pay_dueLabel.setBounds(10, 215, 110, 25);
		conpanel.add(pay_dueLabel);
		
		JLabel am_oweLabel = new JLabel("Amount Owed:");
		am_oweLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		am_oweLabel.setBounds(10, 146, 100, 25);
		conpanel.add(am_oweLabel);
		
		JLabel acc_statLabel = new JLabel("Account Status:");
		acc_statLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		acc_statLabel.setBounds(10, 76, 90, 25);
		conpanel.add(acc_statLabel);
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ms_cablevision", "root","");
			if(con == null) {
				System.out.println("Can not connect to the database");
			}else {
				String read = "SELECT Acc_num FROM customerinformation WHERE Username = '" +Cust_LogIn.urname.getText()+"'" ;
				PreparedStatement pstmt = con.prepareStatement(read);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
				ca.setAcc_num(rs.getInt(1));
				}
				
				String get = "SELECT Invoice_ID,Account_Stat,Amount_Owe,Due_Date FROM account_status WHERE Acc_num = '" +ca.getAcc_num()+ "'";
				PreparedStatement pstmt1 = con.prepareStatement(get);
				ResultSet rs1 = pstmt1.executeQuery();
				while(rs1.next()){	
					ca.setInvoice(rs1.getInt(1));
					ca.setAcc_stat(rs1.getString(2));
					ca.setAm_owe(rs1.getString(3));
					ca.setD_day(rs1.getString(4));		
			}
		}
		}catch(SQLException sql) {
			sql.printStackTrace();
		}
		
		acctextField = new JTextField();
		acctextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		acctextField.setEditable(false);
		acctextField.setBounds(120, 21, 248, 25);
		acctextField.setText(Integer.toString(ca.getAcc_num()));
		conpanel.add(acctextField);
	
		
		acc_statTextField = new JTextField();
		acc_statTextField.setEditable(false);
		acc_statTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		acc_statTextField.setBounds(120, 78, 248, 25);
		acc_statTextField.setText(ca.getAcc_stat());
		conpanel.add(acc_statTextField);
		
		acc_owetextField = new JTextField();
		acc_owetextField.setEditable(false);
		acc_owetextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		acc_owetextField.setBounds(120, 147, 248, 25);
		acc_owetextField.setText(ca.getAm_owe());
		conpanel.add(acc_owetextField);
		
		pay_duetextField = new JTextField();
		pay_duetextField.setEditable(false);
		pay_duetextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pay_duetextField.setBounds(120, 217, 248, 25);
		pay_duetextField.setText(ca.getD_day());
		conpanel.add(pay_duetextField);
		
		JLabel InvoiceLabel = new JLabel("Invoice # :");
		InvoiceLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		InvoiceLabel.setBounds(410, 20, 70, 25);
		conpanel.add(InvoiceLabel);
		
		InvoicetextField = new JTextField();
		InvoicetextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		InvoicetextField.setEditable(false);
		InvoicetextField.setBounds(490, 18, 170, 25);
		InvoicetextField.setText(Integer.toString(ca.getInvoice()));
		conpanel.add(InvoicetextField);
	
	}

}
