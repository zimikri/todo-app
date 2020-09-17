package hu.zimikri.todoapp.controllers.exceptions;

import hu.zimikri.todoapp.models.dtos.ApiStatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            UserNotFoundException.class,
            TodoNotFoundException.class,
            UserNotOwnTodoException.class,
            UserAlreadyExistsException.class
    })
    public final ResponseEntity<ApiStatusDTO> handleExceptions(ApiException apiException) {
        return ResponseEntity
                .status(apiException.getHttpStatus())
                .body(ApiStatusDTO.error(apiException.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiStatusDTO> handleUnhandledExceptions(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiStatusDTO.error(ex.getMessage()));
    }

}
