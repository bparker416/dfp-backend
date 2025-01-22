package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Sando;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.SandoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/sando")
@CrossOrigin(origins = "https://bparker416.github.io")
public class SandoController {

    private final SandoService sandoService;

    @Autowired
    public SandoController(SandoService sandoService) { this.sandoService = sandoService; }

    @GetMapping("/all")
    public List<Sando> getAllSandos() { return sandoService.getAllSandos(); }

    @GetMapping("/active")
    public List<Sando> getActiveSandos() { return sandoService.getAllActiveSandos(); }

    @PostMapping
    public Sando createSando(@RequestBody Sando sando) {
        return sandoService.createSando(sando);
    }

    @GetMapping("/{id}")
    public Sando getSandoById(@PathVariable int id) {
        return sandoService.getSandoById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Sando updateSando(@PathVariable int id, @RequestBody Sando sando) {
        return sandoService.updateSando(id, sando);
    }

    @DeleteMapping("/{id}")
    public void deleteSando(@PathVariable int id) {
        sandoService.deleteSando(id);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Sando toggleSandoActive(@PathVariable int id) { return sandoService.toggleSandoActive(id); }
}