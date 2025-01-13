package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Appetizer;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.AppetizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppetizerService {

    private final AppetizerRepository appetizerRepository;

    @Autowired
    public AppetizerService(AppetizerRepository appetizerRepository) { this.appetizerRepository = appetizerRepository; }

    public List<Appetizer> getAllActiveAppetizer() { return appetizerRepository.findAllActive(); }

    public List<Appetizer> getAllAppetizer() {
        return appetizerRepository.findAll();
    }

    public Appetizer createAppetizer(Appetizer appetizer) {
        return appetizerRepository.save(appetizer);
    }

    public Optional<Appetizer> getAppetizerById(int id) {
        return appetizerRepository.findById(id);
    }

    public Appetizer updateAppetizer(int id, Appetizer appetizer) {
        return appetizerRepository.findById(id)
                .map(item -> {
                    item.setApp_name(appetizer.getApp_name());
                    item.setApp_price(appetizer.getApp_price());
                    item.setApp_description(appetizer.getApp_description());
                    item.setAdditional_text(appetizer.getAdditional_text());
                    item.setAppetizer_active(appetizer.getAppetizer_active());
                    return appetizerRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteAppetizer(int id) {
        appetizerRepository.deleteById(id);
    }

    // Toggle appetizer_active
    public Appetizer toggleAppetizerActive(int id) {
        return appetizerRepository.findById(id)
                .map(item -> {
                    item.setAppetizer_active(!item.getAppetizer_active());
                    return appetizerRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }


}