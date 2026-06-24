package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MuttersDao {

    private final String JDBC_URL =
            "jdbc:postgresql://localhost:5432/dokotsubu";

    private final String DB_USER = "postgres";
    private final String DB_PASS = "psql";

    public List<Mutter> findAll() {

        List<Mutter> mutterList = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
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
                "SELECT id, user_id, user_name, text, post_time "
              + "FROM mutter "
              + "ORDER BY post_time DESC";

            PreparedStatement pStmt =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    pStmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                
                int userId = rs.getInt("user_id");

                String userName =
                        rs.getString("user_name");

                String text =
                        rs.getString("text");

                LocalDateTime postTime =
                        rs.getTimestamp("post_time").toLocalDateTime();

                Mutter mutter =
                        new Mutter(
                                id,
                                userId,
                                userName,
                                text,
                                postTime);

                mutterList.add(mutter);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mutterList;
    }

    public boolean create(Mutter mutter) {

    	System.out.println("create開始");
    	
        try {
            Class.forName("org.postgresql.Driver");
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
                "INSERT INTO mutter(user_id, user_name, text, post_time) "
              + "VALUES(?, ?, ?, CURRENT_TIMESTAMP)";

            PreparedStatement pStmt =
                    conn.prepareStatement(sql);

            pStmt.setInt(
                    1,
                    mutter.getUserId());

            pStmt.setString(
                    2,
                    mutter.getUserName());
            
            pStmt.setString(3, mutter.getText());

            int result =
                    pStmt.executeUpdate();

            return result == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(
                    "JDBCドライバを読み込めませんでした");
        }

        try (Connection conn =
                DriverManager.getConnection(
                        JDBC_URL,
                        DB_USER,
                        DB_PASS)) {

        	System.out.println("DB接続成功");
        	
            String sql =
                    "DELETE FROM mutter WHERE id = ?";

            PreparedStatement pStmt =
                    conn.prepareStatement(sql);

            pStmt.setInt(1, id);

            int result =
                    pStmt.executeUpdate();
           
            System.out.println("INSERT結果 : " + result);
            
            return result == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }
        
        public Mutter findById(int id) {
        	
        	try {
        		Class.forName("org.postgresql.Driver");
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
        				"SELECT id, user_name, text, post_time "
        				+ "FROM mutter "
        				+ "WHERE id = ?";
        		
        		         PreparedStatement pStmt =
        		        		 conn.prepareStatement(sql);
        		         
        		         pStmt.setInt(1, id);
        		         
        		         ResultSet rs =
        		        		 pStmt.executeQuery();
        		         
        		         if (rs.next()) {
        		        	 return new Mutter(
        		        			 rs.getInt("id"),
        		        			 rs.getInt("user_id"),
        		        			 rs.getString("user_name"),
        		        			 rs.getString("text"),
        		        			 rs.getTimestamp("post_time").toLocalDateTime());
        		         }
        		      } catch (SQLException e) {
        		    	  e.printStackTrace();
        		      }
        	
        	           return null;
        	}
        
            public boolean update(int id, String text) {
            	
            	try {
            		Class.forName("org.postgresql.Driver");
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
            				"UPDATE mutter "
            				+ "SET text = ? "
            			    + "WHERE id = ?";
            		
            		PreparedStatement pStmt =
            				conn.prepareStatement(sql);
            		
            		pStmt.setString(1, text);
            		pStmt.setInt(2, id);
            		
            		int result =
            				pStmt.executeUpdate();
            		
            		return result == 1;
            		
            	} catch (SQLException e) {
            		e.printStackTrace();
            		return false;
            	}
    }
}