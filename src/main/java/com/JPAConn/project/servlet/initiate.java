package com.JPAConn.project.servlet;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.JPAConn.project.database.entity.FacultyEntity;
import com.JPAConn.project.database.entity.SessionEntity;
import com.JPAConn.project.database.entity.StudentEntity;
import com.JPAConn.project.database.repository.FacultyRepository;
import com.JPAConn.project.database.repository.SessionRepository;
import com.JPAConn.project.database.repository.StudentRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/initiate")
public class initiate extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Autowired
	FacultyRepository faculty;
	
	@Autowired
	StudentRepository student;
	
	@Autowired
	SessionRepository session;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacultyEntity fObj = new FacultyEntity("01Aarti", "Prof. Dr. Aarti Karande", "aarti@123", "java", "https://mca.spit.ac.in/wp-content/uploads/2022/12/aarti.png", 0, "FY", "MCA", false);
		
		StudentEntity tanmayObj = new StudentEntity(2022510005, "Tanmay Chavan", "MCA", "05", 0, 0, 0, "FY", "https://gamepedia.cursecdn.com/valorant_esports_gamepedia_en/6/68/Agent_Omen_Half.png");
		StudentEntity TejasObj = new StudentEntity(2022510004, "Tejas Chalke", "MCA", "04", 0, 0, 0, "FY", "https://trackercdn.com/cdn/tracker.gg/valorant/db/agents/sage_portrait.png");
		StudentEntity VirajObj = new StudentEntity(2022510011, "Viraj Dhumall", "MCA", "11", 0, 0, 0, "FY", "https://trackercdn.com/cdn/tracker.gg/valorant/db/agents/yoru_portrait.png");
		
		SessionEntity s1 = new SessionEntity("java", false);
		SessionEntity s2 = new SessionEntity("pa", false);
		SessionEntity s3 = new SessionEntity("st", false);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		student.save(tanmayObj);
		student.save(TejasObj);
		student.save(VirajObj);
		faculty.save(fObj);
		
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
		
		session.setAttribute("logged", "no");
		session.setAttribute("error", "NULL");
		rd.forward(request, response);
	}
	
	
}
