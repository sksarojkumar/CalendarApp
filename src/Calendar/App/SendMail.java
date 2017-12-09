package Calendar.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class SendMail {	
	
	 final String senderEmailID = "abc@abc.com";
	 final String senderPassword = "password";
	 final String emailSMTPserver = "smtpservername";
	 final String emailServerPort = "465";
	 String receiverEmailID = null;	
	 String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep","Oct","Nov", "Dec"};
	void sendMail() {
		PreparedStatement ps = null;
		try {
			
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			int monthd = now.get(Calendar.MONTH)+1;
			int date = now.get(Calendar.DATE);
			String today = date+"-"+month[monthd-1]+"-"+year;
			
			Connection conn = DatabaseEvents.getConnection();
			ps = conn.prepareStatement("select EVENTNAME, EMAIL, MSG from EVENTLIST where EVENTDATE=?");
			ps.setString(1,today);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String sub = rs.getString(1);
				String to = rs.getString(2);
				String msg = rs.getString(3);
				ps.close();
				rs.close();
				conn.close();

				SendEmail(to,"Wish box", msg,sub);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	 public void SendEmail(String receiverEmailID,String Subject, String Body,String subject){
		   
		  // Receiver Email Address
		  this.receiverEmailID=receiverEmailID; 
		  
		  Properties props = new Properties();
		  props.put("mail.smtp.user",senderEmailID);
		  props.put("mail.smtp.host", emailSMTPserver);
		  props.put("mail.smtp.port", emailServerPort);
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.socketFactory.port", emailServerPort);
		  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.socketFactory.fallback", "false");
//		  SecurityManager security = System.getSecurityManager();
		  try{  
			  Authenticator auth = new SMTPAuthenticator();
			  Session session = Session.getInstance(props, auth);
			  MimeMessage msg = new MimeMessage(session);
			  msg.setText(Body);
			  msg.setSubject(subject);
			  msg.setFrom(new InternetAddress(senderEmailID));
			  msg.addRecipient(Message.RecipientType.TO,
			  new InternetAddress(receiverEmailID));
			  Transport.send(msg);
			  JOptionPane.showMessageDialog(null, "Msg sent Successfully.");
		  } 
		  catch (Exception mex){
			  mex.printStackTrace();
		  }
	 }
	 public class SMTPAuthenticator extends javax.mail.Authenticator
	 {
		public PasswordAuthentication getPasswordAuthentication()
		{
			return new PasswordAuthentication(senderEmailID, senderPassword);
		}
	}
}
