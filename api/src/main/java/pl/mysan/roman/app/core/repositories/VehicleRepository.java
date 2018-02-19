package pl.mysan.roman.app.core.repositories;

import pl.mysan.roman.app.core.models.entities.Vehicle;

import java.util.List;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
    Vehicle getVehicle(Long id);
    List<Vehicle> getAll();
    void delete(Long id);
}