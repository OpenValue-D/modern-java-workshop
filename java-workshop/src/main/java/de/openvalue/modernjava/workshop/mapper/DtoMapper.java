package de.openvalue.modernjava.workshop.mapper;

import de.openvalue.modernjava.workshop.domain.model.AudioBook;
import de.openvalue.modernjava.workshop.domain.model.Borrow;
import de.openvalue.modernjava.workshop.domain.model.Customer;
import de.openvalue.modernjava.workshop.web.dto.*;
import de.openvalue.modernjava.workshop.domain.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DtoMapper {

    public BookDto bookToDto(Book book){
        return new BookDto(book.getId(), book.getAuthor(), book.getTitle());
    }

    public AudioBookDto audioBookToDto(AudioBook audioBook){
        return new AudioBookDto(audioBook.getId(), audioBook.getAuthor(), audioBook.getTitle(), audioBook.getSpeaker());
    }

    public BorrowDto borrowToDto(Borrow borrow) {
        Map<String, String> rentableProperties;
        if (borrow.getRentable() instanceof Book) {
            var book = (Book) borrow.getRentable();
            rentableProperties = new LinkedHashMap<>(Map.of( // preserve insertion order
                    "type", "Book",
                    "id", book.getId().toString(),
                    "author", book.getAuthor(),
                    "title", book.getTitle()
            ));
        } else if (borrow.getRentable() instanceof AudioBook) {
            var audioBook = (AudioBook) borrow.getRentable();
            rentableProperties = new LinkedHashMap<>(Map.of( // preserve insertion order
                    "type", "AudioBook",
                    "id", audioBook.getId().toString(),
                    "author", audioBook.getAuthor(),
                    "title", audioBook.getTitle(),
                    "speaker", audioBook.getSpeaker()
            ));
        } else {
            rentableProperties = Map.of();
        }
        return new BorrowDto(borrow.getId(), borrow.getCustomer().getId(), rentableProperties, borrow.getDueDate());
    }

    public CustomerWithBorrowsDto customerToDtoWithBorrows(Customer customer) {
        List<BorrowDto> list = new ArrayList<>();
        for (Borrow borrow : customer.getBorrows()) {
            BorrowDto borrowDto = borrowToDto(borrow);
            list.add(borrowDto);
        }
        return new CustomerWithBorrowsDto(customer.getId(), customer.getName(), list);
    }

    public CustomerDto customerToDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName());
    }
}
