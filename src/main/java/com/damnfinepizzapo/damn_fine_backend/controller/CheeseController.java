package com.damnfinepizzapo.damn_fine_backend.controller;

import com.damnfinepizzapo.damn_fine_backend.entity.Cheese;
import com.damnfinepizzapo.damn_fine_backend.service.CheeseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Need to update get mapping to group and return by cheese_price
/*
@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class CheeseController {

    private final CheeseService cheeseService;

    @Autowired
    public CheeseController(CheeseService cheeseService) {this.cheeseService = cheeseService;}

    @GetMapping("/cheese")
    public List<Cheese> getAllCheese() {return cheeseService.getAllCheese();}

}
*/