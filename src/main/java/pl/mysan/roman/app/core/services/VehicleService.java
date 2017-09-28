package pl.mysan.roman.app.core.services;

import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;

import java.text.ParseException;
import java.util.List;

public interface VehicleService {
    VehicleDTO getVehicle(Long id);
    List<VehicleDTO> getAll();
    void delete(Long id);
    BorrowDTO borrow(BorrowDTO borrowDTO) throws ParseException;
}
