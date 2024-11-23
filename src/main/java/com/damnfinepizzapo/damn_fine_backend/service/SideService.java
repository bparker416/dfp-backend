package com.damnfinepizzapo.damn_fine_backend.service;

import com.damnfinepizzapo.damn_fine_backend.entity.Side;
import com.damnfinepizzapo.damn_fine_backend.repository.SideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SideService {

    private final SideRepository sideRepository;

    @Autowired
    public SideService(SideRepository sideRepository) { this.sideRepository = sideRepository; }

    public List<Side> getAllSide() {
        return sideRepository.findAll();
    }

}
