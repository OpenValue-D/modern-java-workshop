package de.openvalue.modernjava.workshop.solution.domain.repository;

import de.openvalue.modernjava.workshop.solution.domain.model.AudioBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudioBookRepository extends JpaRepository<AudioBook, Long> {

    @Query("""
            SELECT a FROM AudioBook a
            WHERE a.id NOT IN (
            SELECT b.rentable.id FROM Borrow b WHERE b.returnDate IS NULL)
            """)
    List<AudioBook> findAllAvailable();}
