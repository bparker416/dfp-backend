package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Salad;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.SaladService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "http://localhost:4200")
public class SaladController {

    private final SaladService saladService;

    @Autowired
    public SaladController(SaladService saladService) { this.saladService = saladService; }

    @GetMapping("/salad")
    public List<Salad> getSalads() { return saladService.getAllSalads(); }
}
