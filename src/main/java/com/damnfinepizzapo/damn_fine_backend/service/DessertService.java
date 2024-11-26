package com.damnfinepizzapo.damn_fine_backend.service;

import com.damnfinepizzapo.damn_fine_backend.entity.Dessert;
import com.damnfinepizzapo.damn_fine_backend.repository.DessertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DessertService {

    private final DessertRepository dessertRepository;

    public DessertService(DessertRepository dessertRepository) { this.dessertRepository = dessertRepository; }

    public List<Dessert> getAllDesserts() { return dessertRepository.findAll(); }

}
