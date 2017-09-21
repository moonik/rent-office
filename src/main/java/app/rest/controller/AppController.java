package app.rest.controller;

import app.core.models.entities.Bike;
import app.core.models.entities.Vehicle;
import app.core.repositories.BikeRepository;
import app.core.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class AppController {

    @PersistenceContext
    private EntityManager em;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<Bike> save(){
        Bike bike = new Bike();
        em.persist(bike);
        return new ResponseEntity<Bike>(bike, HttpStatus.OK);
    }
}
