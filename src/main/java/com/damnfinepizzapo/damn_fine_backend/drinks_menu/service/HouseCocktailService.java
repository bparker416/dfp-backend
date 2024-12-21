package com.damnfinepizzapo.damn_fine_backend.drinks_menu.service;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.HouseCocktail;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.HouseCocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public HouseCocktail createHouseCocktail(HouseCocktail houseCocktail) {
        return houseCocktailRepository.save(houseCocktail);
    }

    public Optional<HouseCocktail> getHouseCocktailById(int id) {
        return houseCocktailRepository.findById(id);
    }

    public HouseCocktail updateHouseCocktail(int id, HouseCocktail houseCocktail) {
        return houseCocktailRepository.findById(id)
                .map(item -> {
                    item.setCocktail_name(houseCocktail.getCocktail_name());
                    item.setCocktail_price(houseCocktail.getCocktail_price());
                    item.setCocktail_description(houseCocktail.getCocktail_description());
                    item.setCocktail_active(houseCocktail.isCocktail_active());
                    return houseCocktailRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteHouseCocktail(int id) {
        houseCocktailRepository.deleteById(id);
    }

    // Toggle HouseCocktail isActive
    public HouseCocktail toggleHouseCocktailActive(int id) {
        return houseCocktailRepository.findById(id)
                .map(item -> {
                    item.setCocktail_active(!item.isCocktail_active());
                    return houseCocktailRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }
}
