package pl.mysan.roman.app.core.services.impl;

import pl.mysan.roman.app.core.asm.CarAsm;
import pl.mysan.roman.app.core.dto.CarDTO;
import pl.mysan.roman.app.core.models.entities.Car;
import pl.mysan.roman.app.core.repositories.CarRepository;
import pl.mysan.roman.app.core.services.CarService;
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
    public CarDTO saveCar(CarDTO carDTO){
        carRepository.save(carAsm.convertToCar(carDTO));
        return carDTO;
    }

    @Override
    public CarDTO editCar(Long id, CarDTO carDTO){
        Car car = carRepository.findOne(id);
        car.edit(carDTO);
        return carAsm.convertToDto(carRepository.save(car));
    }


}
