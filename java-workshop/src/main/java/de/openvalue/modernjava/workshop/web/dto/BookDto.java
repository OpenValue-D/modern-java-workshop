package de.openvalue.modernjava.workshop.web.dto;

import java.util.Objects;

public final class BookDto {
    private final Long id;
    private final String author;
    private final String title;

    public BookDto(Long id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BookDto) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.author, that.author) &&
               Objects.equals(this.title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title);
    }

    @Override
    public String toString() {
        return "BookDto[" +
               "id=" + id + ", " +
               "author=" + author + ", " +
               "title=" + title + ']';
    }


}
