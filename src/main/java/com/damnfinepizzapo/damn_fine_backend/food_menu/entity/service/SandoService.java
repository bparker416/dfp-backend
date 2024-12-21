package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Sando;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.SandoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SandoService {

    private final SandoRepository sandoRepository;

    public SandoService(SandoRepository sandoRepository) { this.sandoRepository = sandoRepository; }

    public List<Sando> getAllSandos() {
        return sandoRepository.findAllActive();
    }

    public Sando createSando(Sando sando) {
        return sandoRepository.save(sando);
    }

    public Optional<Sando> getSandoById(int id) {
        return sandoRepository.findById(id);
    }

    public Sando updateSando(int id, Sando sando) {
        return sandoRepository.findById(id)
                .map(item -> {
                    item.setSando_name(sando.getSando_name());
                    item.setSando_price(sando.getSando_price());
                    item.setSando_description(sando.getSando_description());
                    item.setAdditional_text(sando.getAdditional_text());
                    item.setSando_active(sando.isSando_active());
                    return sandoRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    public void deleteSando(int id) {
        sandoRepository.deleteById(id);
    }

    // Toggle sando_active
    public Sando toggleSandoActive(int id) {
        return sandoRepository.findById(id)
                .map(item -> {
                    item.setSando_active(!item.isSando_active());
                    return sandoRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }
}