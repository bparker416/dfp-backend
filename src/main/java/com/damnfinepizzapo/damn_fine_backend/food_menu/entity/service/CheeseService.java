package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Cheese;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.CheeseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheeseService {

    private final CheeseRepository cheeseRepository;

    @Autowired
    public CheeseService(CheeseRepository cheeseRepository) { this.cheeseRepository = cheeseRepository; }

    public List<Cheese> findByPriceIsRegular() {
        return cheeseRepository.findByPriceIsRegular();
    }

    public List<Cheese> findByPriceIsOne() {
        return cheeseRepository.findByPriceIsOne();
    }

    public List<Cheese> findByPriceIsTwo() {
        return cheeseRepository.findByPriceIsTwo();
    }

    public List<Cheese> getAllCheese() { return cheeseRepository.findAllActive(); }

    public Cheese createCheese(Cheese cheese) {
        return cheeseRepository.save(cheese);
    }

    public Optional<Cheese> getCheeseById(int id) {
        return cheeseRepository.findById(id);
    }

    public Cheese updateCheese(int id, Cheese cheese) {
        return cheeseRepository.findById(id)
                .map(item -> {
                    item.setCheese_name(cheese.getCheese_name());
                    item.setCheese_price(cheese.getCheese_price());
                    item.setCheese_active(cheese.getCheese_active());
                    return cheeseRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteCheese(int id) {
        cheeseRepository.deleteById(id);
    }

    // Toggle cheese_active
    public Cheese toggleCheeseActive(int id) {
        return cheeseRepository.findById(id)
                .map(item -> {
                    item.setCheese_active(!item.getCheese_active());
                    return cheeseRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }
}