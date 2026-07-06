package com.example.demo.model;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;

@Service
public class RegisterUserLogic {

    public boolean execute(User user) {

        UserDAO dao = new UserDAO();

        return dao.create(user);
    }
}