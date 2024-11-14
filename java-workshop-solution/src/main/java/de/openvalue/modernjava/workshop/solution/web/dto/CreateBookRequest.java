package de.openvalue.modernjava.workshop.solution.web.dto;

import jakarta.validation.constraints.NotEmpty;

public record CreateBookRequest(@NotEmpty String title, @NotEmpty String author) {

}
