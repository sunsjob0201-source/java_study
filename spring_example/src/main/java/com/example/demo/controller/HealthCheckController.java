package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Health;
import com.example.demo.model.HealthCheckService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor


public class HealthCheckController {
	private final HealthCheckService healthCheckService;
     
	@GetMapping("/HealthCheck")
	public String showHealthCheck() {
		//フォワード
		return "healthCheck";
	}
	
	@PostMapping("/HealthCheck") 
	public String executeHealthCheck(
			@RequestParam double weight,
			@RequestParam double height,
			HttpServletRequest request){
		//入力値をプロパティに設定
		Health health = new Health();
		health.setHeight(height);
		health.setWeight(weight);
		
		//健康診断を実行し結果を設定
		this.healthCheckService.execute(health);
		
		//リクエストスコープに保存
		request.setAttribute("health", health);
		
		//フォワード
		return "healthCheckResult";
	}

}
