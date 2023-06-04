package com.JPAConn.project;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserRestController {
	
	@PostMapping("/submitAttendance")
	public String submitAttendance(HttpServletRequest req){
		String uid = req.getParameter("uid");
		String lecture = req.getParameter("lectureId");
		System.out.println("Fetching data");
		return "Attendance for UID: " + uid + " for lecture " + lecture + " is marked successsfully!";
	}
}
