package com.example.demo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable {
	private String userId; //ユーザーID
	private String userPass; // パスワード
    private String userName; // ユーザー名
    
    public User(String userId, String userPass) {
    	this.userId = userId;
    	this.userPass = userPass;
    
    }
}