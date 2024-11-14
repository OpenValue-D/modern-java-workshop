package de.openvalue.modernjava.workshop.solution.service;

import de.openvalue.modernjava.workshop.solution.domain.repository.CustomerRepository;
import de.openvalue.modernjava.workshop.solution.domain.model.Borrow;
import de.openvalue.modernjava.workshop.solution.domain.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomersAndActiveBorrows() {
        List<Customer> customers = customerRepository.findAll();
        customers.forEach(it-> it.getBorrows().removeIf(Borrow::isReturned));
        return customers;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
