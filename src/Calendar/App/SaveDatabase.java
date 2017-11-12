package Calendar.App;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SaveDatabase {
	
	void savedata(String name, String ename, String txtdate, String email, String msg) {
		PreparedStatement st = null;
		Database db;
		try {
			db = new Database();
			
			st = db.conn.prepareStatement("select NAME, EVENTDATE from EVENTLIST");

			int flag = 0;
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				if(name.equals(rs.getString(1)) && txtdate.equals(rs.getString(2))) {
					JOptionPane.showMessageDialog(null,"The Data already exits");
					flag = 1;
//					st.close();
				}
			}
			if(flag == 0) {
				st = db.conn.prepareStatement("insert into EVENTLIST values(?,?,?,?,?)");
				st.setString(1, name);
				st.setString(2, ename);
				st.setString(3, txtdate);
				st.setString(4, email);
				st.setString(5, msg);
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Succesfully Saved!");
			}
			st.close();
			db.conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
