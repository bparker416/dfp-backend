package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Cheese;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.CheeseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Need to update get mapping to group and return by cheese_price

@RestController
@RequestMapping("/api/cheese")
@CrossOrigin(origins = "http://localhost:4200")
public class CheeseController {

    private final CheeseService cheeseService;

    @Autowired
    public CheeseController(CheeseService cheeseService) {this.cheeseService = cheeseService;}

    @GetMapping("/price-is-regular")
    public List<Cheese> findByPriceIsRegular() {return cheeseService.findByPriceIsRegular();}

    @GetMapping("/price-is-one")
    public List<Cheese> findByPriceIsOne() {return cheeseService.findByPriceIsOne();}

    @GetMapping("price-is-two")
    public List<Cheese> findByPriceIsTwo() {return cheeseService.findByPriceIsTwo();}

}
