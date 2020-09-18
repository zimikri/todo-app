package hu.zimikri.todoapp.controllers.exceptions;

import hu.zimikri.todoapp.models.dtos.ApiStatusDTO;
import org.hibernate.JDBCException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            UserNotFoundException.class,
            TodoNotFoundException.class,
            UserNotOwnTodoException.class,
            UserAlreadyExistsException.class,
            InvalidArgumentException.class
    })
    public final ResponseEntity<ApiStatusDTO> handleExceptions(ApiException apiException) {
        return ResponseEntity
                .status(apiException.getHttpStatus())
                .body(ApiStatusDTO.error(apiException.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ApiStatusDTO> handleEmptyBodyExceptions(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiStatusDTO.error("You should provide data in body"));
    }

    @ExceptionHandler({
            DataAccessException.class,
            JDBCException.class
    })
    public final ResponseEntity<ApiStatusDTO> handleDbExceptions(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiStatusDTO.error("Database error"));
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiStatusDTO> handleUnhandledExceptions(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiStatusDTO.error(ex.getMessage()));
    }
}
