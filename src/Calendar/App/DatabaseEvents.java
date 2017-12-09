package Calendar.App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DatabaseEvents {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@SAROJ:1521:XE","system","manager");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static int save(EventList e) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into EVENTLIST(EVENTID, NAME, EVENTNAME, EVENTDATE, EMAIL, MSG) values(seq.nextval,?,?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEventName());
			ps.setString(3, e.getEventDate());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getMessage());
			
			status = ps.executeUpdate();
			ps.close();
			con.close();
			System.out.println("date format:"+e.getEventDate());
		}
		catch(Exception ex) {ex.printStackTrace();}
		return status;
	}
	
//	public static int update(EventList e) {
//		int status = 0;
//		try {
//			Connection con = getConnection();
//			PreparedStatement ps = con.prepareStatement("update EVENTLIST set NAME=?,EVENTNAME=?,EVENTDATE=?,EMAIL=?,MSG=? where EVENTID=?");
//			ps.setString(1, e.getName());
//			ps.setString(2, e.getEventName());
//			ps.setString(3, e.getEventDate());
//			ps.setString(4, e.getEmail());
//			ps.setString(5, e.getMessage());
//			ps.setInt(6, e.getId());
//			
//			status = ps.executeUpdate();
//			ps.close();
//			con.close();
//			
//			JOptionPane.showMessageDialog(null, "Database Updated");
//		}
//		catch(Exception ex) {ex.printStackTrace();}
//		return status;
//	}
	
//	public static int delete(int id) {
//		int status = 0;
//		try {
//			Connection con = getConnection();
//			PreparedStatement ps = con.prepareStatement("delete from EVENTLIST where EVENTID=?");
//			ps.setInt(1, id);
//			
//			status = ps.executeUpdate();
//			ps.close();
//			con.close();
//			
//			JOptionPane.showMessageDialog(null, "Data Deleted");
//		}
//		catch(Exception ex) {ex.printStackTrace();}
//		return status;
//	}
	
	public static Object[][] getAllEventList() {
		Object[][] dat=null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from EVENTLIST");
			ResultSet rs = ps.executeQuery();
			int count =0;
			while(rs.next()) {
				count++;
			}
			rs = ps.executeQuery();
			dat=new Object[count][6];
			int i=0;
			while(rs.next()) {
 
				 dat[i][0]=rs.getInt(1); 
	             dat[i][1]=rs.getString(2);
	             dat[i][2]=rs.getString(3);
	             dat[i][3]=rs.getDate(4); 
	             dat[i][4]=rs.getString(5);
	             dat[i][5]=rs.getString(6);
	             i++;
			}
			con.close();
		}
		catch(Exception ex) {ex.printStackTrace();}
		return dat;
	}
}
