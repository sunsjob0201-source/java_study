package com.example.demo.model;

import org.springframework.stereotype.Service;

@Service
public class AddService {
  public int execute(int num1, int num2) {
	  return num1 + num2;
  }
}
