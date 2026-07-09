package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDAO;
import com.example.demo.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginDAO dao;
	
  public User execute(User user) {
	 
	  //DB検索
	  return dao.findByLogin(user);
  }
}