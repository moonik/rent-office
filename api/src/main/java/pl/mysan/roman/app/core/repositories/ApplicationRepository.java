package pl.mysan.roman.app.core.repositories;

import pl.mysan.roman.app.core.models.entities.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ApplicationRepository {
    Vehicle save(Vehicle vehicle);
    Vehicle getVehicle(Long id);
    List<Vehicle> getAll();
    void delete(Long id);
    Borrow borrow(Borrow borrow);
    Borrow getBorrowInfo(String date, Vehicle vehicle) throws ParseException;
    List<Borrow> getBorrowInfo(Vehicle vehicle);
    void unborrow(Vehicle vehicle, String date) throws ParseException;
    Boolean ifExists(Long id);
    Authority getAuthority();
}
