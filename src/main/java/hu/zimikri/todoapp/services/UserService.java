package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.controllers.exceptions.UserNotFoundException;
import hu.zimikri.todoapp.models.User;
import hu.zimikri.todoapp.models.UserTodosDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();

    UserTodosDto findUserById(long id) throws UserNotFoundException;

    User saveNewUser(User user);

}
