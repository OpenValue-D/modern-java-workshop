package de.openvalue.modernjava.workshop.solution.domain.repository;

import de.openvalue.modernjava.workshop.solution.domain.model.Rentable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentableRepository extends JpaRepository<Rentable, Long> {

}
