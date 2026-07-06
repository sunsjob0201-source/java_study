package com.example.demo.model;


import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserDAO dao;
	
  public User execute(User user) {
	 
	  return dao.findByLogin(user);
  }
}