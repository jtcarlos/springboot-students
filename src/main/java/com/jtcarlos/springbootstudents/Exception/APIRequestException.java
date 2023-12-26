package com.jtcarlos.springbootstudents.Exception;

public class APIRequestException extends RuntimeException{
    public APIRequestException(String message) { super(message); }
    public APIRequestException(String message, Throwable cause) { super(message, cause); }
}
