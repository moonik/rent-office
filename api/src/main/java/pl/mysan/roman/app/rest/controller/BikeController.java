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

    @PostMapping(value = "/{number}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BikeDTO save(@PathVariable Long number){
        BikeDTO bikeDTO = new BikeDTO();
        bikeDTO.setNumber(number);
        return bikeService.save(bikeDTO);
    }
}
