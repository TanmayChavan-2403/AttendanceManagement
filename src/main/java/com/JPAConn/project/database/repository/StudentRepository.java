package com.JPAConn.project.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPAConn.project.database.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	StudentEntity findByUid(Integer uid);
	
}
