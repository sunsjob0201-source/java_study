package com.example.demo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable {
	private int id; //id
	private String name; // ユーザー名
    private String pass; // パスワード
    
    public User(String name, String pass) {
    	this.name = name;
    	this.pass = pass;
    
    }
}