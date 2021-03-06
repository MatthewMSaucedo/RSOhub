package com.RSOhub.hub.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;
    @Getter @Setter private int number;

    public Value() { }

    public Value(int id, int number) {
        this.id = id;
        this.number = number;
    }

    public Value(int number) {
        this.number = number;
    }
}
