package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Veggie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeggieRepository extends JpaRepository<Veggie, Integer> {
    @Query("SELECT v FROM Veggie v WHERE v.veggie_active = true")
    List<Veggie> findAllActive();
}
