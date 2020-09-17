package hu.zimikri.todoapp.controllers.exceptions;

import org.springframework.http.HttpStatus;

public class TodoNotFoundException extends ApiException {

    public TodoNotFoundException() {
        super("No such todoId.");
        setHttpStatus(HttpStatus.BAD_REQUEST);
    }
}
