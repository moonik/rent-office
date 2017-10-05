package pl.mysan.roman.app.core.asm;

import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.BorrowerDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Borrow;
import pl.mysan.roman.app.core.models.entities.Borrower;
import pl.mysan.roman.app.core.models.entities.Vehicle;

import java.text.ParseException;

public interface ApplicationAsm {
    VehicleDTO convertToDto(Vehicle vehicle);
    BorrowDTO borrowConvertToDto(Borrow borrow);
    Borrow borrowDtoToBorrow(BorrowDTO borrowDTO, Borrower borrower, Vehicle vehicle);
    BorrowerDTO convertToDto(Borrower borrower);
    Borrower convertToBorrower(BorrowerDTO borrowerDTO);
}
