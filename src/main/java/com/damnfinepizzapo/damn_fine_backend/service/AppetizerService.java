package com.damnfinepizzapo.damn_fine_backend.service;

import com.damnfinepizzapo.damn_fine_backend.entity.Appetizer;
import com.damnfinepizzapo.damn_fine_backend.repository.AppetizerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppetizerService {

    private final AppetizerRepository appetizerRepository;

    public AppetizerService(AppetizerRepository appetizerRepository) { this.appetizerRepository = appetizerRepository; }

    public List<Appetizer> getAllAppetizer() {
        return appetizerRepository.findAll();
    }

}
