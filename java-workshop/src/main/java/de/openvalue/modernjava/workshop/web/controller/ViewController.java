package de.openvalue.modernjava.workshop.web.controller;

import de.openvalue.modernjava.workshop.domain.model.AudioBook;
import de.openvalue.modernjava.workshop.domain.model.Book;
import de.openvalue.modernjava.workshop.domain.model.Customer;
import de.openvalue.modernjava.workshop.service.*;
import de.openvalue.modernjava.workshop.mapper.DtoMapper;
import de.openvalue.modernjava.workshop.web.dto.AudioBookDto;
import de.openvalue.modernjava.workshop.web.dto.BookDto;
import de.openvalue.modernjava.workshop.web.dto.CustomerDto;
import de.openvalue.modernjava.workshop.web.dto.CustomerWithBorrowsDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {
    private final DtoMapper dtoMapper;
    private final BorrowService borrowService;
    private final BookService bookService;
    private final AudioBookService audioBookService;
    private final CustomerService customerService;

    public ViewController(DtoMapper dtoMapper, BorrowService borrowService, BookService bookService, AudioBookService audioBookService, CustomerService customerService) {
        this.dtoMapper = dtoMapper;
        this.borrowService = borrowService;
        this.bookService = bookService;
        this.audioBookService = audioBookService;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/rent")
    public String rent(Model model) {
        List<BookDto> list = new ArrayList<>();
        for (Book book : bookService.findAllAvailable()) {
            BookDto bookDto = dtoMapper.bookToDto(book);
            list.add(bookDto);
        }
        model.addAttribute("books", list);
        List<AudioBookDto> result = new ArrayList<>();
        for (AudioBook audioBook : audioBookService.findAllAvailable()) {
            AudioBookDto audioBookDto = dtoMapper.audioBookToDto(audioBook);
            result.add(audioBookDto);
        }
        model.addAttribute("audiobooks", result);
        return "rent";
    }

    @GetMapping("/return")
    public String returnOverview(Model model) {
        List<CustomerWithBorrowsDto> list = new ArrayList<>();
        for (Customer customer : customerService.getAllCustomersAndActiveBorrows()) {
            CustomerWithBorrowsDto customerWithBorrowsDto = dtoMapper.customerToDtoWithBorrows(customer);
            list.add(customerWithBorrowsDto);
        }
        model.addAttribute("customers", list);
        return "return";
    }

    @GetMapping("/rentable/{rentableId}/rent")
    public String borrowRentable(@PathVariable("rentableId") long rentableId, Model model) {
        borrowService.assertIsRentable(rentableId);
        List<CustomerDto> list = new ArrayList<>();
        for (Customer customer : customerService.findAll()) {
            CustomerDto customerDto = dtoMapper.customerToDto(customer);
            list.add(customerDto);
        }
        model.addAttribute("customers", list);
        model.addAttribute("rentableId", rentableId);
        return "rentDetail";
    }

    @GetMapping("/rentable/{rentableId}/rent/{customerId}")
    public String borrowRentable(@PathVariable("rentableId") long rentableId, @PathVariable("customerId") long customerId) {
        borrowService.borrowRentable(rentableId, customerId);
        return "redirect:/rent";
    }

    @GetMapping(value = "/rentable/{borrowId}/return")
    public String returnRentable(@PathVariable("borrowId") long borrowId) {
        borrowService.returnRentable(borrowId);
        return "redirect:/return";
    }
}
