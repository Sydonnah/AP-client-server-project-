package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomePage extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel custpan;
	private JPanel emppan;
	private JButton custbutton;
	private JButton empbutton;

	
	
	
	public HomePage(){
		custpan = new JPanel();
		emppan = new JPanel();
		custbutton = new JButton("I AM A CUSTOMER");
		empbutton = new JButton("I AM AN EMPLOYEE");
		
		
		custpan.setSize(200,600);
		custbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			});
		custpan.add(custbutton);
		
		emppan.setSize(600,200);
		empbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		emppan.add(empbutton);
		
		add(custpan, BorderLayout.CENTER);
		add(emppan, BorderLayout.WEST);
		setLayout(new BorderLayout());
		setTitle("");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setSize(new Dimension(500,500));
		
		
		//add(BorderLayout.NORTH,image);
//		add(,BorderLayout.South);
		
		
	}
	public static void main (String [] args) {
		new HomePage();
	}


}
