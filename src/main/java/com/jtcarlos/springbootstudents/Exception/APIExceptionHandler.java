package com.jtcarlos.springbootstudents.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler(value = {APIRequestException.class})
    public ResponseEntity<Object> handleAPIRequestException(APIRequestException exception) {
        HttpStatus exceptionStatus = HttpStatus.BAD_REQUEST;

        APIException apiException = new APIException(exception.getMessage(), exceptionStatus, exception);

        return new ResponseEntity<>(apiException, exceptionStatus);
    }
}
