package de.openvalue.modernjava.workshop.domain.repository;

import de.openvalue.modernjava.workshop.domain.model.Book;
import de.openvalue.modernjava.workshop.domain.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b " +
           "WHERE b.id NOT IN (" +
           "SELECT bo.rentable.id FROM Borrow bo WHERE bo.returnDate IS NULL)")
    List<Book> findAllAvailable();
}
