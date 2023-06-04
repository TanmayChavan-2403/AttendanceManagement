package com.JPAConn.project.servlet;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.JPAConn.project.database.entity.SessionEntity;
import com.JPAConn.project.database.repository.SessionRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// This servlet is called when the page is first requested.
@WebServlet("/attendance")
public class Attendance extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Autowired
	SessionRepository lecture;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String lectureId = request.getParameter("id");

		// Re-setting attributes to avoid glitch
		session.setAttribute("lectureId", lectureId);
		session.setAttribute("StudentName", "");
		session.setAttribute("StudentUID", "");
		session.setAttribute("StudentBranch", "");
		session.setAttribute("StudentClass", "");
		session.setAttribute("StudentProfile", "");
		session.setAttribute("attended", "false");
		RequestDispatcher rd;

		SessionEntity lec = lecture.findByName(lectureId);
		if ( lec.getSession() &&
			session.getAttribute("sessionName") != null &&
			session.getAttribute("sessionName").equals(lectureId + "_session")){
				rd = request.getRequestDispatcher("/views/home.jsp");	
		} else {
			request.setAttribute("errorMessage", "Ask faculty to start attendance session to visited this page.");
			rd = request.getRequestDispatcher("/views/login.jsp");
		}
		rd.forward(request, response);
	}
}