package pl.mysan.roman.app.core.services.impl;

import pl.mysan.roman.app.core.asm.VehicleAsm;
import pl.mysan.roman.app.core.dto.CarDTO;
import pl.mysan.roman.app.core.exception.NotFoundException;
import pl.mysan.roman.app.core.models.entities.Car;
import pl.mysan.roman.app.core.repositories.CarRepository;
import pl.mysan.roman.app.core.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private VehicleAsm<Car, CarDTO> carAsm;

    @Override
    public CarDTO saveCar(CarDTO carDTO){
        carRepository.save(carAsm.convertToEntityObject(carDTO));
        return carDTO;
    }

    @Override
    public CarDTO editCar(Long id, CarDTO carDTO){
        Car car = carRepository.findOne(id);
        if(car != null){
            car.edit(carDTO);
            return carAsm.convertToDtoObject(carRepository.save(car));
        }else
            throw new NotFoundException(id);
    }
}
