package pl.mysan.roman.app.core.asm;

import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Borrow;
import pl.mysan.roman.app.core.models.entities.Vehicle;

import java.text.ParseException;

public interface VehicleAsm {
    VehicleDTO convertToDto(Vehicle vehicle);
    BorrowDTO borrowConvertToDto(Borrow borrow);
    Borrow borrowDtoToBorrow(BorrowDTO borrowDTO) throws ParseException;
}
