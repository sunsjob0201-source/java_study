package com.example.demo.model;


import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDAO;

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