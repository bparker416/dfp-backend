package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Sauce;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.SauceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SauceService {

    private final SauceRepository sauceRepository;

    @Autowired
    public SauceService(SauceRepository sauceRepository) { this.sauceRepository = sauceRepository; }

    public List<Sauce> getAllSauces() {
        return sauceRepository.findAllActive();
    }
}
