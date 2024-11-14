package de.openvalue.modernjava.workshop.solution.web.dto;

import java.util.List;

public record CustomerWithBorrowsDto(Long id, String name, List<BorrowDto> borrows) {

}
