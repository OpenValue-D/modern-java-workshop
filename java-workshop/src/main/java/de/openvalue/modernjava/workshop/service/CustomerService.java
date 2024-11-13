package de.openvalue.modernjava.workshop.service;

import de.openvalue.modernjava.workshop.domain.repository.CustomerRepository;
import de.openvalue.modernjava.workshop.domain.model.Borrow;
import de.openvalue.modernjava.workshop.domain.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomersAndActiveBorrows() {
        List<Customer> customers = customerRepository.findAll();
        for (Customer it : customers) {
            Iterator<Borrow> iterator = it.getBorrows().iterator();
            while(iterator.hasNext()) {
                if(iterator.next().isReturned()){
                    iterator.remove();
                }
            }
        }
        return customers;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
