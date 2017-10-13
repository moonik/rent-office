package pl.mysan.roman.app.core.dto;

import java.util.Date;

public class BorrowDTO {

    private Long vehicle;
    private Long borrower;
    private Date borrowDate;

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

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
}