package pl.mysan.roman.app.core.services;

import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.BorrowerDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Borrower;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ApplicationService {
    VehicleDTO getVehicle(Long id, LocalDate date) throws ParseException;
    List<VehicleDTO> getAll();
    void delete(Long id);
    BorrowDTO borrow(BorrowDTO borrowDTO);
    Borrower save(String name);
    List<VehicleDTO> getAllWithBorrowDate(LocalDate date);
    List<BorrowerDTO> getUsers();
    void unborrow(Long id, LocalDate date) throws ParseException;
}
