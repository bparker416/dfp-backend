package com.damnfinepizzapo.damn_fine_backend.controller;

import com.damnfinepizzapo.damn_fine_backend.entity.Sauce;
import com.damnfinepizzapo.damn_fine_backend.service.SauceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost/4200")
public class SauceController {

    private final SauceService sauceService;

    @Autowired
    public SauceController(SauceService sauceService) { this.sauceService = sauceService; }

    @GetMapping("/sauce")
    public List<Sauce> getSauces() { return sauceService.getAllSauces(); }

}
