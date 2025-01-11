package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.PizzaService;

import java.util.List;

@RestController
@RequestMapping("/api/public/pizza")
@CrossOrigin(origins = "http://localhost:4200")
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/all")
    public List<Pizza> getAllPizza() {
        return pizzaService.getAllPizza();
    }

    @GetMapping("/active")
    public List<Pizza> getActivePizza() { return pizzaService.getAllActivePizza(); }

    @PostMapping
    public Pizza createPizza(@RequestBody Pizza pizza) {
        return pizzaService.createPizza(pizza);
    }

    @GetMapping("/{id}")
    public Pizza getPizzaById(@PathVariable int id) {
        return pizzaService.getPizzaById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Pizza updatePizza(@PathVariable int id, @RequestBody Pizza pizza) {
        return pizzaService.updatePizza(id, pizza);
    }

    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable int id) {
        pizzaService.deletePizza(id);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Pizza togglePizzaActive(@PathVariable int id) {
        return pizzaService.togglePizzaActive(id);
    }

    @GetMapping("/search")
    public List<Pizza> searchPizza(@RequestParam String pizzaName) {
        return pizzaService.searchPizza(pizzaName);
    }
}