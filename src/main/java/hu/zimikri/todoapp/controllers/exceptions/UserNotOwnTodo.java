package hu.zimikri.todoapp.controllers.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotOwnTodo extends ApiException {

    public UserNotOwnTodo() {
        super("It's not your todo.");
        setHttpStatus(HttpStatus.FORBIDDEN);
    }
}
