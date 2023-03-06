package cl.janodevg.ms.mscustomer.services;

import cl.janodevg.ms.mscustomer.models.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
