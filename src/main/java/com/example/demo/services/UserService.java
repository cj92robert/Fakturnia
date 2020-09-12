package com.example.demo.services;

import com.example.demo.models.user.Role;
import com.example.demo.models.user.User;
import com.example.demo.models.user.UserRegistrationDto;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

        userRegistrationDto.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));

        User user = User.from(userRegistrationDto);

        Role student = new Role("Student", Collections.emptySet());
        if (!roleRepository.existsById(1L))
            student = roleRepository.save(student);
        var role = roleRepository.findById(1L).orElse(student);
        user.setRoles(Set.of(role));
        userRepository.save(user);

        return true;
    }
}
