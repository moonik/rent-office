package pl.mysan.roman.app.rest.controller;

import pl.mysan.roman.app.core.dto.CarDTO;
import pl.mysan.roman.app.core.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CarDTO> save(@RequestBody CarDTO carDTO) throws ParseException {
        return new ResponseEntity<>(carService.saveCar(carDTO), HttpStatus.OK);
    }
}
