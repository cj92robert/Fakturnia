package com.example.demo.controllers;


import com.example.demo.exception.EmailAlreadyExistInDatabaseException;
import com.example.demo.exception.UsernameAlreadyExistInDatabaseException;
import com.example.demo.models.Error;
import com.example.demo.models.user.UserRegistrationDto;
import com.example.demo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/signup/")
@Validated
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity signup(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {
        userService.register(userRegistrationDto);
        return new ResponseEntity(HttpStatus.OK);

    }

    @ExceptionHandler(UsernameAlreadyExistInDatabaseException.class)
    public ResponseEntity<Error> handlerUsernameAlreadyExist() {
        return new ResponseEntity<>(new Error("User already exist in database"),
                HttpStatus.valueOf(500));

    }

    @ExceptionHandler(EmailAlreadyExistInDatabaseException.class)
    public ResponseEntity<Error> handlerEmailAlreadyExist() {
        return new ResponseEntity<>(new Error("Email already exist in database"),
                HttpStatus.valueOf(500));
    }
}
