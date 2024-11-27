package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Sando;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SandoRepository extends JpaRepository<Sando, Integer> {
    @Query("SELECT s FROM Sando s WHERE s.sando_active = true")
    List<Sando> findAllActive();
}
