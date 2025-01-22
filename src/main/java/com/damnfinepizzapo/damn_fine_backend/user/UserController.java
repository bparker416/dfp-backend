package com.damnfinepizzapo.damn_fine_backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
@CrossOrigin("https://gray-sand-09b550110.4.azurestaticapps.net")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) throws IllegalAccessException {
        userService.registerUser(username, password);
        return "Success!";
    }
}
