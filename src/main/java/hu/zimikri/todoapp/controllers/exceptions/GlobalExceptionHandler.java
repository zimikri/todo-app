package hu.zimikri.todoapp.controllers.exceptions;

import hu.zimikri.todoapp.models.ApiStatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            UserNotFoundException.class,
            TodoNotFoundException.class,
            UserNotOwnTodo.class
    })
    public final ResponseEntity<ApiStatusDto> handleExceptions(ApiException apiException) {
        return ResponseEntity
                .status(apiException.getHttpStatus())
                .body(ApiStatusDto.error(apiException.getMessage()));
    }
}
