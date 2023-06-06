package com.JPAConn.project.database.entity;

import jakarta.persistence.*;

@Table(name = "faculty")
@Entity
public class FacultyEntity {
	// username, Name, password, lecture, profile, totalConducted, batch, branch
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "username")
	private String username;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "password")
	private String password;
	
	@Column(name= "lecture")
	private String lecture;
	
	@Column(name= "profile")
	private String profile;
	
	@Column(name= "total_conducted")
	private Integer total_conducted;
	
	@Column(name= "batch")
	private String batch;
	
	@Column(name= "branch")
	private String branch;
	
	@Column(name="session")
	private Boolean session;
	
	

	public FacultyEntity(String username, String name, String password, String lecture, String profile,
			Integer total_conducted, String batch, String branch, Boolean session) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.lecture = lecture;
		this.profile = profile;
		this.total_conducted = total_conducted;
		this.batch = batch;
		this.branch = branch;
		this.session = session;
	}

	public FacultyEntity() {
		// TODO Auto-generated constructor stub
	}

	public Boolean getSession() {
		return session;
	}

	public void setSession(Boolean session) {
		this.session = session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Integer getTotalConducted() {
		return total_conducted;
	}

	public void setTotalConducted(Integer totalConducted) {
		this.total_conducted = totalConducted;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}


	
		
}
