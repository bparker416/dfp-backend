package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Side;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.SideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "http://localhost:4200")
public class SideController {

    private final SideService sideService;

    @Autowired
    public SideController(SideService sideService) { this.sideService = sideService; }

    @GetMapping("/side")
    public List<Side> getAllSide() { return sideService.getAllSide(); }

    @PostMapping
    public Side creteSide(@RequestBody Side side) {
        return sideService.createSide(side);
    }

    @GetMapping("/{id}")
    public Side getAppetizerById(@PathVariable int id) {
        return sideService.getSideById(id).orElseThrow(
                () -> new RuntimeException("Item not found.")
        );
    }

    @PutMapping("/{id}")
    public Side updateSide(@PathVariable int id, @RequestBody Side side) {
        return sideService.updateSide(id, side);
    }

    @DeleteMapping("/{id}")
    public void deleteSide(@PathVariable int id) {
        sideService.deleteSide(id);
    }

    // Endpoint for isActive_toggle
    @PutMapping("/{id}/toggle")
    public Side toggleSideActive(@PathVariable int id) { return sideService.toggleSideActive(id); }

}
