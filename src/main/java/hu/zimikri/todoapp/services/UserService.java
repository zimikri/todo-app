package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.controllers.exceptions.ApiException;
import hu.zimikri.todoapp.controllers.exceptions.UserNotFoundException;
import hu.zimikri.todoapp.models.Entities.User;
import hu.zimikri.todoapp.models.dtos.UserDTO;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    UserDTO findUserById(long id) throws UserNotFoundException;

    User saveNewUser(User user) throws ApiException;

}
