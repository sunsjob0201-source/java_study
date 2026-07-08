package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class LoginDAO {

    private final String JDBC_URL =
            "jdbc:postgresql://localhost:5432/todotask";
    private final String DB_USER = "postgres";
    private final String DB_PASS = "psql";

    public User findByLogin(User user) {

        User loginUser = null;

        String sql =
            "SELECT user_id, user_pass,user_name" +
            " FROM login " +
            "WHERE user_id = ?" +
            " AND user_pass = ?";
        
        	
        try (
            Connection conn =
                DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            PreparedStatement ps =
                conn.prepareStatement(sql)
        ) {

            ps.setString(1, user.getUserId());
            ps.setString(2, user.getUserPass());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                loginUser = new User(
                        rs.getString("user_id"),
                        rs.getString("user_pass"),
                        rs.getString("user_name"));
            }
        

        } catch (Exception e) {
            e.printStackTrace();
        }

        return loginUser;
    }
}