package de.openvalue.modernjava.workshop.solution.domain.repository;

import de.openvalue.modernjava.workshop.solution.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
