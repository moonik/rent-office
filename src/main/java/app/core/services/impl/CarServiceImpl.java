package app.core.services.impl;

import app.core.asm.CarAsm;
import app.core.dto.CarDTO;
import app.core.models.entities.Car;
import app.core.repositories.CarRepository;
import app.core.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarAsm carAsm;

    @Override
    public CarDTO saveCar(CarDTO carDTO) throws ParseException {
        Car car = carAsm.convertToCar(carDTO);
        carRepository.save(car);
        return carDTO;
    }
}
