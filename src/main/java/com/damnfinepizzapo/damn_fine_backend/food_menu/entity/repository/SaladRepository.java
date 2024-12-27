package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Salad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaladRepository extends JpaRepository<Salad, Integer> {
    @Query("SELECT s FROM Salad s WHERE s.salad_active = true")
    List<Salad> findAllActive();
}
