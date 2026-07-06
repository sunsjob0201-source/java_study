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
        return "index";
    }
    @PostMapping("/Login")
    public String login(
            @RequestParam String name,
            @RequestParam String pass,
            HttpSession session) {

        // 入力された名前とパスワードでUserを作成
        User user = new User(name, pass);

        // ログイン処理
        User loginUser = loginService.execute(user);

        // ログイン成功時
        if (loginUser != null) {
            session.setAttribute("loginUser", loginUser);
        }

        // /WEB-INF/jsp/loginResult.jsp を表示
        return "loginResult";
    }
}