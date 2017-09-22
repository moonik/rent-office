package app.rest.controller;

import app.core.dto.CarDTO;
import app.core.services.CarService;
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
    public ResponseEntity<CarDTO> saveCar(@RequestBody CarDTO carDTO) throws ParseException {
        carDTO = carService.saveCar(carDTO);
        return new ResponseEntity<>(carDTO, HttpStatus.OK);
    }
}
