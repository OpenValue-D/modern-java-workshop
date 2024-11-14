package de.openvalue.modernjava.workshop.solution.service;

import de.openvalue.modernjava.workshop.solution.domain.repository.BookRepository;
import de.openvalue.modernjava.workshop.solution.domain.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Long createBook(String title, String author) {
        var book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookRepository.save(book);
        return book.getId();
    }

    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findAllAvailable() {
        return bookRepository.findAllAvailable();
    }
}
