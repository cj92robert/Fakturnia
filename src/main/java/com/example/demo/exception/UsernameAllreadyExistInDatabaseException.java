package com.example.demo.exception;

public class UsernameAllreadyExistInDatabaseException extends RuntimeException{
    public UsernameAllreadyExistInDatabaseException(String message) {
        super(message);
    }

    public UsernameAllreadyExistInDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
