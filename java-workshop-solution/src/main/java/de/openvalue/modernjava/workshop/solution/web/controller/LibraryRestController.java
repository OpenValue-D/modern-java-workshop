package de.openvalue.modernjava.workshop.solution.web.controller;

import de.openvalue.modernjava.workshop.solution.service.AudioBookService;
import de.openvalue.modernjava.workshop.solution.service.BookService;
import de.openvalue.modernjava.workshop.solution.service.FeeService;
import de.openvalue.modernjava.workshop.solution.web.dto.CreateAudioBookRequest;
import de.openvalue.modernjava.workshop.solution.web.dto.CreateBookRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class LibraryRestController {

    private final BookService bookService;
    private final AudioBookService audioBookService;
    private final FeeService feeService;

    public LibraryRestController(BookService bookService, AudioBookService audioBookService, FeeService feeService) {
        this.bookService = bookService;
        this.audioBookService = audioBookService;
        this.feeService = feeService;
    }

    @PostMapping("/book")
    public Long createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        return bookService.createBook(createBookRequest.title(), createBookRequest.author());
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") long id) {
        bookService.deleteById(id);
    }

    @PostMapping("/audiobook")
    public Long createAudioBook(@Valid @RequestBody CreateAudioBookRequest createAudioBookRequest) {
        return audioBookService.createAudioBook(createAudioBookRequest.title(), createAudioBookRequest.author(), createAudioBookRequest.speaker());
    }

    @DeleteMapping("/audiobook/{id}")
    public void deleteAudioBook(@PathVariable("id") long id) {
        audioBookService.deleteById(id);
    }

    @GetMapping("/fees/from/{fromDate}/to/{toDate}")
    public long getFees(@PathVariable("fromDate") LocalDate fromDate, @PathVariable("toDate") LocalDate toDate ) {
        return feeService.calculateFees(fromDate, toDate);
    }
}
