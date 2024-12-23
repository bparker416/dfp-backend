package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Veggie;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.VeggieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/veggie")
@CrossOrigin(origins = "http://localhost:4200")
public class VeggieController {

    private final VeggieService veggieService;

    @Autowired
    public VeggieController(VeggieService veggieService) { this.veggieService = veggieService; }

    @GetMapping
    public List<Veggie> getVeggies() { return veggieService.getAllVeggies(); }

    @PostMapping
    public Veggie createVeggie(@RequestBody Veggie veggie) {
        return veggieService.createVeggie(veggie);
    }

    @GetMapping("/{id}")
    public Veggie getVeggieById(@PathVariable int id) {
        return veggieService.getVeggieById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Veggie updateVeggie(@PathVariable int id, @RequestBody Veggie veggie) {
        return veggieService.updateVeggie(id, veggie);
    }

    @DeleteMapping("/{id}")
    public void deleteVeggie(@PathVariable int id) {
        veggieService.deleteVeggie(id);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Veggie toggleVeggieActive(@PathVariable int id) {
        return veggieService.toggleVeggieActive(id);
    }

}