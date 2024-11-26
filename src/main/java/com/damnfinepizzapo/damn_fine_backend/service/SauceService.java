package com.damnfinepizzapo.damn_fine_backend.service;

import com.damnfinepizzapo.damn_fine_backend.entity.Sauce;
import com.damnfinepizzapo.damn_fine_backend.repository.SauceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SauceService {

    private final SauceRepository sauceRepository;

    @Autowired
    public SauceService(SauceRepository sauceRepository) { this.sauceRepository = sauceRepository; }

    public List<Sauce> getAllSauces() {
        return sauceRepository.findAll();
    }
}
