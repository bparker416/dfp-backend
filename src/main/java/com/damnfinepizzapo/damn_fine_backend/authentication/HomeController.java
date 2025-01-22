package com.damnfinepizzapo.damn_fine_backend.authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://bparker416.github.io/dfp-website")
public class HomeController {

    @GetMapping("/public/home")
    public String home() {
        return "Home page.";
    }

    @GetMapping("/public/login")
    public String login() {
        return "Login page.";
    }


    @GetMapping("/updates")
    public String updatesPage() {
        return "Updates page.";
    }

    @GetMapping("/public/desserts")
    public String dessertPage() {
        return "Desserts page.";
    }

}