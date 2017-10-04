export class BorrowDto{
    vehicle: number;
    borrower: number;

    constructor(vehicle: number, borrower: number){
        this.vehicle = vehicle;
        this.borrower = borrower;
    }
}