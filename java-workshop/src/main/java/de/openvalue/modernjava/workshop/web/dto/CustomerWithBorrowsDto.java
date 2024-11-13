package de.openvalue.modernjava.workshop.web.dto;

import java.util.List;
import java.util.Objects;

public final class CustomerWithBorrowsDto {
    private final Long id;
    private final String name;
    private final List<BorrowDto> borrows;

    public CustomerWithBorrowsDto(Long id, String name, List<BorrowDto> borrows) {
        this.id = id;
        this.name = name;
        this.borrows = borrows;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public List<BorrowDto> borrows() {
        return borrows;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CustomerWithBorrowsDto) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.name, that.name) &&
               Objects.equals(this.borrows, that.borrows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, borrows);
    }

    @Override
    public String toString() {
        return "CustomerWithBorrowsDto[" +
               "id=" + id + ", " +
               "name=" + name + ", " +
               "borrows=" + borrows + ']';
    }


}
