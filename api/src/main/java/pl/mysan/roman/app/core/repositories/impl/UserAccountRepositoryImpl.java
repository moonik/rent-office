package pl.mysan.roman.app.core.repositories.impl;

import org.springframework.stereotype.Repository;
import pl.mysan.roman.app.core.models.entities.UserAccount;
import pl.mysan.roman.app.core.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserAccountRepositoryImpl implements UserRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserAccount findByUsername(String username) {
        Query query = em.createQuery("select a from UserAccount a where a.username=?1");
        query.setParameter(1, username);
        List<UserAccount> accounts = query.getResultList();
        if(accounts.size() > 0){
            return accounts.get(0);
        }else
            return null;
    }

    @Override
    public void save(UserAccount userAccount) {
        em.persist(userAccount);
    }
}
