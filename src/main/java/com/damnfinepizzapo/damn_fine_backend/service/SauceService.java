package com.damnfinepizzapo.damn_fine_backend.service;

import com.damnfinepizzapo.damn_fine_backend.entity.Sauce;
import com.damnfinepizzapo.damn_fine_backend.repository.SauceRepository;

import java.util.List;

public class SauceService {

    private final SauceRepository sauceRepository;

    public SauceService(SauceRepository sauceRepository) { this.sauceRepository = sauceRepository; }

    public List<Sauce> getAllSauces() {
        return sauceRepository.findAll();
    }
}
