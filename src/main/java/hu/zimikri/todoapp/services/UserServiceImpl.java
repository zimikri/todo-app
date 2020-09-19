package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.controllers.exceptions.UserAlreadyExistsException;
import hu.zimikri.todoapp.controllers.exceptions.UserNotFoundException;
import hu.zimikri.todoapp.models.Entities.User;
import hu.zimikri.todoapp.models.dtos.UserDTO;
import hu.zimikri.todoapp.models.dtos.UserListDTO;
import hu.zimikri.todoapp.models.dtos.UserMinDTO;
import hu.zimikri.todoapp.repositories.TodoRepository;
import hu.zimikri.todoapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public UserRepository userRepository;
    public TodoRepository todoRepository;

    public UserServiceImpl(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @Override
    public UserListDTO findAllUsers() {
        return new UserListDTO(userRepository.findAll());
    }

    @Override
    public UserDTO findUserById(long id) throws UserNotFoundException {
        User user = userRepository.findUserById(id)
                .orElseThrow(UserNotFoundException::new);

        return new UserDTO(user, todoRepository.findAllByUserId(id));
    }

    @Override
    public UserMinDTO saveNewUser(User user) throws UserAlreadyExistsException {
        if (userRepository.existsUserByUsername(user.getUsername()))
            throw new UserAlreadyExistsException();

        return new UserMinDTO(userRepository.save(user));
    }
}
