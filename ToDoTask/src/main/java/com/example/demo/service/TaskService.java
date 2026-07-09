package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.TaskDAO;
import com.example.demo.model.TaskInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	
	private final TaskDAO taskDAO;
	
	public List<TaskInfo> getTaskList() {
		return taskDAO.findAll();
	}

}