package com.RSOhub.hub.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;
    @Getter @Setter private int refLocationId;
    @Getter @Setter private int refRsoId;
    @Getter @Setter private String time;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private String eventType;

    public Event() { }

    public Event(int refLocationId, int refRsoId, String time, String name, String description, String eventType) {
        this.refLocationId = refLocationId;
        this.refRsoId = refRsoId;
        this.time = time;
        this.name = name;
        this.description = description;
        this.eventType = eventType;
    }

}
