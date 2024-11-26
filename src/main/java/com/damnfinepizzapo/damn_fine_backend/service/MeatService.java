package com.damnfinepizzapo.damn_fine_backend.service;

import com.damnfinepizzapo.damn_fine_backend.entity.Meat;
import com.damnfinepizzapo.damn_fine_backend.repository.MeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeatService {

    private final MeatRepository meatRepository;

    public MeatService(MeatRepository meatRepository) { this.meatRepository = meatRepository; }

    public List<Meat> findByPriceIsThree() {
        return meatRepository.findByPriceIsThree();
    }

    public List<Meat> findByPriceIsFour() {
        return meatRepository.findByPriceIsFour();
    }
}
