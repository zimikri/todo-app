package hu.zimikri.todoapp.controllers.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ApiException {

    public UserNotFoundException() {
        super("No such userId.");
        setHttpStatus(HttpStatus.BAD_REQUEST);
    }
}
