package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Sando;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.SandoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandoService {

    private final SandoRepository sandoRepository;

    public SandoService(SandoRepository sandoRepository) { this.sandoRepository = sandoRepository; }

    public List<Sando> getAllSandos() {
        return sandoRepository.findAllActive();
    }
}
