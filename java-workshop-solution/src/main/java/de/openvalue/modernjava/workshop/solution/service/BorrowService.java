package de.openvalue.modernjava.workshop.solution.service;

import de.openvalue.modernjava.workshop.solution.domain.model.*;
import de.openvalue.modernjava.workshop.solution.domain.repository.BorrowRepository;
import de.openvalue.modernjava.workshop.solution.domain.repository.CustomerRepository;
import de.openvalue.modernjava.workshop.solution.domain.repository.RentableRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowService {
    private final BorrowRepository borrowRepository;
    private final RentableRepository rentableRepository;
    private final CustomerRepository customerRepository;

    public BorrowService(BorrowRepository borrowRepository, RentableRepository rentableRepository, CustomerRepository customerRepository) {
        this.borrowRepository = borrowRepository;
        this.rentableRepository = rentableRepository;
        this.customerRepository = customerRepository;
    }

    public void assertIsRentable(long rentableId) {
        Optional<Rentable> rentable = rentableRepository.findById(rentableId);
        if(rentable.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rentable not found");
        }
        if(borrowRepository.getActiveBorrowForRentable(rentableId).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rentable cannot be borrowed");
        }

    }


    public void borrowRentable(long rentableId, long customerId) {
        Optional<Rentable> rentable = rentableRepository.findById(rentableId);
        if(rentable.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rentable not found");
        }
        if(borrowRepository.getActiveBorrowForRentable(rentableId).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rentable cannot be borrowed");
        }

        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }

        var borrow = new Borrow();
        borrow.setRentable(rentable.get());
        borrow.setCustomer(customer.get());
        borrow.setDueDate(calculateDueDate(rentable.get()));
        borrowRepository.save(borrow);
    }

    public void returnRentable(Borrow borrow) {
        borrow.setReturnDate(LocalDate.now());
        borrowRepository.save(borrow);
    }



    private LocalDate calculateDueDate(Rentable rentable){
        return switch (rentable) {
            case Book b -> LocalDate.now().plusDays(30);
            case AudioBook a -> LocalDate.now().plusDays(14);
            default -> LocalDate.now().plusDays(7);
        };
    }
}
