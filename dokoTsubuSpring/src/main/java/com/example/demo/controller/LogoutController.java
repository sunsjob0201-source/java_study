package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	@GetMapping("/Logout")
	public String logout(HttpSession session) {
	//セッションを破棄
	  session.invalidate();
		
	// logout.jspを表示
	 return "logout";
	}
}
