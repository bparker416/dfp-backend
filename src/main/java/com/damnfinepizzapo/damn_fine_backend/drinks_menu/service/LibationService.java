package com.damnfinepizzapo.damn_fine_backend.drinks_menu.service;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Libation;
import com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository.LibationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Libation createLibation(Libation libation) {
        return libationRepository.save(libation);
    }

    public Optional<Libation> getLibationById(int id) {
        return libationRepository.findById(id);
    }

    public Libation updateLibation(int id, Libation libation) {
        return libationRepository.findById(id)
                .map(item -> {
                    item.setLibation_name(libation.getLibation_name());
                    item.setLibation_price(libation.getLibation_price());
                    item.setLibation_description(libation.getLibation_description());
                    item.setLibation_active(libation.isLibation_active());
                    return libationRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteLibation(int id) {
        libationRepository.deleteById(id);
    }

    // Toggle libation_active
    public Libation toggleLibationActive(int id) {
        return libationRepository.findById(id)
                .map(item -> {
                    item.setLibation_active(!item.isLibation_active());
                    return libationRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }
}
