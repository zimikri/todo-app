package hu.zimikri.todoapp.repositories;

import hu.zimikri.todoapp.controllers.exceptions.UserNotFoundException;
import hu.zimikri.todoapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    User findUserById(long id);
    boolean existsUserById(long id);
}
