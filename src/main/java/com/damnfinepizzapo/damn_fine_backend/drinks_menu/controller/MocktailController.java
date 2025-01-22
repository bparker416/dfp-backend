package com.damnfinepizzapo.damn_fine_backend.drinks_menu.controller;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Mocktail;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.service.MocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/mocktails")
@CrossOrigin(origins = "https://bparker416.github.io/dfp-website")
public class MocktailController {

    private final MocktailService mocktailService;

    @Autowired
    public MocktailController(MocktailService mocktailService) { this.mocktailService = mocktailService; }

    @GetMapping("/all")
    public List<Mocktail> getAllMocktails() { return mocktailService.getAllMocktails(); }

    @GetMapping("/active")
    public List<Mocktail> getActiveMocktails() { return mocktailService.getAllActiveMocktails(); }

    @PostMapping
    public Mocktail createMocktail(@RequestBody Mocktail mocktail) {
        return mocktailService.createMocktail(mocktail);
    }

    @GetMapping("/{id}")
    public Mocktail getMocktailById(@PathVariable int id) {
        return mocktailService.getMocktailById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Mocktail updateMocktail(@PathVariable int id, @RequestBody Mocktail mocktail) {
        return mocktailService.updateMocktail(id, mocktail);
    }

    @DeleteMapping("/{id}")
    public void deleteMocktail(@PathVariable int id) {
        mocktailService.deleteMocktail(id);
    }

    // End for isActive toggle
    @PutMapping("/{id}/toggle")
    public Mocktail toggleMocktailActive(@PathVariable int id) { return mocktailService.toggleMocktailActive(id); }
}