package pl.mysan.roman.app.core.asm;

import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.BorrowerDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Borrow;
import pl.mysan.roman.app.core.models.entities.Borrower;
import pl.mysan.roman.app.core.models.entities.Vehicle;

import java.text.ParseException;

public interface ApplicationAsm {
    VehicleDTO vehicleConvertToDto(Vehicle vehicle);
    BorrowDTO borrowConvertToBorrowDto(Borrow borrow);
    Borrow borrowDtoConvertToBorrow(BorrowDTO borrowDTO, Borrower borrower, Vehicle vehicle);
    BorrowerDTO borrowerConvertToBorrowerDto(Borrower borrower);
    Borrower borrowerDtoConvertToBorrower(BorrowerDTO borrowerDTO);
}
