package de.openvalue.modernjava.workshop.web.controller;

import de.openvalue.modernjava.workshop.service.AudioBookService;
import de.openvalue.modernjava.workshop.service.BookService;
import de.openvalue.modernjava.workshop.web.dto.CreateAudioBookRequest;
import de.openvalue.modernjava.workshop.web.dto.CreateBookRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryRestController {

    private final BookService bookService;
    private final AudioBookService audioBookService;

    public LibraryRestController(BookService bookService, AudioBookService audioBookService) {
        this.bookService = bookService;
        this.audioBookService = audioBookService;
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

}
