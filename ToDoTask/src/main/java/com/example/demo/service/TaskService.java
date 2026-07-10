package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.TaskDAO;
import com.example.demo.model.TaskInfo;
import com.example.demo.model.TaskStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskDAO taskDAO;

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter
                    .ofPattern("uuuu-MM-dd")
                    .withResolverStyle(ResolverStyle.STRICT);


    /**
     * 一般ユーザー用タスク一覧
     */
    public List<TaskInfo> getTaskListByUserId(
            String userId) {

        return taskDAO.findByUserId(userId);
    }


    /**
     * 将来の管理者機能用
     */
    public List<TaskInfo> getAllTaskList() {

        return taskDAO.findAll();
    }


    /**
     * ログインユーザーが所有するタスクを1件取得する
     */
    public TaskInfo getTaskById(
            int taskId,
            String userId) {

        return taskDAO.findByIdAndUserId(
                taskId,
                userId);
    }


    /**
     * タスク状況一覧を取得する
     */
    public List<TaskStatus> getStatusList() {

        return taskDAO.findStatusList();
    }


    /**
     * タスク状況が進行中か確認する
     */
    public boolean isProgressStatus(int taskStatus) {

        return taskDAO.isProgressStatus(taskStatus);
    }


    /**
     * 入力チェック
     */
    public List<String> validate(
            String taskName,
            String taskContents,
            String taskLimitdate,
            String taskUser,
            int taskStatus) {

        List<String> errorList = new ArrayList<>();


        // タスク名称
        if (taskName == null || taskName.isBlank()) {

            errorList.add("タスク名称が空白です");

        } else if (taskName.length() > 50) {

            errorList.add("タスク名称が長すぎます");
        }


        // タスク内容
        if (taskContents == null
                || taskContents.isBlank()) {

            errorList.add("タスク内容が空白です");

        } else if (taskContents.length() > 100) {

            errorList.add("タスク内容が長すぎます");
        }


        // タスク期限
        LocalDate limitDate = null;

        if (taskLimitdate == null
                || taskLimitdate.isBlank()) {

            errorList.add("タスク期限が空白です");

        } else if (!taskLimitdate.matches(
                "\\d{4}-\\d{2}-\\d{2}")) {

            errorList.add("タスク期限の入力形式が違います");

        } else {

            try {
                limitDate =
                        LocalDate.parse(
                                taskLimitdate,
                                DATE_FORMATTER);

            } catch (DateTimeParseException e) {

                errorList.add("タスク期限が誤りです");
            }
        }


        // 進行中の場合のみ過去日付をエラーにする
        if (limitDate != null
                && isProgressStatus(taskStatus)
                && limitDate.isBefore(LocalDate.now())) {

            errorList.add("タスク期限が過去日付です");
        }


        // タスク担当者
        if (taskUser == null || taskUser.isBlank()) {

            errorList.add("タスク担当者が空白です");

        } else if (taskUser.length() > 64) {

            errorList.add("タスク担当者が長すぎます");
        }

        return errorList;
    }


    /**
     * 文字列の日付をLocalDateへ変換する
     */
    public LocalDate parseLimitdate(
            String taskLimitdate) {

        return LocalDate.parse(
                taskLimitdate,
                DATE_FORMATTER);
    }


    /**
     * タスクを新規登録する
     */
    public boolean insert(TaskInfo task) {

        return taskDAO.insert(task);
    }


    /**
     * タスクを変更する
     */
    public boolean update(TaskInfo task) {

        return taskDAO.update(task);
    }


    /**
     * タスクを論理削除する
     */
    public boolean delete(
            int taskId,
            String userId) {

        return taskDAO.softDelete(
                taskId,
                userId);
    }
}