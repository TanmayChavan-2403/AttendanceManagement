package com.JPAConn.project.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPAConn.project.database.entity.FacultyEntity;

public interface FacultyRepository extends JpaRepository<FacultyEntity, String> {
	FacultyEntity findByUsername(String username);
}
