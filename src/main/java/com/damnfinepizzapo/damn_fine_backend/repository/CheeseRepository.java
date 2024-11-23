package com.damnfinepizzapo.damn_fine_backend.repository;

import com.damnfinepizzapo.damn_fine_backend.entity.Cheese;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheeseRepository extends JpaRepository<Cheese, Integer> {
}
