package com.example.demo.exception;

public class UsernameAlreadyExistInDatabaseException extends RuntimeException {
    public UsernameAlreadyExistInDatabaseException(String message) {
        super(message);
    }

    public UsernameAlreadyExistInDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
