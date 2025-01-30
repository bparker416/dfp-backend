package com.damnfinepizzapo.damn_fine_backend.drinks_menu.controller;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Libation;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.service.LibationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/seasonal-libations")
@CrossOrigin(origins = "https://dfp-website-git-main-brandons-projects-bc9e4d60.vercel.app/")
public class LibationController {

    private final LibationService libationService;

    @Autowired
    public LibationController(LibationService libationService) { this.libationService = libationService; }

    @GetMapping("/all")
    public List<Libation> getAllLibations() { return libationService.getLibations(); }

    @GetMapping("/active")
    public List<Libation> getActiveLibations() { return libationService.getAllActiveLibations(); }

    @PutMapping
    public Libation createLibation(@RequestBody Libation libation) {
        return libationService
                .createLibation(libation);
    }

    @GetMapping("/{id}")
    public Libation getLibationById(@PathVariable int id) {
        return libationService.getLibationById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Libation updateLibation(@PathVariable int id, @RequestBody Libation libation) {
        return libationService.updateLibation(id, libation);
    }

    @DeleteMapping("/{id}")
    public void deleteLibation(@PathVariable int id) {
        libationService.deleteLibation(id);
    }

    // Endpoint for isActive toggle
    @PutMapping("/{id}/toggle")
    public Libation toggleLibationActive(@PathVariable int id) { return libationService.toggleLibationActive(id); }
}
