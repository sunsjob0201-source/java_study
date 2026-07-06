package com.example.demo.controller;


import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.RegisterUserLogic;
import com.example.demo.model.User;

@Controller
  public class RegisterUserController {
    @GetMapping("/RegisterUser")
    public String showRegisterForm() {
    	return "register";
    }
    @PostMapping("/RegisterUser")
    public String registerUser(HttpServletRequest request) {

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (name == null || name.isEmpty()
                || pass == null || pass.isEmpty()) {

            request.setAttribute(
                    "errorMsg",
                    "ユーザー名とパスワードを入力してください");
            return "register";

        }

        User user = new User(name, pass);

        RegisterUserLogic logic = new RegisterUserLogic();
        boolean result = logic.execute(user);

        if (result) {
            request.setAttribute("user", user);
            return "registerResult";
        } else {
            request.setAttribute("errorMsg", "ユーザー登録に失敗しました");
            return "register";

        }
    }
}