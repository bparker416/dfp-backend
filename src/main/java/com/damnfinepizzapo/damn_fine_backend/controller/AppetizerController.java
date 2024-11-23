package com.damnfinepizzapo.damn_fine_backend.controller;

import com.damnfinepizzapo.damn_fine_backend.entity.Appetizer;
import com.damnfinepizzapo.damn_fine_backend.service.AppetizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class AppetizerController {

    private final AppetizerService appetizerService;

    @Autowired
    public AppetizerController(AppetizerService appetizerService) { this.appetizerService = appetizerService; }

    @GetMapping("/appetizer")
    public List<Appetizer> getAllAppetizer() { return appetizerService.getAllAppetizer(); }

}
