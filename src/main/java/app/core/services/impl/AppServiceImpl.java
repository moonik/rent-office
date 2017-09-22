package app.core.services.impl;

import app.core.asm.CarAsm;
import app.core.dto.CarDTO;
import app.core.models.entities.Car;
import app.core.repositories.CarRepository;
import app.core.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

@Service
@Transactional
public class AppServiceImpl implements AppService {

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
