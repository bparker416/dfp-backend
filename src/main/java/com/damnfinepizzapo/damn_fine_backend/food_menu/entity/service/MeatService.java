package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Meat;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.MeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
