package com.example.demo.controller;

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
public class TaskDeleteController {

    private final TaskService taskService;


    @PostMapping("/taskDelete")
    public String deleteTask(
            @RequestParam int taskId,
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


        TaskInfo task =
                taskService.getTaskById(
                        taskId,
                        loginUser.getUserId());

        // 存在しない、他人のタスク、削除済み
        if (task == null
                || task.getTaskDelete() != null) {

            return "redirect:/tasklist";
        }


        // 進行中以外は削除不可
        if (!taskService.isProgressStatus(
                task.getTaskStatus())) {

            return "redirect:/tasklist";
        }


        taskService.delete(
                taskId,
                loginUser.getUserId());

        return "redirect:/tasklist";
    }
}