package com.JPAConn.project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@ServletComponentScan
@SpringBootApplication
@Controller
public class AttendanceManagementApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(AttendanceManagementApplication.class, args);
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res){
		HttpSession session = req.getSession();
		session.setAttribute("logged", "no");
		session.setAttribute("lecture", "");
		session.setAttribute("name", "");
		session.setAttribute("batch", "");
		session.setAttribute("branch", "");
		session.setAttribute("profile", "");
		session.setAttribute("conducted", "");
		session.setAttribute("username","");
			
		return "login";
	}
	

//	@GetMapping("/attendance")
//	public String home(String id, HttpServletRequest req){
//		HttpSession session = req.getSession();
//		session.setAttribute("id", id);
//		return "home";
//	}
}