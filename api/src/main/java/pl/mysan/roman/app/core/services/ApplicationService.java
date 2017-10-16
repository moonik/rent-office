package pl.mysan.roman.app.core.services;

import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.UserDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;

import java.text.ParseException;
import java.util.List;

public interface ApplicationService {
    VehicleDTO getVehicle(Long id, String date) throws ParseException;
    List<VehicleDTO> getAll();
    BorrowDTO borrow(BorrowDTO borrowDTO);
    List<VehicleDTO> getAllWithBorrowDate(String date);
    UserDTO saveUser(UserDTO userDTO);
}
