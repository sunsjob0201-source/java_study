package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.TaskInfo;
import com.example.demo.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskListController {

	private final TaskService taskService;
	@GetMapping("/tasklist")
	public String showTaskList(Model model) {

		List<TaskInfo> taskList = taskService.getTaskList();
		
		model.addAttribute("taskList", taskList);
		
		return "tasklist";
	} 
	 
}
