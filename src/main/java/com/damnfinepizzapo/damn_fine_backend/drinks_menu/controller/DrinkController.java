package com.damnfinepizzapo.damn_fine_backend.drinks_menu.controller;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Drink;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.service.DrinkService;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Cheese;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.CheeseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/drinks")
@CrossOrigin(origins = "http://localhost:4200")
public class DrinkController {

    private final DrinkService drinkService;
    private final CheeseService cheeseService;

    @Autowired
    public DrinkController(DrinkService drinkService, CheeseService cheeseService) { this.drinkService = drinkService;
        this.cheeseService = cheeseService;
    }

    @GetMapping
    public List<Drink> getAllDrinks() { return drinkService.getAllDrinks(); }

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
    public void updateCheese(@PathVariable int id, @RequestBody Cheese cheese) {
        cheeseService.updateCheese(id, cheese);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Drink toggleDrinkActive(@PathVariable int id) {
        return drinkService.toggleDrinkActive(id);
    }

}