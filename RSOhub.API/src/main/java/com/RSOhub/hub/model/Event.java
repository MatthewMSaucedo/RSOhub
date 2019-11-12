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
    @Getter @Setter private int eventId;
    @Getter @Setter private int refLocationId;
    @Getter @Setter private String time;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private EventType eventType;

    public Event() { }

    public Event(int refLocationId, String time, String name, String description, EventType eventType) {
        this.refLocationId = refLocationId;
        this.time = time;
        this.name = name;
        this.description = description;
        this.eventType = eventType;
    }

}
