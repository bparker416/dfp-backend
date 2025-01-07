package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Dessert;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.DessertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DessertService {

    private final DessertRepository dessertRepository;

    @Autowired
    public DessertService(DessertRepository dessertRepository) { this.dessertRepository = dessertRepository; }

    public List<Dessert> getAllDesserts() { return dessertRepository.findAll(); }

    public List<Dessert> GetAllActiveDesserts() { return dessertRepository.findAllActive(); }

    public Dessert createDessert(Dessert dessert) { return dessertRepository.save(dessert); }

    public Optional<Dessert> getDessertById(int id) { return dessertRepository.findById(id); }

    public Dessert updateDessert(int id, Dessert dessert) {
        return dessertRepository.findById(id)
                .map(item -> {
                    item.setDessert_name(dessert.getDessert_name());
                    item.setDessert_price(dessert.getDessert_price());
                    item.setDessert_description(dessert.getDessert_description());
                    item.setAdditional_text(dessert.getAdditional_text());
                    item.setDessert_active(dessert.getDessert_active());
                    return dessertRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteDessert(int id) {
        dessertRepository.deleteById(id);
    }

    // Toggle dessert_active
    public Dessert toggleDessertActive(int id) {
        return dessertRepository.findById(id)
                .map(item -> {
                    item.setDessert_active(!item.getDessert_active());
                    return dessertRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

}