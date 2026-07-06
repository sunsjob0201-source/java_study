package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Mutter; 

@Repository
public class MutterDAO {

    private final String JDBC_URL =
            "jdbc:postgresql://localhost:5432/dokotsubu";
    private final String DB_USER = "postgres";
    private final String DB_PASS = "psql";

    public boolean create(Mutter mutter) {

        String sql =
            "INSERT INTO mutter(user_id, text, post_time, image_path) " +
            "VALUES(?, ?, ?, ?)";

        try (
            Connection conn =
                DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            PreparedStatement ps =
                conn.prepareStatement(sql)
        ) {
            ps.setInt(1, mutter.getUserId());
            ps.setString(2, mutter.getText());
            ps.setObject(3, mutter.getPostTime());
            ps.setString(4, mutter.getImagePath());

            int result = ps.executeUpdate();

            return result == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(int id, int userId) {
        String sql = "DELETE FROM mutter WHERE id = ? AND user_id = ?";

        try (
            Connection conn = DriverManager.getConnection(
                    JDBC_URL, DB_USER, DB_PASS);
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.setInt(2, userId);

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Mutter> findAll() {

        List<Mutter> list = new ArrayList<>();

        String sql =
            "SELECT m.id, m.user_id, u.name, m.text, m.post_time, m.image_path " +
            "FROM mutter m " +
            "JOIN users u ON m.user_id = u.id " +
            "ORDER BY m.post_time DESC";

        try (
            Connection conn =
                DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            PreparedStatement ps =
                conn.prepareStatement(sql);
            ResultSet rs =
                ps.executeQuery()
        ) {
            while (rs.next()) {
                Mutter mutter = new Mutter(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("text"),
                        rs.getTimestamp("post_time").toLocalDateTime(),
                        rs.getString("image_path")
                );

                list.add(mutter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}