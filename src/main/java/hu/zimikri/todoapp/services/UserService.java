package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.models.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> findAllUsers();

    User findUserById(long id);

    User saveNewUser(User user);
}
