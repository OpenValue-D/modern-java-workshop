package de.openvalue.modernjava.workshop.solution.domain.repository;

import de.openvalue.modernjava.workshop.solution.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("""
            SELECT b FROM Book b
            WHERE b.id NOT IN (
            SELECT bo.rentable.id FROM Borrow bo WHERE bo.returnDate IS NULL)
            """)
    List<Book> findAllAvailable();
}
