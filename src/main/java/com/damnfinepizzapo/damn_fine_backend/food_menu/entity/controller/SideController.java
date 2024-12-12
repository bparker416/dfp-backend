package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Side;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.SideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
