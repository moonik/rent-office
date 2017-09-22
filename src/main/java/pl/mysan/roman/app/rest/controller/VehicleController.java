package pl.mysan.roman.app.rest.controller;

import org.springframework.stereotype.Controller;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Vehicle;
import pl.mysan.roman.app.core.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/api/rent-office")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ResponseEntity<VehicleDTO> getDetails(@PathVariable("id") Long id){
        return new ResponseEntity<>(vehicleService.getVehicle(id), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<VehicleDTO>> showAll(){
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }
}
