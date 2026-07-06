package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserDAO {

    private final String JDBC_URL =
            "jdbc:postgresql://localhost:5432/dokotsubu";
    private final String DB_USER = "postgres";
    private final String DB_PASS = "psql";

    public User findByLogin(User user) {

        User loginUser = null;

        String sql =
            "SELECT id, name, pass FROM users " +
            "WHERE name = ? AND pass = ?";
        
        try { 
        	

        try (
            Connection conn =
                DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            PreparedStatement ps =
                conn.prepareStatement(sql)
        ) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getPass());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                loginUser = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("pass"));
            }
        }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return loginUser;
    }
    
    public boolean create(User user) {
        String sql =
            "INSERT INTO users(name, pass) VALUES(?, ?)";

        try (
            Connection conn =
                DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            PreparedStatement ps =
                conn.prepareStatement(sql)
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPass());

            int result = ps.executeUpdate();

            return result == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}