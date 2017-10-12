package pl.mysan.roman.app.core.dto;

import java.time.LocalDate;
import java.util.Date;

public class BorrowDTO {

    private Long vehicle;
    private Long borrower;
    private LocalDate borrowDate;

    public BorrowDTO(){}

    public Long getVehicle() {
        return vehicle;
    }

    public void setVehicle(Long vehicle) {
        this.vehicle = vehicle;
    }

    public Long getBorrower() {
        return borrower;
    }

    public void setBorrower(Long borrower) {
        this.borrower = borrower;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
}