package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Appetizer;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.AppetizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppetizerService {

    private final AppetizerRepository appetizerRepository;

    @Autowired
    public AppetizerService(AppetizerRepository appetizerRepository) { this.appetizerRepository = appetizerRepository; }

    public List<Appetizer> getAllAppetizer() {
        return appetizerRepository.findAllAppetizer();
    }

}
