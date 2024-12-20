package com.damnfinepizzapo.damn_fine_backend;

import com.damnfinepizzapo.damn_fine_backend.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    private final UserService userService;

    public DataSeeder(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        try {
            userService.registerUser("test", "password");
            System.out.println("Created");
        } catch (IllegalAccessException exception) {
            System.out.println("User already exists");
        }
    }
}
