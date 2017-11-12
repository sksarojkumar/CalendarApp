package Calendar.App;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.InputStream;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.Border;

public class MainGui extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private MainGui(){
		//this.setSize(510,335);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int x = (d.width / 3);
		int y = (d.height / 5) - this.getHeight();
		this.setLocation(x, y);
		this.setTitle("CALENDAR");
		//this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentpane = getContentPane();
		contentpane.setLayout(new BorderLayout());
		Base mainbase = new Base(this);
		contentpane.add(mainbase);
		pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainGui();
	}
}

class Base extends JPanel implements ActionListener, ItemListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel Head,weekday;
	private JLabel su,mo,tu,we,th,fr,sa;
	private JButton alarm;
	private JComboBox<String> box1;
	private JComboBox<Integer> box2;
	int pdate = 1,fdate,date;
	private Font font = null;
	private JFrame mjjf;
	private JLabel[] labels;
	String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September","October","November", "December"};
	Integer[] years = {1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021};
	int[] monthend = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	Base(JFrame mainjf){
		mjjf = mainjf;
		//head
		//setBackground(Color.GREEN);
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int monthc = now.get(Calendar.MONTH)+1;
		date = now.get(Calendar.DATE);
		int code = CalendarCalculation(year, monthc);
		if(checkLeapYear(year)) {
			monthend[2] = 29;
		}
		else {
			monthend[2] = 28;
		}
	
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,10,10,15);
		
		Head = new JPanel();
		Head.setBackground(new Color(22,96,26));
		alarm = new JButton("Add Event");
		alarm.setBorderPainted(false);
		alarm.setOpaque(false);
		box1 = new JComboBox<String>(month);
		box1.setSelectedIndex(monthc-1);
		box2 = new JComboBox<Integer>(years);
		box2.setSelectedIndex(year-1990);
		//weekday
		try {
			
			InputStream is = this.getClass().getResourceAsStream("font/Montserrat-Regular.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT,is).deriveFont(Font.PLAIN,(18));
		
		}
		catch(Exception e)
		{
			System.out.println("font problem: "+e);
		}
		
		weekday = new JPanel();
		weekday.setBackground(new Color(22,96,26));
		su = new JLabel("SUN", SwingConstants.CENTER);
		su.setFont(font);
		su.setForeground(Color.WHITE);
		mo = new JLabel("MON", SwingConstants.CENTER);
		mo.setFont(font);
		mo.setForeground(Color.WHITE);
		tu = new JLabel("TUE", SwingConstants.CENTER);
		tu.setFont(font);
		tu.setForeground(Color.WHITE);
		we = new JLabel("WED", SwingConstants.CENTER);
		we.setFont(font);
		we.setForeground(Color.WHITE);
		th = new JLabel("THU", SwingConstants.CENTER);
		th.setFont(font);
		th.setForeground(Color.WHITE);
		fr = new JLabel("FRI", SwingConstants.CENTER);
		fr.setFont(font);
		fr.setForeground(Color.WHITE);
		sa = new JLabel("SAT", SwingConstants.CENTER);
		sa.setFont(font);
		sa.setForeground(Color.WHITE);
			
		
		//head
		Head.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx = 1;
		gbc1.gridy = 0;
		gbc1.insets = new Insets(10,2,10,15);
		gbc1.ipadx = 50;
		Head.add(alarm,gbc1);
		gbc1.gridx++;
		Head.add(box1,gbc1);
		gbc1.gridx++;
		Head.add(box2,gbc1);
		
		//week
		weekday.setLayout(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		gbc2.insets = new Insets(5,5,5,5);
		gbc2.ipadx = 15;
		weekday.add(su,gbc2);
		gbc2.gridx++;
		weekday.add(mo,gbc2);
		gbc2.gridx++;
		weekday.add(tu,gbc2);
		gbc2.gridx++;
		weekday.add(we,gbc2);
		gbc2.gridx++;
		weekday.add(th,gbc2);
		gbc2.gridx++;
		weekday.add(fr,gbc2);
		gbc2.gridx++;
		weekday.add(sa,gbc2);
		
		//day
		gbc2.gridx = 0;
		gbc2.gridy++;
		
		// add label to panel
		showLabel(monthc, code);
		
		add(Head,gbc);
		gbc.gridy++;
		add(weekday,gbc);
		setBackground(new Color(22,96,26));
		alarm.setCursor(new Cursor(Cursor.HAND_CURSOR));
		alarm.addActionListener(this);
		box1.addItemListener(this);
		box2.addItemListener(this);
	}
	
	
	private int CalendarCalculation(int year, int month) {
		int[] monthcode = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
		
		int y2 = year%100;
		int c1 = y2/4;
		int c2 = (year >= 2000)? 6 : 0;
		int daycode = (1 + y2 + c1 + c2 + monthcode[month-1])%7;
		return daycode;
	}
	
	private boolean checkLeapYear(int year) {
		
		  if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
			  return true;
		  return false;
	}
	
	private JLabel[] creator(int monthc, int code) {
		
		labels = new JLabel[42];
		if(monthc == 1)
			fdate = monthend[12] - (code-1);
		else
			fdate = monthend[monthc-1] - (code-1);
		
		for(int i = 0; i < code; i++) {
			String str = Integer.toString(fdate);
			labels[i] = new JLabel(str, SwingConstants.CENTER);
			labels[i].setFont(font);
			labels[i].setEnabled(false);
			fdate++;
		}
		
		for(int j = code; j <= monthend[monthc]+code; j++) {
			String str = Integer.toString(pdate);
			labels[j] = new JLabel(str, SwingConstants.CENTER);
			labels[j].setFont(font);
			labels[j].setForeground(Color.WHITE);
			if(j == date+code-1) {
				Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
				labels[j].setBorder(border);
			}
			pdate++;
		}
		pdate = 1;
		for(int j = monthend[monthc]+code; j < 42; j++) {
			String str = Integer.toString(pdate);
			labels[j] = new JLabel(str, SwingConstants.CENTER);
			labels[j].setFont(font);
			labels[j].setEnabled(false);
			pdate++;
		}
		
		return labels;
	}
	
	private void showLabel(int monthc, int code) {
		labels = creator(monthc, code);
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 2;
		gbc2.insets = new Insets(5,5,5,5);
		gbc2.ipadx = 15;
		
		for(int k = 0; k < labels.length; k++) {
			weekday.add(labels[k], gbc2);
			if((k+1)%7 == 0) {
				gbc2.gridx = 0;
				gbc2.gridy++;
			}
			else
				gbc2.gridx++;
		}
	}
	
	private void showChange(int monthc, int code) {
		if(monthc == 1)
			fdate = monthend[12] - (code-1);
		else
			fdate = monthend[monthc-1] - (code-1);
		
		for(int i = 0; i < code; i++) {
			String str = Integer.toString(fdate);
			labels[i].setText(str);
			labels[i].setFont(font);
			labels[i].setEnabled(false);
			fdate++;
		}
	
		pdate = 1;
		for(int j = code; j <= monthend[monthc]+code; j++) {
			String str = Integer.toString(pdate);
			labels[j].setText(str);
			labels[j].setFont(font);
			labels[j].setForeground(Color.WHITE);
			if(labels[j].isVisible()) {
				labels[j].setEnabled(true);
			}
			pdate++;
		}
		pdate = 1;
		for(int j = monthend[monthc]+code; j < 42; j++) {
			String str = Integer.toString(pdate);
			labels[j].setText(str);
			labels[j].setFont(font);
			labels[j].setEnabled(false);
			pdate++;
		}
	}
	
	//Action event
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==alarm) {
				try {
					new Event();
					mjjf.dispose();
				}
				catch(Exception e) {}
			}
		}
		
//	 	Item Listener for month and year

		public void itemStateChanged(ItemEvent ie) {
			int monthi = box1.getSelectedIndex();
			int yeari = box2.getSelectedIndex();
			int code = CalendarCalculation(yeari+1990, monthi+1);
			showChange(monthi+1, code);
		}
		
}


