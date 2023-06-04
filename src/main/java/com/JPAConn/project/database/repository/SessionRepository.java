package com.JPAConn.project.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPAConn.project.database.entity.SessionEntity;

public interface SessionRepository extends JpaRepository<SessionEntity, String>{
    SessionEntity findByName(String lecture);
}