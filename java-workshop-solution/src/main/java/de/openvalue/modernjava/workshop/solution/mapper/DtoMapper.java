package de.openvalue.modernjava.workshop.solution.mapper;

import de.openvalue.modernjava.workshop.solution.domain.model.AudioBook;
import de.openvalue.modernjava.workshop.solution.domain.model.Borrow;
import de.openvalue.modernjava.workshop.solution.domain.model.Customer;
import de.openvalue.modernjava.workshop.solution.web.dto.*;
import de.openvalue.modernjava.workshop.solution.domain.model.Book;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DtoMapper {

    public BookDto bookToDto(Book book){
        return new BookDto(book.getId(), book.getAuthor(), book.getTitle());
    }

    public AudioBookDto audioBookToDto(AudioBook audioBook){
        return new AudioBookDto(audioBook.getId(), audioBook.getAuthor(), audioBook.getTitle(), audioBook.getSpeaker());
    }

    public BorrowDto borrowToDto(Borrow borrow) {
        Map<String, String> rentableProperties =
            switch(borrow.getRentable()) {
                case Book book ->  new LinkedHashMap<>(Map.of( // preserve insertion order
                        "type", "Book",
                        "id", book.getId().toString(),
                        "author", book.getAuthor(),
                        "title", book.getTitle()
                ));
                case AudioBook audioBook ->  new LinkedHashMap<>(Map.of( // preserve insertion order
                        "type", "AudioBook",
                        "id", audioBook.getId().toString(),
                        "author", audioBook.getAuthor(),
                        "title", audioBook.getTitle(),
                        "speaker", audioBook.getSpeaker()
                ));
                default ->  Map.of();
            };
        return new BorrowDto(borrow.getId(), borrow.getCustomer().getId(), rentableProperties, borrow.getDueDate());
    }

    public CustomerWithBorrowsDto customerToDtoWithBorrows(Customer customer) {
        return new CustomerWithBorrowsDto(customer.getId(), customer.getName(), customer.getBorrows().stream().map(this::borrowToDto).toList());
    }

    public CustomerDto customerToDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName());
    }
}
