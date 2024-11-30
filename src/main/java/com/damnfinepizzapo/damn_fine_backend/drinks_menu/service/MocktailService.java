package com.damnfinepizzapo.damn_fine_backend.drinks_menu.service;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Mocktail;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.MocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MocktailService {

    private final MocktailRepository mocktailRepository;

    @Autowired
    public MocktailService(MocktailRepository mocktailRepository) {
        this.mocktailRepository = mocktailRepository;
    }

    public List<Mocktail> getAllMocktails() {
        return mocktailRepository.findAll();
    }
}
