package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.TaskInfo;

@Repository
public class TaskDAO {

    private final String JDBC_URL =
            "jdbc:postgresql://localhost:5432/todotask";
    private final String DB_USER = "postgres";
    private final String DB_PASS = "psql";

    public List<TaskInfo> findByUserId(String userId) {

        List<TaskInfo> taskList = new ArrayList<>();

        String sql =
                "SELECT " +
                "t.task_id, t.task_name, t.task_contents, " +
                "t.task_limitdate, t.task_update, t.task_delete, " +
                "t.task_user, t.task_status, t.user_id, " +
                "s.task_label " +
                "FROM taskinfo t " +
                "JOIN taskstatus s " +
                "ON t.task_status = s.task_status " +
                "WHERE t.user_id = ? " +
                "ORDER BY s.task_seq, t.task_id";

        try (
            Connection conn =
                    DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {
            ps.setString(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TaskInfo task = new TaskInfo(
                        rs.getInt("task_id"),
                        rs.getString("task_name"),
                        rs.getString("task_contents"),
                        rs.getDate("task_limitdate").toLocalDate(),
                        rs.getTimestamp("task_update").toLocalDateTime(),
                        rs.getTimestamp("task_delete") == null
                                ? null
                                : rs.getTimestamp("task_delete").toLocalDateTime(),
                        rs.getString("task_user"),
                        rs.getInt("task_status"),
                        rs.getString("user_id"),
                        rs.getString("task_label")
                );

                taskList.add(task);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return taskList;
    }
    
    public List<TaskInfo> findAll() {

        List<TaskInfo> taskList = new ArrayList<>();

        String sql =
                "SELECT " +
                "t.task_id, t.task_name, t.task_contents, " +
                "t.task_limitdate, t.task_update, t.task_delete, " +
                "t.task_user, t.task_status, t.user_id, " +
                "s.task_label " +
                "FROM taskinfo t " +
                "JOIN taskstatus s " +
                "ON t.task_status = s.task_status " +
                "ORDER BY s.task_seq, t.task_id";

        try (
            Connection conn =
                    DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TaskInfo task = new TaskInfo(
                        rs.getInt("task_id"),
                        rs.getString("task_name"),
                        rs.getString("task_contents"),
                        rs.getDate("task_limitdate").toLocalDate(),
                        rs.getTimestamp("task_update").toLocalDateTime(),
                        rs.getTimestamp("task_delete") == null
                                ? null
                                : rs.getTimestamp("task_delete").toLocalDateTime(),
                        rs.getString("task_user"),
                        rs.getInt("task_status"),
                        rs.getString("user_id"),
                        rs.getString("task_label")
                );

                taskList.add(task);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return taskList;
    }
}