package de.openvalue.modernjava.workshop.solution.service;

import de.openvalue.modernjava.workshop.solution.domain.model.AudioBook;
import de.openvalue.modernjava.workshop.solution.domain.model.Book;
import de.openvalue.modernjava.workshop.solution.domain.model.Borrow;
import de.openvalue.modernjava.workshop.solution.domain.repository.BorrowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class FeeService {
    private final BorrowRepository borrowRepository;

    public FeeService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public long calculateFees(LocalDate fromDate, LocalDate toDate){
        if(toDate.isBefore(fromDate)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "toDate should be after fromDate");
        } else if(fromDate.isAfter(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "fromDate should be in the past");
        } else if(toDate.isAfter(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "toDate should be in the past");
        }

        return borrowRepository.getBorrowsReturnWithinTime(fromDate, toDate).stream().map(this::calculateFee).reduce(0L, Long::sum);
    }

    public long calculateFee(Borrow borrow) {
        return switch (borrow.getRentable()) {
            case Book b
                    when  ChronoUnit.DAYS.between(borrow.getDueDate(), borrow.getReturnDate()) > 7 -> 3;
            case Book b
                    when  ChronoUnit.DAYS.between(borrow.getDueDate(), borrow.getReturnDate()) > 0 -> 2;
            case AudioBook a
                    when  ChronoUnit.DAYS.between(borrow.getDueDate(), borrow.getReturnDate()) > 7 -> 6;
            case AudioBook a
                    when  ChronoUnit.DAYS.between(borrow.getDueDate(), borrow.getReturnDate()) > 0 -> 4;
            default -> 0;
        };
    }
}
