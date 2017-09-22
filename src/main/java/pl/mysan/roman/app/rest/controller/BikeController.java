package pl.mysan.roman.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mysan.roman.app.core.dto.BikeDTO;
import pl.mysan.roman.app.core.services.BikeService;

@RestController
@RequestMapping("/api/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<BikeDTO> save(@RequestBody BikeDTO bikeDTO){
        return new ResponseEntity<>(bikeService.save(bikeDTO), HttpStatus.OK);
    }
}
