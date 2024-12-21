package com.damnfinepizzapo.damn_fine_backend.drinks_menu.service;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Mocktail;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.MocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Mocktail createMocktail(Mocktail mocktail) {
        return mocktailRepository.save(mocktail);
    }

    public Optional<Mocktail> getMocktailById(int id) {
        return mocktailRepository.findById(id);
    }

    public Mocktail updateMocktail(int id, Mocktail mocktail) {
        return mocktailRepository.findById(id)
                .map(item -> {
                    item.setMocktail_name(mocktail.getMocktail_name());
                    item.setMocktail_price(mocktail.getMocktail_price());
                    item.setMocktail_description(mocktail.getMocktail_description());
                    item.setMocktail_active(mocktail.isMocktail_active());
                    return mocktailRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteMocktail(int id) {
        mocktailRepository.deleteById(id);
    }

    // Toggle mocktail_active
    public Mocktail toggleMocktailActive(int id) {
        return mocktailRepository.findById(id)
                .map(item -> {
                    item.setMocktail_active(!item.isMocktail_active());
                    return mocktailRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }
}