package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databse.DbConnection;

public class LoginDAO {
	
	public static boolean login(String email, String pass) throws SQLException {
		
		boolean validUser = false;
		String query = "select * from users where email = ? and password = ?";
		
		try(Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query);){
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				validUser = true;
			}
		}catch (Exception e) {
            e.printStackTrace();
        }
		return validUser;
	}

}
