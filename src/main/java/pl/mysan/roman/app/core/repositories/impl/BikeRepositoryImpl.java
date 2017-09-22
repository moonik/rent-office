package pl.mysan.roman.app.core.repositories.impl;

import org.springframework.stereotype.Repository;
import pl.mysan.roman.app.core.models.entities.Bike;
import pl.mysan.roman.app.core.repositories.BikeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BikeRepositoryImpl implements BikeRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Bike save(Bike bike) {
        em.persist(bike);
        return bike;
    }
}
