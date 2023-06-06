package com.JPAConn.project.database.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sessions")
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    private Boolean session;

    public String name() {
        return name;
    }
    public Boolean getSession() {
        return session;
    }
    public void setSession(Boolean session) {
        this.session = session;
    }
	public SessionEntity(String name, Boolean session) {
		super();
		this.name = name;
		this.session = session;
	}
	public SessionEntity(){};
}
