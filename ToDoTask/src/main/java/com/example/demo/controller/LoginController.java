package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.LoginService;
import com.example.demo.model.User;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    @GetMapping("/")
    public String showLogin() {
        return "login";
    }
    @PostMapping("/Login")
    public String login(
            @RequestParam("user_id") String userId,
            @RequestParam("user_pass") String userPass,
            HttpSession session) {

        // 入力されたユーザーIDとパスワードでUserを作成
        User user = new User(userId, userPass);

        // ログイン処理
        User loginUser = loginService.execute(user);

        System.out.println(loginUser);
        
        // ログイン成功時
        if (loginUser != null) {
            session.setAttribute("loginUser", loginUser);
            return "menu";
        }

        return "login";
    }
}