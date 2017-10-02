package pl.mysan.roman.app.core.repositories;


import pl.mysan.roman.app.core.models.entities.Bike;

public interface BikeRepository {
    Bike save(Bike bike);
}
