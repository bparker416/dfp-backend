package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Cheese;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.CheeseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Need to updateDrink get mapping to group and return by cheese_price

@RestController
@RequestMapping("/api/public/cheese")
@CrossOrigin(origins = "https://dfp-website.vercel.app/")
public class CheeseController {

    private final CheeseService cheeseService;

    @Autowired
    public CheeseController(CheeseService cheeseService) {this.cheeseService = cheeseService;}

    @GetMapping("/all")
    public List<Cheese> getAllCheese() { return this.cheeseService.getAllCheese(); }

    @GetMapping("/active")
    public List<Cheese> getAllActiveCheese() { return this.cheeseService.getAllActiveCheese(); }

    @GetMapping("/price-is-regular")
    public List<Cheese> findByPriceIsRegular() {return cheeseService.findByPriceIsRegular();}

    @GetMapping("/price-is-one")
    public List<Cheese> findByPriceIsOne() {return cheeseService.findByPriceIsOne();}

    @GetMapping("price-is-two")
    public List<Cheese> findByPriceIsTwo() {return cheeseService.findByPriceIsTwo();}

    @PostMapping
    public Cheese createCheese(@RequestBody Cheese cheese) {
        return cheeseService.createCheese(cheese);
    }

    @GetMapping("/{id}")
    Cheese getCheeseById(@PathVariable int id) {
        return cheeseService.getCheeseById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Cheese updateCheese(@PathVariable int id, @RequestBody Cheese cheese) {
        return cheeseService.updateCheese(id, cheese);
    }

    @DeleteMapping("/{id}")
    public void deleteCheese(@PathVariable int id) {
        cheeseService.deleteCheese(id);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Cheese toggleCheeseActive(@PathVariable int id) { return cheeseService.toggleCheeseActive(id); }
}