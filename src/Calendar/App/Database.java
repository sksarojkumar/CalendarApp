package Calendar.App;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	Connection conn = null;
	
	Database(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@SAROJ:1521:XE","system","manager");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
