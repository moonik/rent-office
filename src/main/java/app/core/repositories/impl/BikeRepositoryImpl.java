package app.core.repositories.impl;

import app.core.models.entities.Bike;
import app.core.repositories.BikeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BikeRepositoryImpl implements BikeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Bike save(Bike bike) {
        em.persist(bike);
        return bike;
    }
}
