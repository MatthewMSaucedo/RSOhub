package com.RSOhub.hub.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private int refLocationId;
    @Getter @Setter private int numberOfStudents;

    public University() { }

    public University(String name, String description, int refLocationId, int numberOfStudents) {
        this.name = name;
        this.description = description;
        this.refLocationId = refLocationId;
        this.numberOfStudents = numberOfStudents;
    }
}
