package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.controller;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Sando;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service.SandoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class SandoController {

    private final SandoService sandoService;

    @Autowired
    public SandoController(SandoService sandoService) { this.sandoService = sandoService; }

    @GetMapping("/sando")
    public List<Sando> getAllSandos() { return sandoService.getAllSandos(); }

}
