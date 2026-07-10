package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.TaskInfo;
import com.example.demo.model.TaskStatus;

@Repository
public class TaskDAO {

    private final String JDBC_URL =
            "jdbc:postgresql://localhost:5432/todotask";

    private final String DB_USER = "postgres";
    private final String DB_PASS = "psql";


    /**
     * ログインユーザーが作成したタスクを取得する
     */
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
                    DriverManager.getConnection(
                            JDBC_URL,
                            DB_USER,
                            DB_PASS);

            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {
            ps.setString(1, userId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    taskList.add(createTaskInfo(rs));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return taskList;
    }


    /**
     * 全ユーザーのタスクを取得する
     * 将来の管理者機能用
     */
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
                    DriverManager.getConnection(
                            JDBC_URL,
                            DB_USER,
                            DB_PASS);

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery()
        ) {

            while (rs.next()) {
                taskList.add(createTaskInfo(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return taskList;
    }


    /**
     * タスクIDとユーザーIDでタスクを1件取得する
     *
     * 他人のタスクを直接URLで開けないよう、
     * ユーザーIDも検索条件に含める
     */
    public TaskInfo findByIdAndUserId(
            int taskId,
            String userId) {

        String sql =
                "SELECT " +
                "t.task_id, t.task_name, t.task_contents, " +
                "t.task_limitdate, t.task_update, t.task_delete, " +
                "t.task_user, t.task_status, t.user_id, " +
                "s.task_label " +
                "FROM taskinfo t " +
                "JOIN taskstatus s " +
                "ON t.task_status = s.task_status " +
                "WHERE t.task_id = ? " +
                "AND t.user_id = ?";

        try (
            Connection conn =
                    DriverManager.getConnection(
                            JDBC_URL,
                            DB_USER,
                            DB_PASS);

            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {
            ps.setInt(1, taskId);
            ps.setString(2, userId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return createTaskInfo(rs);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * タスク状況一覧を表示順で取得する
     */
    public List<TaskStatus> findStatusList() {

        List<TaskStatus> statusList = new ArrayList<>();

        String sql =
                "SELECT " +
                "task_status, task_label, task_seq, task_progress " +
                "FROM taskstatus " +
                "ORDER BY task_seq";

        try (
            Connection conn =
                    DriverManager.getConnection(
                            JDBC_URL,
                            DB_USER,
                            DB_PASS);

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery()
        ) {

            while (rs.next()) {

                TaskStatus status = new TaskStatus(
                        rs.getInt("task_status"),
                        rs.getString("task_label"),
                        rs.getInt("task_seq"),
                        rs.getBoolean("task_progress")
                );

                statusList.add(status);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return statusList;
    }


    /**
     * 指定されたタスク状況が進行中か確認する
     */
    public boolean isProgressStatus(int taskStatus) {

        String sql =
                "SELECT task_progress " +
                "FROM taskstatus " +
                "WHERE task_status = ?";

        try (
            Connection conn =
                    DriverManager.getConnection(
                            JDBC_URL,
                            DB_USER,
                            DB_PASS);

            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {
            ps.setInt(1, taskStatus);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getBoolean("task_progress");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * タスクを新規登録する
     */
    public boolean insert(TaskInfo task) {

        String sql =
                "INSERT INTO taskinfo (" +
                "task_name, task_contents, task_limitdate, " +
                "task_update, task_delete, task_user, " +
                "task_status, user_id" +
                ") VALUES (?, ?, ?, CURRENT_TIMESTAMP, NULL, ?, ?, ?)";

        try (
            Connection conn =
                    DriverManager.getConnection(
                            JDBC_URL,
                            DB_USER,
                            DB_PASS);

            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {
            ps.setString(1, task.getTaskName());
            ps.setString(2, task.getTaskContents());
            ps.setObject(3, task.getTaskLimitdate());
            ps.setString(4, task.getTaskUser());
            ps.setInt(5, task.getTaskStatus());
            ps.setString(6, task.getUserId());

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * タスクを変更する
     */
    public boolean update(TaskInfo task) {

        String sql =
                "UPDATE taskinfo SET " +
                "task_name = ?, " +
                "task_contents = ?, " +
                "task_limitdate = ?, " +
                "task_update = CURRENT_TIMESTAMP, " +
                "task_user = ?, " +
                "task_status = ? " +
                "WHERE task_id = ? " +
                "AND user_id = ? " +
                "AND task_delete IS NULL";

        try (
            Connection conn =
                    DriverManager.getConnection(
                            JDBC_URL,
                            DB_USER,
                            DB_PASS);

            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {
            ps.setString(1, task.getTaskName());
            ps.setString(2, task.getTaskContents());
            ps.setObject(3, task.getTaskLimitdate());
            ps.setString(4, task.getTaskUser());
            ps.setInt(5, task.getTaskStatus());
            ps.setInt(6, task.getTaskId());
            ps.setString(7, task.getUserId());

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 論理削除する
     *
     * レコード自体は消さず、
     * task_deleteを現在日時に更新する
     */
    public boolean softDelete(
            int taskId,
            String userId) {

        String sql =
                "UPDATE taskinfo SET " +
                "task_delete = CURRENT_TIMESTAMP, " +
                "task_update = CURRENT_TIMESTAMP " +
                "WHERE task_id = ? " +
                "AND user_id = ? " +
                "AND task_delete IS NULL " +
                "AND task_status IN (" +
                "    SELECT task_status " +
                "    FROM taskstatus " +
                "    WHERE task_progress = true" +
                ")";

        try (
            Connection conn =
                    DriverManager.getConnection(
                            JDBC_URL,
                            DB_USER,
                            DB_PASS);

            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {
            ps.setInt(1, taskId);
            ps.setString(2, userId);

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * ResultSetからTaskInfoを作成する共通処理
     */
    private TaskInfo createTaskInfo(ResultSet rs)
            throws Exception {

        Timestamp deleteTimestamp =
                rs.getTimestamp("task_delete");

        return new TaskInfo(
                rs.getInt("task_id"),
                rs.getString("task_name"),
                rs.getString("task_contents"),
                rs.getDate("task_limitdate").toLocalDate(),
                rs.getTimestamp("task_update").toLocalDateTime(),
                deleteTimestamp == null
                        ? null
                        : deleteTimestamp.toLocalDateTime(),
                rs.getString("task_user"),
                rs.getInt("task_status"),
                rs.getString("user_id"),
                rs.getString("task_label")
        );
    }
}