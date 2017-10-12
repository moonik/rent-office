package pl.mysan.roman.app.core.repositories;

import pl.mysan.roman.app.core.models.entities.UserAccount;

public interface UserRepository{
    UserAccount findByUsername(String username);
    void save(UserAccount userAccount);
}
