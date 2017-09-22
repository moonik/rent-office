package pl.mysan.roman.app.core.services;

import pl.mysan.roman.app.core.dto.CarDTO;

import java.text.ParseException;

public interface CarService {
    CarDTO saveCar(CarDTO carDTO) throws ParseException;
}
