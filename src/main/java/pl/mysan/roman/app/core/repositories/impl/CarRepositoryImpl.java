package pl.mysan.roman.app.core.repositories.impl;

import pl.mysan.roman.app.core.models.entities.Car;
import pl.mysan.roman.app.core.repositories.CarRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CarRepositoryImpl implements CarRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Car save(Car car) {
        em.persist(car);
        return car;
    }
}
