package com.RSOhub.hub.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int commentId;
    @Getter @Setter private int refUserId;
    @Getter @Setter private int refEventId;
    @Getter @Setter private String text;
    @Getter @Setter private int rating;
    @Getter @Setter private LocalDateTime time;

    public Comment() { }

    public Comment(int refUserId ,int refEventId, String text, int rating) {
        this.refUserId = refUserId;
        this.refEventId = refEventId;
        this.text = text;
        this.rating = rating;
        this.time = LocalDateTime.now();
    }
}
