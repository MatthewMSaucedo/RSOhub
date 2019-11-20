package com.RSOhub.hub.dto;

import lombok.Getter;

public class CreateEventRequest {
    @Getter private int refLocationId;
    @Getter private int refRsoId;
    @Getter private String time;
    @Getter private String name;
    @Getter private String description;
    @Getter private String eventType;
}
