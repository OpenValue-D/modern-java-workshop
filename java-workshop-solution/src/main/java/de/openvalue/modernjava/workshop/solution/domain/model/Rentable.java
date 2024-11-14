package de.openvalue.modernjava.workshop.solution.domain.model;

import jakarta.persistence.*;

@Entity
@Inheritance
public abstract class Rentable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
