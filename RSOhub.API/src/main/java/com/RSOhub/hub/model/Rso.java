package com.RSOhub.hub.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int rsoId;
    @Getter @Setter private String name;
    @Getter @Setter private boolean isActive;
    @Getter @Setter private int memberCount;

    public Rso() { }

    public Rso(String name) {
        this.name = name;
        this.isActive = false;
        this.memberCount = 0;
    }

    public int addMember() {
        return ++this.memberCount;
    }
}
