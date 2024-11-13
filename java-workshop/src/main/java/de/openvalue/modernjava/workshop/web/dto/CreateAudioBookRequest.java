package de.openvalue.modernjava.workshop.web.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

public final class CreateAudioBookRequest {
    private final @NotEmpty String title;
    private final @NotEmpty String author;
    private final @NotEmpty String speaker;

    public CreateAudioBookRequest(@NotEmpty String title, @NotEmpty String author, @NotEmpty String speaker) {
        this.title = title;
        this.author = author;
        this.speaker = speaker;
    }

    public @NotEmpty String title() {
        return title;
    }

    public @NotEmpty String author() {
        return author;
    }

    public @NotEmpty String speaker() {
        return speaker;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CreateAudioBookRequest) obj;
        return Objects.equals(this.title, that.title) &&
               Objects.equals(this.author, that.author) &&
               Objects.equals(this.speaker, that.speaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, speaker);
    }

    @Override
    public String toString() {
        return "CreateAudioBookRequest[" +
               "title=" + title + ", " +
               "author=" + author + ", " +
               "speaker=" + speaker + ']';
    }


}
