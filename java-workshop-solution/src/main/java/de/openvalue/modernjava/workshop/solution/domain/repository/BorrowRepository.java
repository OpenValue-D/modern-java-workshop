package de.openvalue.modernjava.workshop.solution.domain.repository;

import de.openvalue.modernjava.workshop.solution.domain.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    @Query("""
            SELECT b FROM Borrow b
            WHERE b.rentable.id=:rentableId
            AND b.returnDate IS null
            """)
    Optional<Borrow> getActiveBorrowForRentable(@Param("rentableId") Long rentableId);

    @Query("""
            SELECT b FROM Borrow b
            WHERE b.returnDate BETWEEN :fromDate AND :toDate
            """)//
    List<Borrow> getBorrowsReturnWithinTime(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);
}
