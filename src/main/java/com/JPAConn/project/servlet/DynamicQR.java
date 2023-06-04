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

@WebServlet("/dynamicQR")
public class DynamicQR extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	FacultyRepository faculty;

	@Autowired
	SessionRepository lecture;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lectureId = request.getParameter("lectureId").toLowerCase();

		RequestDispatcher rd;
		HttpSession session = request.getSession();
		
		// If the teacher is logged in then only we can start the attendance session else it will re-direct to the login page
		if ( session.getAttribute("logged") != null && session.getAttribute("logged").equals("yes")){
			
			// Starting new session for attendance
			session.setAttribute("sessionName", lectureId + "_session");

			// Getting qr code based on lecture
			session.setAttribute("url", "http://api.qrserver.com/v1/create-qr-code/?data=http://localhost:8080/attendance?id=" + lectureId +"&size=500x500");
			
			//Updating total lecture conducted by faculty in database
			String uname = session.getAttribute("username").toString();
			FacultyEntity f = faculty.findByUsername(uname);
			f.setTotalConducted( f.getTotalConducted() + 1);
			faculty.save(f);

			// Starting session
			SessionEntity ss;
			if (lectureId.equals("java")){
				ss = lecture.findByName("java");
			} else if (lectureId.equals("pa")){
				ss = lecture.findByName("pa");
			} else {
				ss = lecture.findByName("st");
			}
			ss.setSession(true);
			lecture.save(ss);

			// Setting valid attendance limit
			session.setAttribute("validAttandance", f.getTotalConducted());
			rd = request.getRequestDispatcher("/views/qrCodePage.jsp");

		} else {
			// If the session is not started by any faculty then this servlet will redirect user to login page.
			System.out.println("Trying to access QR code illegally, redirecting ");
			rd = request.getRequestDispatcher("/views/login.jsp");
		}
		rd.forward(request, response);
	
	}
}