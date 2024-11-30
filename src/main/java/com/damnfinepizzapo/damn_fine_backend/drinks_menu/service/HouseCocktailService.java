package com.damnfinepizzapo.damn_fine_backend.drinks_menu.service;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.HouseCocktail;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.HouseCocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseCocktailService {

    private final HouseCocktailRepository houseCocktailRepository;

    @Autowired
    public HouseCocktailService(HouseCocktailRepository houseCocktailRepository) {
        this.houseCocktailRepository = houseCocktailRepository;
    }

    public List<HouseCocktail> getAllHouseCocktails() {
        return houseCocktailRepository.findAll();
    }
}
