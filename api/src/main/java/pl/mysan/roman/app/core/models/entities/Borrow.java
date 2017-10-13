package pl.mysan.roman.app.core.models.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Borrow {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

    @OneToOne(fetch = FetchType.LAZY)
    private Borrower borrower;

    @Temporal(TemporalType.DATE)
    private Date borrowDate;

    public Borrow(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
}