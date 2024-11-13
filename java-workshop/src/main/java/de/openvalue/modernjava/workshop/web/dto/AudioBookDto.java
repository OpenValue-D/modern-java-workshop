package de.openvalue.modernjava.workshop.web.dto;

import java.util.Objects;

public final class AudioBookDto {
    private final Long id;
    private final String author;
    private final String title;
    private final String speaker;

    public AudioBookDto(Long id, String author, String title, String speaker) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.speaker = speaker;
    }

    public Long id() {
        return id;
    }

    public String author() {
        return author;
    }

    public String title() {
        return title;
    }

    public String speaker() {
        return speaker;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AudioBookDto) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.author, that.author) &&
               Objects.equals(this.title, that.title) &&
               Objects.equals(this.speaker, that.speaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, speaker);
    }

    @Override
    public String toString() {
        return "AudioBookDto[" +
               "id=" + id + ", " +
               "author=" + author + ", " +
               "title=" + title + ", " +
               "speaker=" + speaker + ']';
    }


}
