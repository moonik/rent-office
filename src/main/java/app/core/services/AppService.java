package app.core.services;

import app.core.dto.CarDTO;

import java.text.ParseException;

public interface AppService {

    CarDTO saveCar(CarDTO carDTO) throws ParseException;
}
