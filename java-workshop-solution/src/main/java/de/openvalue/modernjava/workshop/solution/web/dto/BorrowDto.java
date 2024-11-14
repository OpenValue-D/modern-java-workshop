package de.openvalue.modernjava.workshop.solution.web.dto;

import java.time.LocalDate;
import java.util.Map;

public record BorrowDto (
        long id,
        long customerId,
        Map<String, String> rentableProperties,
        LocalDate dueDate) {

}
