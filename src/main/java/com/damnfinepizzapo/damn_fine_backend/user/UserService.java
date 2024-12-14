package com.damnfinepizzapo.damn_fine_backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String username, String rawPassword) throws IllegalAccessException {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalAccessException("Name already exists@");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void updateUserPassword(String username, String newRawPassword) throws UsernameNotFoundException {
        Optional<User> userTemp = userRepository.findByUsername(username);
        if (userTemp.isEmpty()) {
            throw new UsernameNotFoundException("No username found!");
        }

        User user = userTemp.get();

        user.setPassword(passwordEncoder.encode(newRawPassword));

    }
}