package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Sauce;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.SauceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/sauce")
@CrossOrigin(origins = "http://localhost:4200")
public class SauceController {

    private final SauceService sauceService;

    @Autowired
    public SauceController(SauceService sauceService) { this.sauceService = sauceService; }

    @GetMapping("/all")
    public List<Sauce> getSauces() { return sauceService.getAllSauces(); }

    @GetMapping("/active")
    public List<Sauce> getActiveSauces() { return sauceService.getAllActiveSauces(); }

    @PostMapping
    public Sauce createSauce(@RequestBody Sauce sauce) {
        return sauceService.createSauce(sauce);
    }

    @GetMapping("/{id}")
    public Sauce getSauceById(@PathVariable int id) {
        return sauceService.getSauceById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Sauce updateSauce (@PathVariable int id, @RequestBody Sauce sauce) {
        return sauceService.updateSauce(id, sauce);
    }

    @DeleteMapping("/{id}")
    public void deleteSauce(@PathVariable int id) {
        sauceService.deleteSauce(id);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Sauce toggleSauceActive(@PathVariable int id) { return sauceService.toggleSauceActive(id); }

    @GetMapping("/search")
    public List<Sauce> searchSauce(@RequestParam String sauceName) {
        return sauceService.searchSauce(sauceName);
    }
}
