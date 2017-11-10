package Calendar.App;

import java.awt.Color;
import java.awt.Container;
//import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Event extends JFrame{

	private static final long serialVersionUID = 1L;
	JLabel name,ename,date,email;
	JButton delete,send,update,clear;
	JTextField namefield,eventfield,efield,dfield;
	Event() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int x = (d.width / 3);
		int y = (d.height / 5) - this.getHeight();
		setLocation(x, y);
		setTitle("Event Handaler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentpane = getContentPane();
		contentpane.setLayout(new GridBagLayout());
		contentpane.setBackground(new Color(22,96,26));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(2,5,2,10);
		gbc.ipadx = 5;
		gbc.ipady = 5;
		name = new JLabel("Name: ");
		ename = new JLabel("Event Name: ");
		date = new JLabel("Date: ");
		email = new JLabel("Email: ");
		namefield = new JTextField(20);
		eventfield = new JTextField(20);
		dfield = new JTextField(20);
		efield = new JTextField(20);
		delete = new JButton("Delete");
		send = new JButton("Send");
		update = new JButton("Update");
		clear = new JButton("Clear");
		contentpane.add(name,gbc);
		gbc.gridx++;
		contentpane.add(namefield,gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		contentpane.add(ename,gbc);
		gbc.gridx++;
		contentpane.add(eventfield,gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		contentpane.add(date,gbc);
		gbc.gridx++;
		contentpane.add(dfield, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		contentpane.add(email,gbc);
		gbc.gridx++;
		contentpane.add(efield,gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.ipadx = 35;
		gbc.ipady = 5;
		gbc.insets = new Insets(10,5,2,5);
		contentpane.add(delete,gbc);
		gbc.gridx++;
		contentpane.add(send,gbc);
		gbc.gridx++;
		contentpane.add(update,gbc);
		gbc.gridx =1;
		gbc.gridy++;
		contentpane.add(clear,gbc);
//		delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		send.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		update.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pack();
		setSize(510,335);
		setVisible(true);
	}
}
