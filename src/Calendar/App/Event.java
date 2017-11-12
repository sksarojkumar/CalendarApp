package Calendar.App;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Event extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel content, button;
	private JLabel name,ename,date,email,msg;
	private JButton delete,send,update,clear,save;
	private JTextArea msgbox;
	private JScrollPane scroll;
	private JFormattedTextField txtDate;
	private Font font = null;
	JTextField namefield,eventfield,efield;
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
		
		try {
			
			InputStream is = this.getClass().getResourceAsStream("font/Montserrat-Regular.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT,is).deriveFont(Font.PLAIN,(18));
//			mfont = Font.createFont(Font.TRUETYPE_FONT,is).deriveFont(Font.PLAIN,(10));
		
		}
		catch(Exception e)
		{
			System.out.println("font problem: "+e);
		}
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,10,10,10);
		
		content = new JPanel();
		content.setBackground(new Color(22,96,26));
		name = new JLabel("Name: ");
		name.setFont(font);
		name.setForeground(Color.WHITE);
		ename = new JLabel("Event Name: ");
		ename.setFont(font);
		ename.setForeground(Color.WHITE);
		date = new JLabel("Date: ");
		date.setFont(font);
		date.setForeground(Color.WHITE);
		email = new JLabel("Email: ");
		email.setFont(font);
		email.setForeground(Color.WHITE);
		msg = new JLabel("Message: ");
		msg.setFont(font);
		msg.setForeground(Color.WHITE);
		msgbox = new JTextArea(3, 5);
		msgbox.setLineWrap(true);
		msgbox.setWrapStyleWord(true);
		scroll = new JScrollPane(msgbox);
		namefield = new JTextField(15);
		eventfield = new JTextField(15);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		txtDate = new JFormattedTextField(df);
		efield = new JTextField(15);
		
		button = new JPanel();
		button.setBackground(new Color(22,96,26));
		delete = new JButton("Delete");
		send = new JButton("Send");
		save = new JButton("Save");
		update = new JButton("Update");
		clear = new JButton("Clear");
		
		content.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		gbc1.insets = new Insets(8,5,5,15);
		
		content.add(name,gbc1);
		gbc1.gridx++;
		content.add(namefield,gbc1);
		gbc1.gridx = 0;
		gbc1.gridy++;
		content.add(ename,gbc1);
		gbc1.gridx++;
		content.add(eventfield,gbc1);
		gbc1.gridx = 0;
		gbc1.gridy++;
		content.add(date,gbc1);
		gbc1.gridx++;
		gbc1.ipadx = 165;
		content.add(txtDate, gbc1);
		gbc1.ipadx = 0;
		gbc1.gridx = 0;
		gbc1.gridy++;
		content.add(email,gbc1);
		gbc1.gridx++;
		content.add(efield,gbc1);
		gbc1.gridx = 0;
		gbc1.gridy++;
		content.add(msg,gbc1);
		gbc1.ipadx = 120;
		gbc1.ipady = 5;
		gbc1.gridx++;
		content.add(scroll, gbc1);
		button.setLayout(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 3;
		gbc2.gridy = 8;
		gbc2.insets = new Insets(2,5,5,5);
		gbc2.ipadx = 50;
		
		gbc2.ipady = 25;
		button.add(clear,gbc2);
		gbc2.ipady = 0;
		gbc2.gridx++;
		button.add(send,gbc2);
		gbc2.gridx++;
		button.add(save, gbc2);
		gbc2.gridx = 4;
		gbc2.gridy++;
		button.add(delete,gbc2);
		gbc2.gridx++;
		button.add(update,gbc2);
		
		contentpane.add(content, gbc);
		gbc.gridy++;
		contentpane.add(button, gbc);
		delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		send.setCursor(new Cursor(Cursor.HAND_CURSOR));
		update.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		txtDate.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))        
				{
					JOptionPane.showMessageDialog(null, "Please Enter Valid");
					e.consume();
				}
			}
		});
		save.addActionListener(this);
		pack();
//		setSize(510,335);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == save) {
			String named = namefield.getText();
			String eventname = eventfield.getText();
			String txtdate = txtDate.getText();
			String emailid = efield.getText();
			String message = msgbox.getText();
			
			if(named.equals("")) {
				name.requestFocus();
				JOptionPane.showMessageDialog(null,"The Name field is Empty");
			}
			else if(eventname.equals("")) {
				ename.requestFocus();
				JOptionPane.showMessageDialog(null,"The Event Name field is Empty");
			}
			else if(txtdate.equals("")) {
				txtDate.requestFocus();
				JOptionPane.showMessageDialog(null,"The Date field is Empty");
			}
			else if(emailid.equals("")) {
				email.requestFocus();
				JOptionPane.showMessageDialog(null,"The email field is Empty");
			}
			else if(message.equals("")) {
				msg.requestFocus();
				JOptionPane.showMessageDialog(null,"The Message fiels is Empty");
			}
			else {
				SaveDatabase sd = new SaveDatabase();
				sd.savedata(named,eventname,txtdate,emailid,message);
			}
		}
	}
}
