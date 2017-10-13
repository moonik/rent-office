package pl.mysan.roman.app.rest.controller;

import org.springframework.web.bind.annotation.*;
import pl.mysan.roman.app.core.dto.BorrowDTO;
import pl.mysan.roman.app.core.dto.BorrowerDTO;
import pl.mysan.roman.app.core.dto.VehicleDTO;
import pl.mysan.roman.app.core.models.entities.Borrower;
import pl.mysan.roman.app.core.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rent-office")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/details/{id}/{date}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public VehicleDTO getDetails(@PathVariable Long id, @PathVariable String date) throws ParseException {
        return applicationService.getVehicle(id, date);
    }

    @RequestMapping(value = {"", "/{date}"}, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<VehicleDTO> showAll(@PathVariable Optional<String> date) {
        if(date.isPresent()){
            return applicationService.getAllWithBorrowDate(date.get());
        }else
            return applicationService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        applicationService.delete(id);
    }

    @RequestMapping(value = "/borrow", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public BorrowDTO borrow(@RequestBody BorrowDTO borrowDTO) throws ParseException {
        return applicationService.borrow(borrowDTO);
    }

    @RequestMapping(value = "/borrower/{name}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Borrower addBorrower(@PathVariable String name){
        return applicationService.save(name);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<BorrowerDTO> getUsers(){
        return applicationService.getUsers();
    }

    @RequestMapping(value = "unborrow/{id}/{date}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void unborrow(@PathVariable Long id, @PathVariable String date) throws ParseException {
        applicationService.unborrow(id, date);
    }
}
