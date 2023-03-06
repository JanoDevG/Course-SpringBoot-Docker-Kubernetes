package cl.janodevg.ms.mscustomer.repositories;

import cl.janodevg.ms.mscustomer.models.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
