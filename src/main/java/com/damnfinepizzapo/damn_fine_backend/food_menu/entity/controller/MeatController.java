package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Meat;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.MeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/meat")
@CrossOrigin(origins = "http://localhost:4200")
public class MeatController {

    private final MeatService meatService;

    @Autowired
    public MeatController(MeatService meatService) { this.meatService = meatService; }

    @GetMapping("all")
    public List<Meat> getAllMeat() { return meatService.getAllMeat(); }

    @GetMapping("/active")
    public List<Meat> getActiveMeat() { return meatService.getAllActiveMeat(); }

    @GetMapping("price-is-three")
    public List<Meat> findByPriceIsThree() { return meatService.findByPriceIsThree(); }

    @GetMapping("price-is-four")
    public List<Meat> findByPriceIsFour() { return meatService.findByPriceIsFour(); }

    @PostMapping
    public Meat createMeat(@RequestBody Meat meat) {
        return meatService.createMeat(meat);
    }

    @GetMapping("/{id}")
    public Meat getMeatById(@PathVariable int id) {
        return meatService.getMeatById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Meat updateMeat(@PathVariable int id, @RequestBody Meat meat) {
        return meatService.updateMeat(id, meat);
    }

    @DeleteMapping("/{id}")
    public void deleteMeat(@PathVariable int id) {
        meatService.deleteMeat(id);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Meat toggleMeatActive(@PathVariable int id) {
        return meatService.toggleMeatActive(id);
    }

}