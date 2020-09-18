package hu.zimikri.todoapp.controllers;

import hu.zimikri.todoapp.models.Entities.User;
import hu.zimikri.todoapp.models.dtos.UserDTO;
import hu.zimikri.todoapp.models.dtos.UserMinDTO;
import hu.zimikri.todoapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserMinDTO>> getUsers() throws RuntimeException{

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAllUsers());
    }

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long userId)
            throws RuntimeException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findUserById(userId));
    }

    @PostMapping("/api/users")
    public ResponseEntity<UserMinDTO> addNewUser(@RequestBody User user)
            throws RuntimeException {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.saveNewUser(user));
    }
}
