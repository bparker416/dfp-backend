package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Meat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeatRepository extends JpaRepository<Meat, Integer> {
    @Query("SELECT m FROM Meat m WHERE m.meat_price = 3 AND m.meat_active = true")
    List<Meat> findByPriceIsThree();
    @Query("SELECT m FROM Meat m WHERE m.meat_price = 4 AND m.meat_active = true")
    List<Meat> findByPriceIsFour();
}
