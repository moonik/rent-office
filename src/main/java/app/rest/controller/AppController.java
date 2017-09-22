package app.rest.controller;

import app.core.dto.CarDTO;
import app.core.models.entities.Bike;
import app.core.models.entities.Vehicle;
import app.core.repositories.BikeRepository;
import app.core.repositories.VehicleRepository;
import app.core.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public ResponseEntity<CarDTO> saveCar(@RequestBody CarDTO carDTO) throws ParseException {
        carDTO = appService.saveCar(carDTO);
        return new ResponseEntity<>(carDTO, HttpStatus.OK);
    }
}
