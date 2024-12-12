package com.damnfinepizzapo.damn_fine_backend.authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Home page.";
    }

    @GetMapping("/login")
    public String login() {
        return "Login page.";
    }

    @GetMapping("/updates")
    public String updatePage() {
        return "Updates page.";
    }

}
