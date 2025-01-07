package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.service;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Side;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository.SideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SideService {

    private final SideRepository sideRepository;

    @Autowired
    public SideService(SideRepository sideRepository) { this.sideRepository = sideRepository; }

    public List<Side> getAllSide() {
        return sideRepository.findAll();
    }

    public List<Side> getAllActiveSide() { return sideRepository.findAllActive(); }

    public Side createSide(Side side) {
        return sideRepository.save(side);
    }

    public Optional<Side> getSideById(int id) {
        return sideRepository.findById(id);
    }

    public void deleteSide(int id) {
        sideRepository.deleteById(id);
    }

    public Side updateSide(int id, Side side) {
        return sideRepository.findById(id)
                .map(item -> {
                    item.setSide_name(side.getSide_name());
                    item.setSide_price(side.getSide_price());
                    item.setSide_description(side.getSide_description());
                    item.setAdditional_text(side.getAdditional_text());
                    item.setSide_active(side.getSide_active());
                    return sideRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }

    // Toggle side_active
    public Side toggleSideActive(int id) {
        return sideRepository.findById(id)
                .map(item -> {
                    item.setSide_active(!item.getSide_active());
                    return sideRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found."));
    }
}