package com.JPAConn.project.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sessions")
public class SessionEntity {

    @Id
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

}
