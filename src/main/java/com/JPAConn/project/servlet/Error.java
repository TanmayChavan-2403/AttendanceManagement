package com.JPAConn.project.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/error")
public class Error extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public String doGet() {
		return "Something went wrong <a href='http://localhost:8080/login'> Click here </a>";
	}
}