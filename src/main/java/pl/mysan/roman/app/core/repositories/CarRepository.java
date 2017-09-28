package pl.mysan.roman.app.core.repositories;

import pl.mysan.roman.app.core.models.entities.Car;

public interface CarRepository{
    Car save(Car car);
    Car findOne(Long id);
}
