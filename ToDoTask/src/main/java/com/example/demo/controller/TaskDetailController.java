package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.TaskInfo;
import com.example.demo.model.TaskStatus;
import com.example.demo.model.User;
import com.example.demo.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskDetailController {

    private final TaskService taskService;


    @GetMapping("/taskdetail")
    public String showTaskDetail(
            @RequestParam String mode,
            @RequestParam(required = false) Integer taskId,
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


        List<TaskStatus> statusList =
                taskService.getStatusList();

        model.addAttribute(
                "statusList",
                statusList);


        // 新規登録画面
        if ("insert".equals(mode)) {

            TaskInfo task = new TaskInfo();

            task.setTaskStatus(0);
            task.setTaskUser(loginUser.getUserName());

            model.addAttribute(
                    "mode",
                    "insert");

            model.addAttribute(
                    "task",
                    task);

            return "taskdetail";
        }


        // 変更画面ではtaskIdが必要
        if (taskId == null) {

            return "redirect:/tasklist";
        }


        TaskInfo task =
                taskService.getTaskById(
                        taskId,
                        loginUser.getUserId());

        // 他人のタスク、存在しないタスクの場合
        if (task == null) {

            return "redirect:/tasklist";
        }

        // 削除済みの場合
        if (task.getTaskDelete() != null) {

            return "redirect:/tasklist";
        }


        // DBの状況から画面モードを決める
        if (taskService.isProgressStatus(
                task.getTaskStatus())) {

            model.addAttribute(
                    "mode",
                    "updateDelete");

        } else {

            model.addAttribute(
                    "mode",
                    "update");
        }

        model.addAttribute(
                "task",
                task);

        return "taskdetail";
    }
}