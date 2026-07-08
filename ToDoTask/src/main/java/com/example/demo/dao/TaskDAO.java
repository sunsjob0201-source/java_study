package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class TaskDAO {

	    private final String JDBC_URL =
	            "jdbc:postgresql://localhost:5432/todotask";
	    private final String DB_USER = "postgres";
	    private final String DB_PASS = "psql";
	    
	    public List<TaskInfo> findByUserId(String userId) {
	    	
	    	 public Tasklist findByUserId(User user) {

	    	        String sql =
	    	            "JOIN taskinfo us taskstatus" +
	    	            "WHERE user_id = ?" +
	    	            " ORDER BY task_seq";
	    	
	    }

	   
	        
	    }      	
	     

