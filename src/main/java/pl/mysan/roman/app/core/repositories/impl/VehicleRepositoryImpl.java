package pl.mysan.roman.app.core.repositories.impl;

import pl.mysan.roman.app.core.models.entities.Vehicle;
import pl.mysan.roman.app.core.repositories.VehicleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Vehicle getVehicle(Long id) {
        return em.find(Vehicle.class, id);
    }

    @Override
    public List<Vehicle> getAll() {
        Query query = em.createQuery("SELECT v FROM Vehicle v");
        return query.getResultList();
    }
}
