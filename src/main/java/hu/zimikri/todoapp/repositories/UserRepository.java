package hu.zimikri.todoapp.repositories;

import hu.zimikri.todoapp.models.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    User findUserById(long id);
    boolean existsUserById(long id);
    User findUserByUsername(String username);
}
