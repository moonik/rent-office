package pl.mysan.roman.app.core.repositories;

import pl.mysan.roman.app.core.models.entities.Borrow;
import pl.mysan.roman.app.core.models.entities.Borrower;
import pl.mysan.roman.app.core.models.entities.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface ApplicationRepository {
    Vehicle getVehicle(Long id);
    List<Vehicle> getAll();
    void delete(Long id);
    Borrow borrow(Borrow borrow);
    Borrower getBorrower(Long id);
    Borrower save(Borrower borrower);
}