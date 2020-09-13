package com.example.demo.exception;

public class CustomerDoesnotExist  extends RuntimeException{
    public CustomerDoesnotExist(String message) {
        super(message);
    }

    public CustomerDoesnotExist() {
    }

    public CustomerDoesnotExist(String message, Throwable cause) {
        super(message, cause);
    }
}
