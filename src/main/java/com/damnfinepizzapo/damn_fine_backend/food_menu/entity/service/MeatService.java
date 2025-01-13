package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Meat;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.MeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeatService {

    private final MeatRepository meatRepository;

    @Autowired
    public MeatService(MeatRepository meatRepository) { this.meatRepository = meatRepository; }

    public List<Meat> findByPriceIsThree() {
        return meatRepository.findByPriceIsThree();
    }

    public List<Meat> findByPriceIsFour() {
        return meatRepository.findByPriceIsFour();
    }

    public List<Meat> getAllMeat() { return meatRepository.findAll(); }

    public List<Meat> getAllActiveMeat() { return meatRepository.findAllActive(); }

    public Meat createMeat(Meat meat) { return meatRepository.save(meat); }

    public Optional<Meat> getMeatById(int id) { return meatRepository.findById(id); }

    public Meat updateMeat(int id, Meat meat) {
        return meatRepository.findById(id)
                .map(item -> {
                    item.setMeat_name(meat.getMeat_name());
                    item.setMeat_price(meat.getMeat_price());
                    item.setMeat_description(meat.getMeat_description());
                    item.setMeat_active(meat.isMeat_active());
                    return meatRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteMeat(int id) { meatRepository.deleteById(id); }

    // Toggle meat_active
    public Meat toggleMeatActive(int id) {
        return meatRepository.findById(id)
                .map(item -> {
                    item.setMeat_active(!item.isMeat_active());
                    return meatRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }
}