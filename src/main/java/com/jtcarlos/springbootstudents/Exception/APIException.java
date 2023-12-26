package com.jtcarlos.springbootstudents.Exception;

import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;


public class APIException {
    private String message;
    private HttpStatus status;
    private Integer code;
    private ZonedDateTime timestamp;
    private Throwable stack;

    public APIException(String message, HttpStatus status, Throwable stack) {
        this.message = message;
        this.status = status;
        this.stack = stack;

        this.code = status.value();
        this.timestamp = ZonedDateTime.now(ZoneId.of("Z"));
    }

    public String getMessage() { return this.message; }
    public HttpStatus getStatus() { return this.status; }
    public Integer getCode() { return this.code; }
    public ZonedDateTime getTimestamp() { return this.timestamp; }
    public Throwable getStack() { return this.stack; }
}
