package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.models.UserRegistrationDto;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.google.common.base.Strings;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean register(UserRegistrationDto userRegistrationDto) {
        if (userRegistrationDto == null ||
                Strings.isNullOrEmpty(userRegistrationDto.getNickname()) ||
                userRegistrationDto.getPassword().isEmpty() ||
                userRegistrationDto.getEmail().isEmpty()) {
            return false;
        }

        userRegistrationDto.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));

        User user = User.from(userRegistrationDto);
        var role=roleRepository.findById(1L).orElseThrow();
        user.setRoles(Set.of(role));
        userRepository.save(user);
        return true;
    }
}
