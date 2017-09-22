package app.core.asm;

import app.core.dto.CarDTO;
import app.core.models.entities.Car;
import org.springframework.stereotype.Component;

import java.text.ParseException;

public interface CarAsm {

    Car convertToCar(CarDTO carDTO) throws ParseException;
}
