package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

	@PostMapping("/Logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "login";
	}
}
