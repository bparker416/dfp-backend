package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Veggie;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.VeggieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeggieService {

    private final VeggieRepository veggieRepository;

    @Autowired
    public VeggieService(VeggieRepository veggieRepository) { this.veggieRepository = veggieRepository; }

    public List<Veggie> getAllVeggies() {
        return veggieRepository.findAll();
    }

    public List<Veggie> getAllActiveVeggies() { return veggieRepository.findAllActive(); }

    public Veggie createVeggie(Veggie veggie) {
        return veggieRepository.save(veggie);
    }

    public Optional<Veggie> getVeggieById(int id) {
        return veggieRepository.findById(id);
    }

    public Veggie updateVeggie(int id, Veggie veggie) {
        return veggieRepository.findById(id)
                .map(item -> {
                    item.setVeggie_name(veggie.getVeggie_name());
                    item.setVeggie_description(veggie.getVeggie_description());
                    item.setVeggie_active(veggie.isVeggie_active());
                    return veggieRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteVeggie(int id) {
        veggieRepository.deleteById(id);
    }

    // Toggle veggie_active
    public Veggie toggleVeggieActive(int id) {
        return veggieRepository.findById(id)
                .map(item -> {
                    item.setVeggie_active(!item.isVeggie_active());
                    return veggieRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }
}