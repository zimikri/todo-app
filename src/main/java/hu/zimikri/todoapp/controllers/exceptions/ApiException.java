package hu.zimikri.todoapp.controllers.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception {

    private HttpStatus httpStatus;

    public ApiException(String message) {
        super(message);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
