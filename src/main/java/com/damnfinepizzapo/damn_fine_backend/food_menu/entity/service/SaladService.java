package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Salad;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.SaladRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaladService {

    private final SaladRepository saladRepository;

    @Autowired
    public SaladService(SaladRepository saladRepository) { this.saladRepository = saladRepository; }

    public List<Salad> getAllSalads() { return saladRepository.findAllSaladActive(); }
}
