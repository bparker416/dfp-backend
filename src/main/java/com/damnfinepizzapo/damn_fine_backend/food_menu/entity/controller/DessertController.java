package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Dessert;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/dessert")
@CrossOrigin(origins = "http://localhost:4200")
public class DessertController {

    private final DessertService dessertService;

    @Autowired
    public DessertController(DessertService dessertService) { this.dessertService = dessertService; }

    @GetMapping("/all")
    public List<Dessert> getDesserts() { return dessertService.getAllDesserts(); }

    @GetMapping("/active")
    public List<Dessert> getDessertsActive() { return dessertService.getAllActiveDesserts(); }

    @PostMapping
    public Dessert createDessert(@RequestBody Dessert dessert) {
        return dessertService.createDessert(dessert);
    }

    @GetMapping("/{id}")
    public Dessert getDessertById(@PathVariable int id) {
        return dessertService.getDessertById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Dessert updateDessert(@PathVariable int id, @RequestBody Dessert dessert) {
        return dessertService.updateDessert(id, dessert);
    }

    @DeleteMapping("/{id}")
    public void deleteDessert(@PathVariable int id) {
        dessertService.deleteDessert(id);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Dessert toggleDessertActive(@PathVariable int id) {
        return dessertService.toggleDessertActive(id);
    }

    @GetMapping("/search")
    public List<Dessert> searchDessert(@RequestParam String dessertName) {
        return dessertService.searchDessert(dessertName);
    }
}