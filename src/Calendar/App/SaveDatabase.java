package Calendar.App;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SaveDatabase {
	
	void savedata(String name, String ename, String txtdate, String email, String msg) {
		try {
			Database db = new Database();
			PreparedStatement st = db.conn.prepareStatement("insert into EVENTLIST values(?,?,?,?,?)");
			st.setString(1, name);
			st.setString(2, ename);
			st.setString(3, txtdate);
			st.setString(4, email);
			st.setString(5, msg);
			st.executeUpdate();
			st.close();
			db.conn.close();
//			while(rs.next()) {
//				if(name.equals(rs.getString(1)) && txtdate.equals(rs.getString(3))) {
//					
//				}
//			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
