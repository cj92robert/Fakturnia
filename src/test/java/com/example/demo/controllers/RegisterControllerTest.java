package com.example.demo.controllers;

import com.example.demo.models.Error;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


class RegisterControllerTest {

    @MockBean
    UserService userService;

    RegisterController registerController;

    @BeforeEach
    void setUp() {
        registerController = new RegisterController(userService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void signup() {
    }


    @Test
    void UsernameAlreadyExistHandlerShouldReturnObjectErrorWithInformation() {

        var response = new ResponseEntity<>(new Error("User already exist in database"), HttpStatus.valueOf(500));

        assertThat(registerController.handlerUsernameAlreadyExist()).isEqualTo(response);
    }

    @Test
    void EmailAlreadyExistHandlerShouldReturnObjectErrorWithInformation() {

        var response = new ResponseEntity<>(new Error("Email already exist in database"), HttpStatus.valueOf(500));

        assertThat(registerController.handlerEmailAlreadyExist()).isEqualTo(response);
    }
}
