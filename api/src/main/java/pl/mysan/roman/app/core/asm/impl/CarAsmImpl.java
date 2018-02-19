package pl.mysan.roman.app.core.asm.impl;

import pl.mysan.roman.app.core.asm.VehicleAsm;
import pl.mysan.roman.app.core.dto.CarDTO;
import pl.mysan.roman.app.core.models.entities.Car;
import org.springframework.stereotype.Component;

@Component
public class CarAsmImpl implements VehicleAsm<Car, CarDTO> {

    @Override
    public Car convertToEntityObject(CarDTO dto) {
        Car car = new Car();
        car.setColor(dto.getColor());
        car.setName(dto.getName());
        car.setProducent(dto.getProducent());
        car.setReleaseDate(dto.getReleaseDate());
        return car;
    }

    @Override
    public CarDTO convertToDtoObject(Car entityObject) {
        CarDTO carDTO = new CarDTO();
        carDTO.setColor(entityObject.getColor());
        carDTO.setName(entityObject.getName());
        carDTO.setProducent(entityObject.getProducent());
        carDTO.setReleaseDate(entityObject.getReleaseDate());
        return carDTO;
    }
}