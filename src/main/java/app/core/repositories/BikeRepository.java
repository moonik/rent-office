package app.core.repositories;

import app.core.models.entities.Bike;

public interface BikeRepository {
    Bike save(Bike bike);
}
