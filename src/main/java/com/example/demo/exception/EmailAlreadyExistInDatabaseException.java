package com.example.demo.exception;

public class EmailAlreadyExistInDatabaseException extends RuntimeException {
    public EmailAlreadyExistInDatabaseException(String message) {
        super(message);
    }

    public EmailAlreadyExistInDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
