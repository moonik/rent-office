package app.core.repositories.impl;

import app.core.models.entities.Vehicle;
import app.core.repositories.VehicleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Vehicle save(Vehicle vehicle) {
        em.persist(vehicle);
        return vehicle;
    }
}
