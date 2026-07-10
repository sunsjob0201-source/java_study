package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.TaskInfo;
import com.example.demo.model.User;
import com.example.demo.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskUpdateController {

    private final TaskService taskService;


    @PostMapping("/taskUpdate")
    public String updateTask(
            @RequestParam int taskId,
            @RequestParam String taskName,
            @RequestParam String taskContents,
            @RequestParam String taskLimitdate,
            @RequestParam String taskUser,
            @RequestParam int taskStatus,
            HttpSession session,
            Model model) {

        User loginUser =
                (User) session.getAttribute("loginUser");

        // ログインチェック
        if (loginUser == null) {

            model.addAttribute(
                    "errorMsg",
                    "セッションが切れていますので、再度ログインして下さい。");

            return "login";
        }


        TaskInfo oldTask =
                taskService.getTaskById(
                        taskId,
                        loginUser.getUserId());

        // 存在しない、他人のタスク、削除済み
        if (oldTask == null
                || oldTask.getTaskDelete() != null) {

            return "redirect:/tasklist";
        }


        List<String> errorList =
                taskService.validate(
                        taskName,
                        taskContents,
                        taskLimitdate,
                        taskUser,
                        taskStatus);


        // 元のDB状態から画面モードを決める
        String mode;

        if (taskService.isProgressStatus(
                oldTask.getTaskStatus())) {

            mode = "updateDelete";

        } else {

            mode = "update";
        }


        // 入力エラー
        if (!errorList.isEmpty()) {

            TaskInfo task = new TaskInfo();

            task.setTaskId(taskId);
            task.setTaskName(taskName);
            task.setTaskContents(taskContents);
            task.setTaskUser(taskUser);
            task.setTaskStatus(taskStatus);
            task.setUserId(loginUser.getUserId());

            model.addAttribute(
                    "mode",
                    mode);

            model.addAttribute(
                    "task",
                    task);

            model.addAttribute(
                    "taskLimitdateValue",
                    taskLimitdate);

            model.addAttribute(
                    "statusList",
                    taskService.getStatusList());

            model.addAttribute(
                    "errorList",
                    errorList);

            return "taskdetail";
        }


        TaskInfo task = new TaskInfo();

        task.setTaskId(taskId);
        task.setTaskName(taskName);
        task.setTaskContents(taskContents);

        task.setTaskLimitdate(
                taskService.parseLimitdate(
                        taskLimitdate));

        task.setTaskUser(taskUser);
        task.setTaskStatus(taskStatus);
        task.setUserId(loginUser.getUserId());


        boolean result =
                taskService.update(task);

        if (!result) {

            model.addAttribute(
                    "mode",
                    mode);

            model.addAttribute(
                    "task",
                    task);

            model.addAttribute(
                    "taskLimitdateValue",
                    taskLimitdate);

            model.addAttribute(
                    "statusList",
                    taskService.getStatusList());

            model.addAttribute(
                    "errorMsg",
                    "タスクの変更に失敗しました");

            return "taskdetail";
        }

        return "redirect:/tasklist";
    }
}