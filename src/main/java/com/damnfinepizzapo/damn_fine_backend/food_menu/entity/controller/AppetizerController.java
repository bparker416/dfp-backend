package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Appetizer;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.AppetizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "http://localhost:4200")
public class AppetizerController {

    private final AppetizerService appetizerService;

    @Autowired
    public AppetizerController(AppetizerService appetizerService) { this.appetizerService = appetizerService; }

    @GetMapping("/appetizer")
    public List<Appetizer> getAllAppetizer() { return appetizerService.getAllAppetizer(); }

    @PostMapping
    public Appetizer createAppetizer(@RequestBody Appetizer appetizer) {
        return appetizerService.createAppetizer(appetizer);
    }

    @GetMapping("/{id}")
    public Appetizer getAppetizerById(@PathVariable int id) {
        return appetizerService.getAppetizerById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Appetizer updateAppetizer(@PathVariable int id, @RequestBody Appetizer appetizer) {
        return appetizerService.updateAppetizer(id, appetizer);
    }

    @DeleteMapping("/{id}")
    public void deleteAppetizer(@PathVariable int id) {
        appetizerService.deleteAppetizer(id);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Appetizer toggleAppetizerActive(@PathVariable int id) {
        return appetizerService.toggleAppetizerActive(id);
    }

}