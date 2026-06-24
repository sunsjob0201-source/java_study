package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {

	private final String JDBC_URL =
			"jdbc:postgresql://localhost:5432/dokotsubu";
	
	private final String DB_USER = "postgres";
	private final String DB_PASS = "psql";
	
	public User findByLogin(
			String name,
			String pass) {
		
		try {
			Class.forName(
					"org.postgresql.Driver");
		
		} catch (ClassNotFoundException e) {
			
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn =
				DriverManager.getConnection(
						JDBC_URL,
						DB_USER,
						DB_PASS)) {
			
			String sql =
			      "SELECT id, name, pass "
				+ "FROM users "
			    + "WHERE name = ? "
				+ "AND pass = ?";
			
			PreparedStatement pStmt =
					conn.prepareStatement(sql);
			
			pStmt.setString(1, name);
			pStmt.setString(2, pass);
			
			ResultSet rs =
					pStmt.executeQuery();
			
			if (rs.next()) {
				
				return new User(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("pass"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return null;
	}
}
