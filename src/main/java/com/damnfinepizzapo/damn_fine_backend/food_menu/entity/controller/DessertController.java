package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Dessert;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class DessertController {

    private final DessertService dessertService;

    @Autowired
    public DessertController(DessertService dessertService) { this.dessertService = dessertService; }

    @GetMapping("/dessert")
    public List<Dessert> getDesserts() { return dessertService.getAllDesserts(); }

}
