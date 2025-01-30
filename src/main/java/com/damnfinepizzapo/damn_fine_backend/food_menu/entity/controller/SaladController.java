package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Salad;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.SaladService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/salad")
@CrossOrigin(origins = "https://dfp-website-git-main-brandons-projects-bc9e4d60.vercel.app/")
public class SaladController {

    private final SaladService saladService;

    @Autowired
    public SaladController(SaladService saladService) { this.saladService = saladService; }

    @GetMapping("/all")
    public List<Salad> getSalads() { return saladService.getAllSalads(); }

    @GetMapping("/active")
    public List<Salad> getActiveSalads() { return saladService.getAllActiveSalads(); }

    @PostMapping
    public Salad createSalad(@RequestBody Salad salad) {
        return saladService.createSalad(salad);
    }

    @GetMapping("/{id}")
    public Salad getSaladById(@PathVariable int id) {
        return saladService.getSaladById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Salad updateSalad(@PathVariable int id, @RequestBody Salad salad) {
        return saladService.updateSalad(id, salad);
    }

    @DeleteMapping("/{id}")
    public void deleteSalad(@PathVariable int id) {
        saladService.deleteSalad(id);
    }

    // Endpoint for isActive body
    @PutMapping("/{id}/toggle")
    public Salad toggleSaladActive(@PathVariable int id) {
        return saladService.toggleSaladActive(id);
    }
}