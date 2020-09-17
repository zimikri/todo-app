package hu.zimikri.todoapp.controllers;

import hu.zimikri.todoapp.controllers.exceptions.UserNotFoundException;
import hu.zimikri.todoapp.models.User;
import hu.zimikri.todoapp.models.UserTodosDto;
import hu.zimikri.todoapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<UserTodosDto> getUserById(@PathVariable long userId)
            throws UserNotFoundException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findUserById(userId));
    }

    @PostMapping("/api/users")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.saveNewUser(user));
    }
}
