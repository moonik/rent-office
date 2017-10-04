package pl.mysan.roman.app.core.asm.impl;

import pl.mysan.roman.app.core.asm.CarAsm;
import pl.mysan.roman.app.core.dto.CarDTO;
import pl.mysan.roman.app.core.models.entities.Car;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Component
public class CarAsmImpl implements CarAsm {
    @Override
    public Car convertToCar(CarDTO carDTO) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Date date = format.parse(carDTO.getReleaseDate());
        Car car = new Car();
        car.setColor(carDTO.getColor());
        car.setName(carDTO.getName());
        car.setProducent(carDTO.getProducent());
        car.setReleaseDate(date);
        return car;
    }

    @Override
    public CarDTO convertToDto(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setColor(car.getColor());
        carDTO.setName(car.getName());
        carDTO.setProducent(car.getProducent());
        carDTO.setReleaseDate(car.getReleaseDate().toString());
        return carDTO;
    }
}
