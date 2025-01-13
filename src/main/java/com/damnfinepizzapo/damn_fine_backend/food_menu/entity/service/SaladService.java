package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Salad;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.SaladRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaladService {

    private final SaladRepository saladRepository;

    @Autowired
    public SaladService(SaladRepository saladRepository) { this.saladRepository = saladRepository; }

    public List<Salad> getAllSalads() { return saladRepository.findAll(); }

    public List<Salad> getAllActiveSalads() { return saladRepository.findAllActive(); }

    public Salad createSalad(Salad salad) {
        return saladRepository.save(salad);
    }

    public Optional<Salad> getSaladById(int id) {
        return saladRepository.findById(id);
    }

    public Salad updateSalad(int id, Salad salad) {
        return saladRepository.findById(id)
                .map(item -> {
                    item.setSalad_name(salad.getSalad_name());
                    item.setSmall_price(salad.getSmall_price());
                    item.setLarge_price(salad.getLarge_price());
                    item.setSalad_description(salad.getSalad_description());
                    item.setAdditional_text(salad.getAdditional_text());
                    item.setSalad_active(salad.getSalad_active());
                    return saladRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteSalad(int id) {
        saladRepository.deleteById(id);
    }

    // Toggle salad_active
    public Salad toggleSaladActive(int id) {
        return saladRepository.findById(id)
                .map(item -> {
                    item.setSalad_active(!item.getSalad_active());
                    return saladRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

}