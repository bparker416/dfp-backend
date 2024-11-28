package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Sauce;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.SauceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sauce/")
@CrossOrigin(origins = "http://localhost:4200")
public class SauceController {

    private final SauceService sauceService;

    @Autowired
    public SauceController(SauceService sauceService) { this.sauceService = sauceService; }

    @GetMapping("sauce-active")
    public List<Sauce> getSauces() { return sauceService.getAllSauces(); }

}
