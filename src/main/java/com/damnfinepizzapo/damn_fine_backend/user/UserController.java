package com.damnfinepizzapo.damn_fine_backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
@CrossOrigin("https://dfp-website-git-main-brandons-projects-bc9e4d60.vercel.app/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) throws IllegalAccessException {
        userService.registerUser(username, password);
        return "Success!";
    }
}
