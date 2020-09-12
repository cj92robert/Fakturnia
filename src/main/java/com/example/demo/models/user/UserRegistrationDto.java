package com.example.demo.models.user;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;


public class UserRegistrationDto {

    @NotNull
    @Size(min=6,message = "Login nie może być krotszy niż 6 znaków")
    @NotBlank
    private String nickname;
    @NotNull
    @Size(min=8, message = "Hasło musi się składać przynajmniej z 8 znaków")
    private String password;
    @NotNull
    @NotEmpty(message = "email cannot be empty.")
    @Email(message = "Adres mail nie poprawny")
    private String email;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String nickname, String password, String email) {
        this.nickname = nickname;
        this.password = password;

        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
