package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Meat;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.MeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/meat")
@CrossOrigin(origins = "http://localhost:4200")
public class MeatController {

    private final MeatService meatService;

    @Autowired
    public MeatController(MeatService meatService) { this.meatService = meatService; }

    @GetMapping("price-is-three")
    public List<Meat> findByPriceIsThree() { return meatService.findByPriceIsThree(); }

    @GetMapping("price-is-four")
    public List<Meat> findByPriceIsFour() { return meatService.findByPriceIsFour(); }

}
