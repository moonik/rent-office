package pl.mysan.roman.app.core.repositories.impl;

import pl.mysan.roman.app.core.models.entities.*;
import pl.mysan.roman.app.core.repositories.ApplicationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Vehicle save(Vehicle vehicle) {
        em.persist(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle getVehicle(Long id) {
        return em.find(Vehicle.class, id);
    }

    @Override
    public List<Vehicle> getAll() {
        Query query = em.createQuery("SELECT v FROM Vehicle v");
        return query.getResultList();
    }

    @Override
    public void delete(Long id) {
        em.remove(em.find(Vehicle.class, id));
    }

    @Override
    public Borrow borrow(Borrow borrow) {
        em.persist(borrow);
        return borrow;
    }

    @Override
    public Borrow getBorrowInfo(String date, Vehicle vehicle) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Query query = em.createQuery("SELECT b FROM Borrow b where b.borrowDate = ?1 AND b.vehicle = ?2");
        query.setParameter(1, format.parse(date));
        query.setParameter(2, vehicle);
        return query.getResultList().size() > 0 ? (Borrow)query.getResultList().get(0) : null;
    }

    @Override
    public void unborrow(Vehicle vehicle, String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Query query = em.createQuery("SELECT b FROM Borrow b where b.borrowDate = ?1 AND b.vehicle = ?2");
        query.setParameter(1, format.parse(date));
        query.setParameter(2, vehicle);
        em.remove(query.getResultList().get(0));
    }

    @Override
    public Boolean ifExists(Long id) {
        return em.find(Vehicle.class, id) != null;
    }

    @Override
    public Authority getAuthority() {
        Query query = em.createQuery("SELECT a from Authority a where a.name='ROLE_USER'");
        return (Authority) query.getResultList().get(0);
    }


}
