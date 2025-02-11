package databse;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	static String url = "jdbc:postgresql://localhost:5432/JDBCdb";
    static String user = "postgres";
    static String password = "root";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
