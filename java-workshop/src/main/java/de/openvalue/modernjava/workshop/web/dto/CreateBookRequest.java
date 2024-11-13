package de.openvalue.modernjava.workshop.web.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

public final class CreateBookRequest {
    private final @NotEmpty String title;
    private final @NotEmpty String author;

    public CreateBookRequest(@NotEmpty String title, @NotEmpty String author) {
        this.title = title;
        this.author = author;
    }

    public @NotEmpty String title() {
        return title;
    }

    public @NotEmpty String author() {
        return author;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CreateBookRequest) obj;
        return Objects.equals(this.title, that.title) &&
               Objects.equals(this.author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "CreateBookRequest[" +
               "title=" + title + ", " +
               "author=" + author + ']';
    }


}
