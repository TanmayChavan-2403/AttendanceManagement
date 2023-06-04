package com.JPAConn.project.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class StudentEntity {
	
	// uid, name, branch, roll_number, java, process_automation, software_testing, year, profile

	@Id
	@Column(name="uid")
	private Integer uid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="roll_number")
	private String rollNumber;
	
	@Column(name="java")
	private Integer java;
	
	@Column(name="process_automation")
	private Integer pa;
	
	@Column(name="software_testing")
	private Integer st;
	
	@Column(name="year")
	private String year;
	
	@Column(name="profile")
	private String profile;	
	
	public Integer getUid() {
		return uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public Integer getJava() {
		return java;
	}

	public void setJava(Integer java) {
		this.java = java;
	}

	public Integer getPa() {
		return pa;
	}

	public void setPa(Integer pa) {
		this.pa = pa;
	}

	public Integer getSt() {
		return st;
	}

	public void setSt(Integer st) {
		this.st = st;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}


}
