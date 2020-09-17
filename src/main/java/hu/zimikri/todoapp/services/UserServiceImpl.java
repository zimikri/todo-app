package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.controllers.exceptions.ApiException;
import hu.zimikri.todoapp.controllers.exceptions.UserAlreadyExistsException;
import hu.zimikri.todoapp.controllers.exceptions.UserNotFoundException;
import hu.zimikri.todoapp.models.Entities.User;
import hu.zimikri.todoapp.models.dtos.UserDTO;
import hu.zimikri.todoapp.repositories.TodoRepository;
import hu.zimikri.todoapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public UserRepository userRepository;
    public TodoRepository todoRepository;

    public UserServiceImpl(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO findUserById(long id) throws UserNotFoundException {
        User user = userRepository.findUserById(id);
        if (user == null) throw new UserNotFoundException();

        return new UserDTO(
                        user.getId(),
                        user.getUsername(),
                        todoRepository.findAllByUserId(id));
    }

    @Override
    public User saveNewUser(User user) throws ApiException {
        User existingUser = userRepository.findUserByUsername(user.getUsername());
        if (existingUser != null) throw new UserAlreadyExistsException();
        return userRepository.save(user);
    }
}
