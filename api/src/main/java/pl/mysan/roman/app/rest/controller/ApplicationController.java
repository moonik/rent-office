package pl.mysan.roman.app.rest.controller;

import org.springframework.web.bind.annotation.*;
import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.BorrowerDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Borrower;
import pl.mysan.roman.app.core.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rent-office")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/details/{id}/{date}", method = RequestMethod.GET)
    public ResponseEntity<VehicleDTO> getDetails(@PathVariable Long id, @PathVariable Optional<String> date) throws ParseException {
        return new ResponseEntity<>(applicationService.getVehicle(id, date.get()), HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/{date}"}, method = RequestMethod.GET)
    public ResponseEntity<List<VehicleDTO>> showAll(@PathVariable Optional<String> date) throws ParseException {
        if(date.isPresent()){
            return new ResponseEntity<List<VehicleDTO>>(applicationService.getAllWithBorrowDate(date.get()), HttpStatus.OK);
        }else
            return new ResponseEntity<>(applicationService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        applicationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/borrow", method = RequestMethod.POST)
    public ResponseEntity<BorrowDTO> borrow(@RequestBody BorrowDTO borrowDTO) throws ParseException {
        return new ResponseEntity<>(applicationService.borrow(borrowDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/borrower/{name}", method = RequestMethod.POST)
    public ResponseEntity<Borrower> addBorrower(@PathVariable String name){
        return new ResponseEntity<Borrower>(applicationService.save(name), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<BorrowerDTO>> getUsers(){
        return new ResponseEntity<List<BorrowerDTO>>(applicationService.getUsers(), HttpStatus.OK);
    }
}
