package hu.zimikri.todoapp.controllers.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidArgumentException extends ApiException {

    public InvalidArgumentException() {
        super("Invalid argument.");
        setHttpStatus(HttpStatus.BAD_REQUEST);
    }
}
