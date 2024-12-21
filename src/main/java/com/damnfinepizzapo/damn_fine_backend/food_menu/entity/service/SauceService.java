package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Sauce;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.SauceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SauceService {

    private final SauceRepository sauceRepository;

    @Autowired
    public SauceService(SauceRepository sauceRepository) { this.sauceRepository = sauceRepository; }

    public List<Sauce> getAllSauces() {
        return sauceRepository.findAllActive();
    }

    public Sauce createSauce(Sauce sauce) {
        return sauceRepository.save(sauce);
    }

    public Optional<Sauce> getSauceById(int id) {
        return sauceRepository.findById(id);
    }

    public Sauce updateSauce(int id, Sauce sauce) {
        return sauceRepository.findById(id)
                .map(item -> {
                    item.setSauce_name(sauce.getSauce_name());
                    item.setSauce_active(sauce.isSauce_active());
                    return sauceRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteSauce(int id) {
        sauceRepository.deleteById(id);
    }

    // Toggle sauce_active
    public Sauce toggleSauceActive(int id) {
        return sauceRepository.findById(id)
                .map(item -> {
                    item.setSauce_active(!item.isSauce_active());
                    return sauceRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }
}
