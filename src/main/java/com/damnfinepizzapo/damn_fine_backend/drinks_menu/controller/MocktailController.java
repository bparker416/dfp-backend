package com.damnfinepizzapo.damn_fine_backend.drinks_menu.controller;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Mocktail;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.service.MocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class MocktailController {

    private final MocktailService mocktailService;

    @Autowired
    public MocktailController(MocktailService mocktailService) { this.mocktailService = mocktailService; }

    @GetMapping("/mocktails")
    public List<Mocktail> getAllMocktails() { return mocktailService.getAllMocktails(); }
}