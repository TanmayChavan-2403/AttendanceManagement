package com.JPAConn.project.servlet;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.JPAConn.project.database.entity.FacultyEntity;
import com.JPAConn.project.database.entity.SessionEntity;
import com.JPAConn.project.database.repository.FacultyRepository;
import com.JPAConn.project.database.repository.SessionRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/faculty")
public class Faculty extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	FacultyRepository faculty;
	
	@Autowired
	SessionRepository lecture;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String endSession = request.getParameter("endSession");
		String password = request.getParameter("password");
		
		
		FacultyEntity user = faculty.findByUsername(username);
		HttpSession session = request.getSession();
		RequestDispatcher rd;

		if (session.getAttribute("logged") != null && session.getAttribute("logged").equals("yes")){
			rd = request.getRequestDispatcher("/views/teacher.jsp");

			if (endSession.equals("yes")){
				// Closing session
				SessionEntity lec = lecture.findByName(session.getAttribute("lecture").toString());
				lec.setSession(false);
				lecture.save(lec);
			}
		} else if (user == null){
			session.setAttribute("error", "User not found");
			rd = request.getRequestDispatcher("/views/login.jsp");
		} else if (!user.getPassword().equals(password)){
			session.setAttribute("error", "Incorrect Password");
			rd = request.getRequestDispatcher("/views/login.jsp");
		} else if (user.getPassword().equals(password)) {
			session.setAttribute("logged", "yes");

			System.out.println("Session started ? " + endSession);
			session.setAttribute("error", "NULL");

			// Storing all the data required to display on the page.
			session.setAttribute("lecture", user.getLecture());
			session.setAttribute("name", user.getName());
			session.setAttribute("batch", user.getBatch());
			session.setAttribute("branch", user.getBranch());
			session.setAttribute("profile", user.getProfile());
			session.setAttribute("conducted", user.getTotalConducted());
			session.setAttribute("username", username);
			
			rd = request.getRequestDispatcher("/views/teacher.jsp");
		} else {
			rd = request.getRequestDispatcher("/views/login.jsp");
		}
		rd.forward(request, response);
	}
}