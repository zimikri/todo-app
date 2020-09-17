package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.controllers.exceptions.UserNotFoundException;
import hu.zimikri.todoapp.models.Todo;
import hu.zimikri.todoapp.models.User;
import hu.zimikri.todoapp.models.UserTodosDto;
import hu.zimikri.todoapp.repositories.TodoRepository;
import hu.zimikri.todoapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public UserTodosDto findUserById(long id) throws UserNotFoundException {
        User user = userRepository.findUserById(id);
        if (user == null) throw new UserNotFoundException();

        return new UserTodosDto(
                        user.getId(),
                        user.getUsername(),
                        todoRepository.findAllByUserId(id));

//        return Optional.of(userRepository.findUserById(id))
//                .map(user -> new UserTodosDto(
//                        user.getId(),
//                        user.getUsername(),
//                        todoRepository.findAllByUserId(id)))
//                .orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public User saveNewUser(User user) {
        return userRepository.save(user);
    }
}
