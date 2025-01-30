package com.damnfinepizzapo.damn_fine_backend.drinks_menu.controller;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Drink;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/drinks")
@CrossOrigin(origins = "https://dfp-website.vercel.app/")
public class DrinkController {

    private final DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService) { this.drinkService = drinkService;
    }

    @GetMapping("/all")
    public List<Drink> getAllDrinks() { return drinkService.getAllDrinks(); }

    @GetMapping("/active")
    public List<Drink> getActiveDrinks() { return drinkService.getAllActiveDrinks(); }

    @PostMapping
    public Drink createDrink(@RequestBody Drink drink) {
        return drinkService.createDrink(drink);
    }

    @GetMapping("/{id}")
    public Drink getDrinkById(@PathVariable int id) {
        return drinkService.getDrinkById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Drink updateDrink(@PathVariable int id, @RequestBody Drink drink) {
        return drinkService.updateDrink(id, drink);
    }

    @DeleteMapping("/{id}")
    public void deleteDrink(@PathVariable int id) {
        drinkService.deleteDrink(id);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Drink toggleDrinkActive(@PathVariable int id) {
        return drinkService.toggleDrinkActive(id);
    }
}