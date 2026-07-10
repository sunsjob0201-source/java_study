package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.TaskInfo;
import com.example.demo.model.User;
import com.example.demo.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskListController {

	private final TaskService taskService;
	
	@GetMapping("/tasklist")
	public String showTaskList(HttpSession session, Model model) {
		
		User loginUser =
				(User) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			
			model.addAttribute(
					"errorMsg",
					"セッションが切れていますので、再度ログインして下さい。");
			
			return "login";
		}

		List<TaskInfo> taskList = 
				taskService.getTaskListByUserId(
						loginUser.getUserId());
		
		model.addAttribute("taskList", taskList);
		
		return "tasklist";
	} 
	 
}
