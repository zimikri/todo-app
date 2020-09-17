package hu.zimikri.todoapp.controllers.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotOwnTodoException extends ApiException {

    public UserNotOwnTodoException() {
        super("It's not your todo.");
        setHttpStatus(HttpStatus.FORBIDDEN);
    }
}
