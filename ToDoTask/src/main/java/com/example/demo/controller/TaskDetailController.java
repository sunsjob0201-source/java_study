package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskDetailController {
	
	@GetMapping("/taskdetail")
	public String showTaskDetail(
			@RequestParam String mode,
			@RequestParam(required = false) Integer taskId,
			Model model) {
		
		model.addAttribute("mode", mode);
		model.addAttribute("taskId", taskId);
		
		return "taskdetail";
	}

}
