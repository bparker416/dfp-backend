package com.damnfinepizzapo.damn_fine_backend.service;

import com.damnfinepizzapo.damn_fine_backend.entity.Veggie;
import com.damnfinepizzapo.damn_fine_backend.repository.VeggieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeggieService {

    private final VeggieRepository veggieRepository;

    @Autowired
    public VeggieService(VeggieRepository veggieRepository) { this.veggieRepository = veggieRepository; }

    public List<Veggie> getAllVeggies() {
        return veggieRepository.findAll();
    }

}
