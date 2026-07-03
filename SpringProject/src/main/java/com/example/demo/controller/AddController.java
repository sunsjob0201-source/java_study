package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.AddService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AddController {
	// さー
private final AddService addService;

@PostMapping("/add")
public String handle(
		@RequestParam int num1, @RequestParam int num2) {
	// サービスに処理（足し算）を依頼
	int ans = this.addService.execute(num1, num2);
    System.out.println("ans = " + ans);
    return "hello";
}
}
