package de.openvalue.modernjava.workshop.solution.web.dto;

import jakarta.validation.constraints.NotEmpty;

public record CreateAudioBookRequest(@NotEmpty String title, @NotEmpty String author, @NotEmpty String speaker) {

}
