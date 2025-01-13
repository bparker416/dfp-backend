package com.damnfinepizzapo.damn_fine_backend.drinks_menu.controller;


import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.HouseCocktail;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.service.HouseCocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/house-cocktails")
@CrossOrigin(origins = "http://localhost:4200")
public class HouseCocktailController {

    private final HouseCocktailService houseCocktailService;

    @Autowired
    public HouseCocktailController(HouseCocktailService houseCocktailService) { this.houseCocktailService = houseCocktailService; }

    @GetMapping("/all")
    public List<HouseCocktail> getAllHouseCocktails() { return houseCocktailService.getAllHouseCocktails(); }

    @GetMapping("/active")
    public List<HouseCocktail> getActiveHouseCocktails() { return houseCocktailService.getAllActiveHouseCocktails(); }

    @PostMapping
    public HouseCocktail createHouseCocktail(@RequestBody HouseCocktail houseCocktail) {
        return houseCocktailService.createHouseCocktail(houseCocktail);
    }

    @GetMapping("/{id}")
    public HouseCocktail getHouseCocktailById(@PathVariable int id) {
        return houseCocktailService.getHouseCocktailById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public HouseCocktail updateHouseCocktail(@PathVariable int id, @RequestBody HouseCocktail houseCocktail) {
        return houseCocktailService.updateHouseCocktail(id, houseCocktail);
    }

    @DeleteMapping("/{id}")
    public void deleteHouseCocktail(@PathVariable int id) {
        houseCocktailService.deleteHouseCocktail(id);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public HouseCocktail toggleHouseCocktailActive(@PathVariable int id) { return houseCocktailService.toggleHouseCocktailActive(id); }
}

