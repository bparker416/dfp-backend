package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Veggie;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.VeggieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeggieService {

    private final VeggieRepository veggieRepository;

    @Autowired
    public VeggieService(VeggieRepository veggieRepository) { this.veggieRepository = veggieRepository; }

    public List<Veggie> getAllVeggies() {
        return veggieRepository.findAllVeggies();
    }

}
