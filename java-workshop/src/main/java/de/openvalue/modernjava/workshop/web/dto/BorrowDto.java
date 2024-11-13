package de.openvalue.modernjava.workshop.web.dto;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public final class BorrowDto {
    private final long id;
    private final long customerId;
    private final Map<String, String> rentableProperties;
    private final LocalDate dueDate;

    public BorrowDto(
            long id,
            long customerId,
            Map<String, String> rentableProperties,
            LocalDate dueDate) {
        this.id = id;
        this.customerId = customerId;
        this.rentableProperties = rentableProperties;
        this.dueDate = dueDate;
    }

    public long id() {
        return id;
    }

    public long customerId() {
        return customerId;
    }

    public Map<String, String> rentableProperties() {
        return rentableProperties;
    }

    public LocalDate dueDate() {
        return dueDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BorrowDto) obj;
        return this.id == that.id &&
               this.customerId == that.customerId &&
               Objects.equals(this.rentableProperties, that.rentableProperties) &&
               Objects.equals(this.dueDate, that.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, rentableProperties, dueDate);
    }

    @Override
    public String toString() {
        return "BorrowDto[" +
               "id=" + id + ", " +
               "customerId=" + customerId + ", " +
               "rentableProperties=" + rentableProperties + ", " +
               "dueDate=" + dueDate + ']';
    }


}
