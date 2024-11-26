package com.damnfinepizzapo.damn_fine_backend.controller;

import com.damnfinepizzapo.damn_fine_backend.entity.Veggie;
import com.damnfinepizzapo.damn_fine_backend.service.VeggieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class VeggieController {

    private final VeggieService veggieService;

    @Autowired
    public VeggieController(VeggieService veggieService) { this.veggieService = veggieService; }

    @GetMapping("/veggie")
    public List<Veggie> getVeggies() { return veggieService.getAllVeggies(); }

}
