package pl.mysan.roman.app.core.asm;

import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.BorrowerDTO;
import pl.mysan.roman.app.core.dto.UserDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Borrow;
import pl.mysan.roman.app.core.models.entities.UserAccount;
import pl.mysan.roman.app.core.models.entities.Vehicle;

public interface ApplicationAsm {
    VehicleDTO vehicleConvertToDto(Vehicle vehicle);
    BorrowDTO borrowConvertToBorrowDto(Borrow borrow);
    Borrow borrowDtoConvertToBorrow(BorrowDTO borrowDTO, UserAccount borrower, Vehicle vehicle);
    UserDTO userConvertToUserDTO(UserAccount userAccount);
    UserAccount userDTOConvertToUserAccount(UserDTO userDTO);
}