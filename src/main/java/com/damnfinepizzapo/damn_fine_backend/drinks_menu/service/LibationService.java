package com.damnfinepizzapo.damn_fine_backend.drinks_menu.service;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Libation;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.LibationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibationService {

    private final LibationRepository libationRepository;

    @Autowired
    public LibationService(LibationRepository libationRepository) {
        this.libationRepository = libationRepository;
    }

    public List<Libation> getLibations() {
        return libationRepository.findAll();
    }
}
