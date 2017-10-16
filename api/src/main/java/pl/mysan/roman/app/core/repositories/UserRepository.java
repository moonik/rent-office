package pl.mysan.roman.app.core.repositories;

import pl.mysan.roman.app.core.models.entities.UserAccount;

import java.util.List;

public interface UserRepository{
    UserAccount findByUsername(String username);
    void save(UserAccount userAccount);
    void delete(Long id);
    List<UserAccount> getUsers();
}
