package de.openvalue.modernjava.workshop.web.dto;

import java.util.Objects;

public final class CustomerDto {
    private final Long id;
    private final String name;

    public CustomerDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CustomerDto) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "CustomerDto[" +
               "id=" + id + ", " +
               "name=" + name + ']';
    }


}
