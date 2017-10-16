package pl.mysan.roman.app.rest.controller;

import org.springframework.web.bind.annotation.*;
import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.CarDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import pl.mysan.roman.app.core.services.CarService;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rent-office")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping(value = "/details/{id}/{date}")
    @ResponseStatus(value = HttpStatus.OK)
    public VehicleDTO getDetails(@PathVariable Long id, @PathVariable String date) throws ParseException {
        return applicationService.getVehicle(id, date);
    }

    @GetMapping(value = {"", "/{date}"})
    @ResponseStatus(value = HttpStatus.OK)
    public List<VehicleDTO> showAll(@PathVariable Optional<String> date) {
        if(date.isPresent()){
            return applicationService.getAllWithBorrowDate(date.get());
        }else
            return applicationService.getAll();
    }

    @PostMapping(value = "/borrow")
    @ResponseStatus(value = HttpStatus.OK)
    public BorrowDTO borrow(@RequestBody BorrowDTO borrowDTO) throws ParseException {
        return applicationService.borrow(borrowDTO);
    }
}
