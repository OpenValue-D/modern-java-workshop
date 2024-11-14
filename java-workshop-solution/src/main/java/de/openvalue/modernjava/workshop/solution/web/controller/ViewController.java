package de.openvalue.modernjava.workshop.solution.web.controller;

import de.openvalue.modernjava.workshop.solution.domain.model.Borrow;
import de.openvalue.modernjava.workshop.solution.domain.repository.BorrowRepository;
import de.openvalue.modernjava.workshop.solution.mapper.DtoMapper;
import de.openvalue.modernjava.workshop.solution.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class ViewController {
    private final DtoMapper dtoMapper;
    private final BorrowService borrowService;
    private final BookService bookService;
    private final AudioBookService audioBookService;
    private final CustomerService customerService;
    private final BorrowRepository borrowRepository;
    private final FeeService feeService;

    public ViewController(DtoMapper dtoMapper, BorrowService borrowService, BookService bookService, AudioBookService audioBookService, CustomerService customerService, BorrowRepository borrowRepository, FeeService feeService) {
        this.dtoMapper = dtoMapper;
        this.borrowService = borrowService;
        this.bookService = bookService;
        this.audioBookService = audioBookService;
        this.customerService = customerService;
        this.borrowRepository = borrowRepository;
        this.feeService = feeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/rent")
    public String rent(Model model) {
        model.addAttribute("books", bookService.findAllAvailable().stream().map(dtoMapper::bookToDto).toList());
        model.addAttribute("audiobooks", audioBookService.findAllAvailable().stream().map(dtoMapper::audioBookToDto).toList());
        return "rent";
    }

    @GetMapping("/return")
    public String returnOverview(Model model) {
        model.addAttribute("customers", customerService.getAllCustomersAndActiveBorrows().stream().map(dtoMapper::customerToDtoWithBorrows).toList());
        return "return";
    }

    @GetMapping("/rentable/{rentableId}/rent")
    public String borrowRentable(@PathVariable("rentableId") long rentableId, Model model) {
        borrowService.assertIsRentable(rentableId);
        model.addAttribute("customers", customerService.findAll().stream().map(dtoMapper::customerToDto).toList());
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
        Optional<Borrow> borrow = borrowRepository.findById(borrowId);
        if(borrow.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rentable cannot be returned");
        }
        borrow.get().setReturnDate(LocalDate.now());
        if(feeService.calculateFee(borrow.get()) > 0) {
            return "redirect:/rentable/" + borrowId + "/return/fee";
        }
        borrowService.returnRentable(borrow.get());
        return "redirect:/return";
    }

    @GetMapping(value = "/rentable/{borrowId}/return/fee")
    public String payFee(@PathVariable("borrowId") long borrowId, Model model) {
        Optional<Borrow> borrow = borrowRepository.findById(borrowId);
        if(borrow.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rentable cannot be returned");
        }
        borrow.get().setReturnDate(LocalDate.now());
        long fee = feeService.calculateFee(borrow.get());
        model.addAttribute("borrow", dtoMapper.borrowToDto(borrow.get()));
        model.addAttribute("fee", fee);
        return "returnDetail";
    }

    @GetMapping(value = "/rentable/{borrowId}/return/paid")
    public String feePaid(@PathVariable("borrowId") long borrowId) {
        Optional<Borrow> borrow = borrowRepository.findById(borrowId);
        if(borrow.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rentable cannot be returned");
        }
        borrowService.returnRentable(borrow.get());
        return "redirect:/return";
    }
}
