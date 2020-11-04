package com.example.demo.services;

import com.example.demo.exception.EmailAlreadyExistInDatabaseException;
import com.example.demo.exception.UsernameAlreadyExistInDatabaseException;
import com.example.demo.models.user.Role;
import com.example.demo.models.user.User;
import com.example.demo.models.user.UserRegistrationDto;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;

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


    @Transactional
    public boolean register(UserRegistrationDto userRegistrationDto) {

        userRegistrationDto.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));

        if (userRepository.existsByUsername(userRegistrationDto.getNickname()))
            throw new UsernameAlreadyExistInDatabaseException("Username already exist.");

        if (userRepository.existsByEmail(userRegistrationDto.getEmail()))
            throw new EmailAlreadyExistInDatabaseException("Email already exist.");

        User user = User.from(userRegistrationDto);


        var role = roleRepository.findById(1L);
        if (role.isEmpty()) {

            Role role1 = new Role("User", new HashSet<>());
            roleRepository.save(role1);
            role = Optional.of(role1);
        }
        user.setRoles(new HashSet<>());
        user.getRoles().add(role.get());
        userRepository.save(user);

        return true;
    }
}
