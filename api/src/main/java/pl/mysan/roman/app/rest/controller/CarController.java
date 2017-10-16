package pl.mysan.roman.app.rest.controller;

import pl.mysan.roman.app.core.dto.CarDTO;
import pl.mysan.roman.app.core.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CarDTO save(@RequestBody CarDTO carDTO) throws ParseException {
        return carService.saveCar(carDTO);
    }
}
