package Calendar.App;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.InputStream;

import javax.swing.*;

public class MainGui extends JFrame{

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
		Base mainbase = new Base();
		contentpane.add(mainbase);
		pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainGui();
	}
}

class Base extends JPanel{
	Base(){
		setBackground(Color.GREEN);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(2,2,2,2);
		Head mainhead = new Head();
		WeekDay  wd = new WeekDay();
		DayDate dd = new DayDate();
		add(mainhead,gbc);
		gbc.gridy++;
		add(wd,gbc);
		gbc.gridy++;
		add(dd,gbc);
		
	}
	
}

class Head extends JPanel{
	private JButton alarm;
	private JComboBox<String> box1;
	private JComboBox<Integer> box2;
	String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "November", "December"};
	Integer[] years = {1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021};
	Head(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,2,10,15);
		gbc.ipadx = 50;
		alarm = new JButton("Alarm");
		box1 = new JComboBox(month);
		box2 = new JComboBox(years);
		add(alarm,gbc);
		gbc.gridx++;
		add(box1,gbc);
		gbc.gridx++;
		add(box2,gbc);
		setBackground(Color.GREEN);
	}
}

class WeekDay extends JPanel{
	private JLabel su,mo,tu,we,th,fr,sa;
	Font font = null;
	WeekDay(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5,10,5,10);
		gbc.ipadx = 10;
		
		try {
			
			InputStream is = this.getClass().getResourceAsStream("font/Montserrat-Regular.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT,is).deriveFont(Font.PLAIN,(18));
		
		}
		catch(Exception e)
		{
			System.out.println("font problem: "+e);
		}
		
		su = new JLabel("SUN");
		su.setFont(font);
		mo = new JLabel("MON");
		mo.setFont(font);
		tu = new JLabel("TUE");
		tu.setFont(font);
		we = new JLabel("WED");
		we.setFont(font);
		th = new JLabel("THU");
		th.setFont(font);
		fr = new JLabel("FRI");
		fr.setFont(font);
		sa = new JLabel("SAT");
		sa.setFont(font);
		
		add(su,gbc);
		gbc.gridx++;
		add(mo,gbc);
		gbc.gridx++;
		add(tu,gbc);
		gbc.gridx++;
		add(we,gbc);
		gbc.gridx++;
		add(th,gbc);
		gbc.gridx++;
		add(fr,gbc);
		gbc.gridx++;
		add(sa,gbc);
		setBackground(Color.GREEN);
	}
}

class DayDate extends JPanel{
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30,l31,l32,l33,l34,l35;
	Font font = null;
	DayDate(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(3,18,18,18);
		gbc.ipadx = 10;
		
		
		try {
			InputStream is = this.getClass().getResourceAsStream("font/Montserrat-Regular.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT,is).deriveFont(Font.PLAIN,(20));
		
		}
		catch(Exception e)
		{
			System.out.println("font problem: "+e);
		}
		
		l1 = new JLabel("1");
		l1.setFont(font);
		l2 = new JLabel("2");
		l2.setFont(font);
		l3 = new JLabel("3");
		l3.setFont(font);
		l4 = new JLabel("4");
		l4.setFont(font);
		l5 = new JLabel("5");
		l5.setFont(font);
		l6 = new JLabel("6");
		l6.setFont(font);
		l7 = new JLabel("7");
		l7.setFont(font);
		l8 = new JLabel("8");
		l8.setFont(font);
		l9 = new JLabel("9");
		l9.setFont(font);
		l10 = new JLabel("10");
		l10.setFont(font);
		l11 = new JLabel("11");
		l11.setFont(font);
		l12 = new JLabel("12");
		l12.setFont(font);
		l13 = new JLabel("13");
		l13.setFont(font);
		l14 = new JLabel("14");
		l14.setFont(font);
		l15 = new JLabel("15");
		l15.setFont(font);
		l16 = new JLabel("16");
		l16.setFont(font);
		l17 = new JLabel("17");
		l17.setFont(font);
		l18 = new JLabel("18");
		l18.setFont(font);
		l19 = new JLabel("19");
		l19.setFont(font);
		l20 = new JLabel("20");
		l20.setFont(font);
		l21 = new JLabel("21");
		l21.setFont(font);
		l22 = new JLabel("22");
		l22.setFont(font);
		l23 = new JLabel("23");
		l23.setFont(font);
		l24 = new JLabel("24");
		l24.setFont(font);
		l25 = new JLabel("25");
		l25.setFont(font);
		l26 = new JLabel("26");
		l26.setFont(font);
		l27 = new JLabel("27");
		l27.setFont(font);
		l28 = new JLabel("28");
		l28.setFont(font);
		l29 = new JLabel("29");
		l29.setFont(font);
		l30 = new JLabel("30");
		l30.setFont(font);
		l31 = new JLabel("31");
		l31.setFont(font);
		l32 = new JLabel("32");
		l32.setFont(font);
		l33 = new JLabel("33");
		l33.setFont(font);
		l34 = new JLabel("34");
		l34.setFont(font);
		l35 = new JLabel("35");
		l35.setFont(font);
		
		add(l1,gbc);
		gbc.gridx++;
		add(l2,gbc);
		gbc.gridx++;
		add(l3,gbc);
		gbc.gridx++;
		add(l4,gbc);
		gbc.gridx++;
		add(l5,gbc);
		gbc.gridx++;
		add(l6,gbc);
		gbc.gridx++;
		add(l7,gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		add(l8,gbc);
		gbc.gridx++;
		add(l9,gbc);
		gbc.gridx++;
		add(l10,gbc);
		gbc.gridx++;
		add(l11,gbc);
		gbc.gridx++;
		add(l12,gbc);
		gbc.gridx++;
		add(l13,gbc);
		gbc.gridx++;
		add(l14,gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		add(l15,gbc);
		gbc.gridx++;
		add(l16,gbc);
		gbc.gridx++;
		add(l17,gbc);
		gbc.gridx++;
		add(l18,gbc);
		gbc.gridx++;
		add(l19,gbc);
		gbc.gridx++;
		add(l20,gbc);
		gbc.gridx++;
		add(l21,gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		add(l22,gbc);
		gbc.gridx++;
		add(l23,gbc);
		gbc.gridx++;
		add(l24,gbc);
		gbc.gridx++;
		add(l25,gbc);
		gbc.gridx++;
		add(l26,gbc);
		gbc.gridx++;
		add(l27,gbc);
		gbc.gridx++;
		add(l28,gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		add(l29,gbc);
		gbc.gridx++;
		add(l30,gbc);
		gbc.gridx++;
		add(l31,gbc);
		gbc.gridx++;
		add(l32,gbc);
		gbc.gridx++;
		add(l33,gbc);
		gbc.gridx++;
		add(l34,gbc);
		gbc.gridx++;
		add(l35,gbc);
		setBackground(Color.GREEN);
	}
}

