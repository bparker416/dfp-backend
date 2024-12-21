package com.damnfinepizzapo.damn_fine_backend.drinks_menu.controller;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Drink;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "http://localhost:4200")
public class DrinkController {

    private final DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService) { this.drinkService = drinkService; }

    @GetMapping("/drinks")
    public List<Drink> getAllDrinks() { return drinkService.getAllDrinks(); }

    @PostMapping
    public Drink create(@RequestBody Drink drink) {
        return drinkService.createDrink(drink);
    }

    @GetMapping("/{id}")
    public Drink getById(@PathVariable int id) {
        return drinkService.getDrinkById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Drink update(@PathVariable int id, @RequestBody Drink drink) {
        return drinkService.updateDrink(id, drink);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Drink toggleDrinkActive(@PathVariable int id) {
        return drinkService.toggleDrinkActive(id);
    }

}