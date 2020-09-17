package hu.zimikri.todoapp.repositories;

import hu.zimikri.todoapp.models.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    Optional<User> findUserById(long id);
    boolean existsUserById(long id);
    boolean existsUserByUsername(String username);
}
