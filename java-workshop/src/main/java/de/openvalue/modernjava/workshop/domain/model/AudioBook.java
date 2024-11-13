package de.openvalue.modernjava.workshop.domain.model;

import jakarta.persistence.Entity;

@Entity
public class AudioBook extends Rentable {
    private String speaker;
    private String author;
    private String title;

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
