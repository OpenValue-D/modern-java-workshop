package de.openvalue.modernjava.workshop.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER) // EAGER for demonstration purposes
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER) // EAGER for demonstration purposes
    @JoinColumn(name = "rentable_id", nullable = false)
    private Rentable rentable;

    private LocalDate dueDate;
    private LocalDate returnDate;

    public boolean isReturned() {
        return returnDate != null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.addBorrow(this);
    }

    public Rentable getRentable() {
        return rentable;
    }

    public void setRentable(Rentable rentable) {
        this.rentable = rentable;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
