package pl.mysan.roman.app.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Borrower;
import pl.mysan.roman.app.core.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/api/rent-office")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ResponseEntity<VehicleDTO> getDetails(@PathVariable Long id){
        return new ResponseEntity<>(applicationService.getVehicle(id), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<VehicleDTO>> showAll(){
        return new ResponseEntity<>(applicationService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        applicationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/borrow", method = RequestMethod.POST)
    public ResponseEntity<BorrowDTO> borrow(@RequestBody BorrowDTO borrowDTO) throws ParseException {
        return new ResponseEntity<>(applicationService.borrow(borrowDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/borrower/{name}", method = RequestMethod.POST)
    public ResponseEntity<Borrower> addBorrower(@PathVariable String name){
        return new ResponseEntity<Borrower>(applicationService.save(name), HttpStatus.CREATED);
    }
}