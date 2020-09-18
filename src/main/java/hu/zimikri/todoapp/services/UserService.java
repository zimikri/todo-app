package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.models.Entities.User;
import hu.zimikri.todoapp.models.dtos.UserDTO;
import hu.zimikri.todoapp.models.dtos.UserMinDTO;

import java.util.List;

public interface UserService {
    List<UserMinDTO> findAllUsers() throws RuntimeException;
    UserDTO findUserById(long id) throws RuntimeException;
    UserMinDTO saveNewUser(User user) throws RuntimeException;
}
