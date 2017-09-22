package pl.mysan.roman.app.core.asm;

import pl.mysan.roman.app.core.dto.CarDTO;
import pl.mysan.roman.app.core.models.entities.Car;

import java.text.ParseException;

public interface CarAsm {
    Car convertToCar(CarDTO carDTO) throws ParseException;
    CarDTO convertToDto(Car car);
}
