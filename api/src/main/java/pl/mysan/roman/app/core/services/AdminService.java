package pl.mysan.roman.app.core.services;

import pl.mysan.roman.app.core.dto.CarDTO;
import pl.mysan.roman.app.core.dto.UserDTO;

import java.text.ParseException;
import java.util.List;

public interface AdminService {
    List<UserDTO> getUsers();
    void deleteUser(Long id);
    void deleteVehicle(Long id);
    void unborrow(Long id, String date) throws ParseException;
}
