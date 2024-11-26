package com.damnfinepizzapo.damn_fine_backend.service;

import com.damnfinepizzapo.damn_fine_backend.entity.Salad;
import com.damnfinepizzapo.damn_fine_backend.repository.SaladRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaladService {

    private final SaladRepository saladRepository;

    public SaladService(SaladRepository saladRepository) { this.saladRepository = saladRepository; }

    public List<Salad> getAllSalads() { return saladRepository.findAll(); }
}
