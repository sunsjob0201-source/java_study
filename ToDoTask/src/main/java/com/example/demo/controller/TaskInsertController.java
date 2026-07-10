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
public class TaskInsertController {

    private final TaskService taskService;


    @PostMapping("/taskInsert")
    public String insertTask(
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


        List<String> errorList =
                taskService.validate(
                        taskName,
                        taskContents,
                        taskLimitdate,
                        taskUser,
                        taskStatus);


        // 入力エラー
        if (!errorList.isEmpty()) {

            TaskInfo task = new TaskInfo();

            task.setTaskName(taskName);
            task.setTaskContents(taskContents);
            task.setTaskUser(taskUser);
            task.setTaskStatus(taskStatus);
            task.setUserId(loginUser.getUserId());

            model.addAttribute(
                    "mode",
                    "insert");

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

        task.setTaskName(taskName);
        task.setTaskContents(taskContents);

        task.setTaskLimitdate(
                taskService.parseLimitdate(
                        taskLimitdate));

        task.setTaskUser(taskUser);
        task.setTaskStatus(taskStatus);
        task.setUserId(loginUser.getUserId());


        boolean result =
                taskService.insert(task);

        if (!result) {

            model.addAttribute(
                    "mode",
                    "insert");

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
                    "タスクの登録に失敗しました");

            return "taskdetail";
        }

        return "redirect:/tasklist";
    }
}
