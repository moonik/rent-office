package app.core.asm.impl;

import app.core.asm.CarAsm;
import app.core.dto.CarDTO;
import app.core.models.entities.Car;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class CarAsmImpl implements CarAsm {
    @Override
    public Car convertToCar(CarDTO carDTO) throws ParseException {
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
        Date date = format.parse(carDTO.getReleaseDate());
        Car car = new Car();
        car.setColor(carDTO.getColor());
        car.setName(carDTO.getName());
        car.setProducent(carDTO.getProducent());
        car.setReleaseDate(date);
        return car;
    }
}
