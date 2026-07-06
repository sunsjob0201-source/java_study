package com.example.demo.controller;


import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.DeleteMutterLogic;
import com.example.demo.model.User;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DeleteMutterController {
	
	private final DeleteMutterLogic deleteMutterLogic;
	
	@PostMapping("/DeleteMutter")
	public String deleteMutter(
			@RequestParam("id") int id,
			HttpSession session) {
        //ログインユーザーを取得
    	User loginUser =
    			(User) session.getAttribute("loginUser");
      
        
        if (loginUser == null) {
        	return "redirect:/";
        }

        deleteMutterLogic.execute(id, loginUser.getId());
        return "redirect:/Main";
	
    }
}