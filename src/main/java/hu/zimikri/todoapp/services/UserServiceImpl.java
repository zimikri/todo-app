package hu.zimikri.todoapp.services;

import hu.zimikri.todoapp.models.User;
import hu.zimikri.todoapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    public UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        Optional<User> userOptional = userRepository.findUserById(id);
        return userOptional.orElseGet(User::new);
    }

    @Override
    public User saveNewUser(User user) {
        return userRepository.save(user);
    }
}
