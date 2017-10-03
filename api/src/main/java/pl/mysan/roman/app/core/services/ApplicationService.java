package pl.mysan.roman.app.core.services;

import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Borrower;
import pl.mysan.roman.app.core.models.entities.Vehicle;

import java.text.ParseException;
import java.util.List;

public interface ApplicationService {
    VehicleDTO getVehicle(Long id);
    List<VehicleDTO> getAll();
    void delete(Long id);
    BorrowDTO borrow(BorrowDTO borrowDTO) throws ParseException;
    Borrower save(String name);
    List<VehicleDTO> getAllWithBorrowDate(String date) throws ParseException;
}
