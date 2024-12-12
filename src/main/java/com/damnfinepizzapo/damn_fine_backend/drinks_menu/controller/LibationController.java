package com.damnfinepizzapo.damn_fine_backend.drinks_menu.controller;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Libation;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.service.LibationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "http://localhost:4200")
public class LibationController {

    private final LibationService libationService;

    @Autowired
    public LibationController(LibationService libationService) { this.libationService = libationService; }

    @GetMapping("seasonal-libations")
    public List<Libation> getAllLibations() { return libationService.getLibations(); }
}
