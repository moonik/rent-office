package pl.mysan.roman.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.mysan.roman.app.core.dto.CarDTO;
import pl.mysan.roman.app.core.dto.UserDTO;
import pl.mysan.roman.app.core.services.AdminService;
import pl.mysan.roman.app.core.services.CarService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CarService carService;

    @DeleteMapping(value = "vehicle/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable Long id){
        adminService.deleteVehicle(id);
    }

    @DeleteMapping(value = "unborrow/{id}/{date}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void unborrow(@PathVariable Long id, @PathVariable String date) throws ParseException {
        adminService.unborrow(id, date);
    }

    @PutMapping(value = "car/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CarDTO editCar(@PathVariable Long id, @RequestBody CarDTO carDTO) throws ParseException {
        return carService.editCar(id, carDTO);
    }

    @GetMapping("/users")
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserDTO> getUsers(){
        return adminService.getUsers();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        adminService.deleteUser(id);
    }
}
