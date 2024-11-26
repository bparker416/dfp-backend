package com.damnfinepizzapo.damn_fine_backend.service;

import com.damnfinepizzapo.damn_fine_backend.entity.Cheese;
import com.damnfinepizzapo.damn_fine_backend.repository.CheeseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheeseService {

    private final CheeseRepository cheeseRepository;

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
}
