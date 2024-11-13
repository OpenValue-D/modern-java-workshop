package de.openvalue.modernjava.workshop.domain.repository;

import de.openvalue.modernjava.workshop.domain.model.Borrow;
import de.openvalue.modernjava.workshop.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    @Query("SELECT b FROM Borrow b " +
           "WHERE b.rentable.id=:rentableId " +
           "AND b.returnDate IS null")
    Optional<Borrow> getActiveBorrowForRentable(@Param("rentableId") Long rentableId);
}
