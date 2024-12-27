package com.damnfinepizzapo.damn_fine_backend.drinks_menu.service;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Drink;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAllActive();
    }

    public Drink createDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    public Optional<Drink> getDrinkById(int id) {
        return drinkRepository.findById(id);
    }

    public Drink updateDrink(int id, Drink drink) {
        return drinkRepository.findById(id)
                .map(item -> {
                    item.setDrink_name(drink.getDrink_name());
                    item.setDrink_price(drink.getDrink_price());
                    item.setDrink_description(drink.getDrink_description());
                    item.setDrink_active(drink.isDrink_active());
                    return drinkRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteDrink(int id) {
        drinkRepository.deleteById(id);
    }

    // Toggle drink_active
    public Drink toggleDrinkActive(int id) {
        return drinkRepository.findById(id)
                .map(item -> {
                    item.setDrink_active(!item.isDrink_active());
                    return drinkRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }
}