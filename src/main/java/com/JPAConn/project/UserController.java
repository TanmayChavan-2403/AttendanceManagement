package com.JPAConn.project;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.JPAConn.project.database.entity.SessionEntity;
import com.JPAConn.project.database.entity.StudentEntity;
import com.JPAConn.project.database.repository.FacultyRepository;
import com.JPAConn.project.database.repository.SessionRepository;
import com.JPAConn.project.database.repository.StudentRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {

	@Autowired
	FacultyRepository faculty;
	
	@Autowired
	StudentRepository student;

	@Autowired
	SessionRepository lecture;

	@PostMapping("/getStudentData")
	public void getStudentData(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String reqType = req.getParameter("reqType");
		String lectureId = req.getParameter("lectureId");
		HttpSession session = req.getSession();
		RequestDispatcher rd;
		StudentEntity s = student.findByUid(Integer.parseInt(req.getParameter("uid")));
		SessionEntity lec = lecture.findByName(lectureId);

		if (lec.getSession()){
			if (reqType.equals("fetch")){
				session.setAttribute("StudentName", s.getName());
				session.setAttribute("StudentUID", s.getUid());
				session.setAttribute("StudentBranch", s.getBranch());
				session.setAttribute("StudentClass", s.getClass());
				session.setAttribute("StudentProfile", s.getProfile());
				session.setAttribute("attended", "false");
				req.setAttribute("warning", "null");
				rd = req.getRequestDispatcher("/views/home.jsp");
			
			} else { // If reqType == submit 
				session.setAttribute("attended", "true");
				System.out.println(s.getJava());
				System.out.println(session.getAttribute("validAttandance"));
				System.out.println(s.getJava() < Integer.parseInt(session.getAttribute("validAttandance").toString()));
				if (s.getJava() < Integer.parseInt(session.getAttribute("validAttandance").toString())){
					s.setJava(s.getJava() + 1);
					student.save(s);
				} else {
					session.setAttribute("attended", "false");
					req.setAttribute("warning", "You have already marked your attendance!");
				}
				rd = req.getRequestDispatcher("/views/home.jsp");
			}
		} else {
			rd = req.getRequestDispatcher("/views/login.jsp");
		}
		rd.include(req, res);
	}
}
