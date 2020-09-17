package hu.zimikri.todoapp.controllers.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends ApiException {

    public UserAlreadyExistsException() {
        super("Username in use.");
        setHttpStatus(HttpStatus.BAD_REQUEST);
    }
}
