package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Dessert;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.DessertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DessertService {

    private final DessertRepository dessertRepository;

    @Autowired
    public DessertService(DessertRepository dessertRepository) { this.dessertRepository = dessertRepository; }

    public List<Dessert> getAllDesserts() { return dessertRepository.findAllActive(); }

}
