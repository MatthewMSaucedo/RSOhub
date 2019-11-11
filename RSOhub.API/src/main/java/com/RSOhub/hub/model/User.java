package com.RSOhub.hub.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int userId;
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private int refUniversityId;
    @Getter @Setter private UserType userType;

    public User() { }

    public User(String username, String password, int refUniversityId, UserType userType) {
        this.username = username;
        this.password = password;
        this.refUniversityId = refUniversityId;
        this.userType = userType;
    }
}
