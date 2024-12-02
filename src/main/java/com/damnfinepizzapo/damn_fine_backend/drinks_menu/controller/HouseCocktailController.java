package com.damnfinepizzapo.damn_fine_backend.drinks_menu.controller;


import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.HouseCocktail;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.service.HouseCocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class HouseCocktailController {

    private final HouseCocktailService houseCocktailService;

    @Autowired
    public HouseCocktailController(HouseCocktailService houseCocktailService) { this.houseCocktailService = houseCocktailService; }

    @GetMapping("/house-cocktails")
    public List<HouseCocktail> getAllHouseCocktails() { return houseCocktailService.getAllHouseCocktails(); }
    }
